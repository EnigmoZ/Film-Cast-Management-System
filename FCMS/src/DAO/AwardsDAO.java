package DAO;

import Models.Awards;
import Utilities.Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AwardsDAO {
    public void addAward(Awards award) throws SQLException{
        String sql = "INSERT INTO film(name, category, year)" +
                " VALUES (?, ?, ?)";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, award.getName());
            ps.setString(2, award.getCategory());
            ps.setString(3, award.getYear());
            ps.executeUpdate();
        }
    }

    public List<Awards> getAllAwards() throws SQLException{
        List<Awards> awards = new ArrayList<>();
        String sql = "select * from award";
        try(Connection con = Utilities.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Awards award = new Awards();
                award.setId(rs.getInt("id"));
                award.setName(rs.getString("name"));
                award.setCategory(rs.getString("category"));
                award.setYear((rs.getString("year")));
                awards.add(award);
            }
        }
        return awards;
    }

    public Awards getAwardsById(int id) throws SQLException {
        String sql = "SELECT * FROM award WHERE id=?";
        Awards award = null;

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    award = new Awards();
                    award.setId(rs.getInt("id"));
                    award.setName(rs.getString("name"));
                    award.setCategory(rs.getString("Category"));
                    award.setYear((rs.getString("year")));
                }
            }

            return award;
        }
    }

    public void updateAwards(Awards award) throws SQLException {
        String sql = "UPDATE award SET name = ?, department = ?, salary = ? WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, award.getName());
            ps.setString(2, award.getCategory());
            ps.setString(3, award.getYear());
            ps.setInt(4, award.getId());
            ps.executeUpdate();
        }
    }

    public void deleteAwards(int id) throws SQLException {
        String sql = "DELETE FROM award WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        }
    }
}
