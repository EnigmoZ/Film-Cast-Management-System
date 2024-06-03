package DAO;

import Models.Reviews;
import Utilities.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewsDAO {
    public void addReview(Reviews review) throws SQLException {
        String sql = "INSERT INTO review(filmid, userid, rating, comment, reviewdate)" +
                " VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, review.getFilmId());
            ps.setInt(2, review.getUserId());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComment());
            ps.setString(5, review.getReviewDate());
            ps.executeUpdate();
        }
    }

    public List<Reviews> getAllReviews() throws SQLException {
        List<Reviews> reviews = new ArrayList<>();
        String sql = "SELECT * FROM review";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()) {
                Reviews review = new Reviews();
                review.setId(rs.getInt("id"));
                review.setFilmId(rs.getInt("filmid"));
                review.setUserId(rs.getInt("userid"));
                review.setRating(rs.getInt("rating"));
                review.setComment(rs.getString("comment"));
                review.setReviewDate(rs.getString("reviewdate"));
                reviews.add(review);
            }
        }
        return reviews;
    }

    public Reviews getReviewsById(int id) throws SQLException {
        String sql = "SELECT * FROM review WHERE id=?";
        Reviews review = null;

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    review = new Reviews();
                    review.setId(rs.getInt("id"));
                    review.setFilmId(rs.getInt("filmid"));
                    review.setUserId(rs.getInt("userid"));
                    review.setRating(rs.getInt("rating"));
                    review.setComment(rs.getString("comment"));
                    review.setReviewDate(rs.getString("reviewdate"));
                }
            }

            return review;
        }
    }

    public void updateReviews(Reviews review) throws SQLException {
        String sql = "UPDATE review SET filmid=?, userid=?, rating=?, comment=?, reviewdate=? WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, review.getFilmId());
            ps.setInt(2, review.getUserId());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComment());
            ps.setString(5, review.getReviewDate());
            ps.setInt(6, review.getId());
            ps.executeUpdate();
        }
    }

    public void deleteReviews(int id) throws SQLException {
        String sql = "DELETE FROM review WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        }
    }
}
