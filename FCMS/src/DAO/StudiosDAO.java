package DAO;

import Models.Studios;
import Utilities.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudiosDAO {
    public void addStudio(Studios studio) throws SQLException {
        String sql = "INSERT INTO studio(name, country)" +
                " VALUES (?, ?)";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, studio.getName());
            ps.setString(2, studio.getCountry());
            ps.executeUpdate();
        }
    }

    public List<Studios> getAllStudios() throws SQLException {
        List<Studios> studios = new ArrayList<>();
        String sql = "SELECT * FROM studio";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()) {
                Studios studio = new Studios();
                studio.setId(rs.getInt("id"));
                studio.setName(rs.getString("name"));
                studio.setCountry(rs.getString("country"));
                studios.add(studio);
            }
        }
        return studios;
    }

    public Studios getStudiosById(int id) throws SQLException {
        String sql = "SELECT * FROM studio WHERE id=?";
        Studios studio = null;

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    studio = new Studios();
                    studio.setId(rs.getInt("id"));
                    studio.setName(rs.getString("name"));
                    studio.setCountry(rs.getString("country"));

                }
            }

            return studio;
        }
    }

    public void updateStudios(Studios studio) throws SQLException {
        String sql = "UPDATE studio SET name = ?, country = ? WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, studio.getName());
            ps.setString(2, studio.getCountry());
            ps.setInt(3, studio.getId());
            ps.executeUpdate();
        }
    }

    public void deleteStudios(int id) throws SQLException {
        String sql = "DELETE FROM studio WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        }
    }
}
