package Services;
import DAO.ReviewsDAO;
import Models.Reviews;

import java.sql.SQLException;
import java.util.List;

public class ReviewsServices {
    private ReviewsDAO reviewDAO;

    public ReviewsServices() {
        this.reviewDAO = new ReviewsDAO();
    }

    public void addReview(Reviews review) throws SQLException {
        reviewDAO.addReview(review);
    }

    public List<Reviews> getAllReviews() throws SQLException {
        return reviewDAO.getAllReviews();
    }

    public Reviews searchReviewById(int id) throws SQLException {
        return reviewDAO.searchReviewById(id);
    }

    public void updateReview(Reviews review) throws SQLException {
        reviewDAO.updateReview(review);
    }

    public void deleteReview(int reviewId) throws SQLException {
        reviewDAO.deleteReview(reviewId);
    }
}
