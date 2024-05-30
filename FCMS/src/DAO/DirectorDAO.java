package DAO;

import Models.Directors;
import Utilities.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAO {
    public void addDirector(Directors director) throws SQLException {
        String sql = "INSERT INTO director(name, dob, nationality)" +
                " VALUES (?, ?, ?)";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, director.getName());
            ps.setString(2, director.getDob());
            ps.setString(3, director.getNationality());
            ps.executeUpdate();
        }
    }

    public List<Directors> getAllDirectors() throws SQLException {
        List<Directors> directors = new ArrayList<>();
        String sql = "SELECT * FROM director";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()) {
                Directors director = new Directors();
                director.setId(rs.getInt("id"));
                director.setName(rs.getString("name"));
                director.setDob(rs.getString("dob"));
                director.setNationality(rs.getString("nationality"));
                directors.add(director);
            }
        }
        return directors;
    }

    public Directors getDirectorsById(int id) throws SQLException {
        String sql = "SELECT * FROM director WHERE id=?";
        Directors director = null;

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    director = new Directors();
                    director.setId(rs.getInt("id"));
                    director.setName(rs.getString("name"));
                    director.setDob(rs.getString("dob"));
                    director.setNationality(rs.getString("nationality"));
                }
            }

            return director;
        }
    }

    public void updateDirectors(Directors director) throws SQLException {
        String sql = "UPDATE director SET name = ?, department = ?, salary = ? WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, director.getName());
            ps.setString(2, director.getDob());
            ps.setString(3, director.getNationality());
            ps.setInt(4, director.getId());
            ps.executeUpdate();
        }
    }

    public void deleteDirectors(int id) throws SQLException {
        String sql = "DELETE FROM director WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        }
    }
}
