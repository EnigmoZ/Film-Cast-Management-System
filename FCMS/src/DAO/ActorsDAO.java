package DAO;

import Models.Actors;
import Utilities.Utilities;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorsDAO {
    public void addActor(Actors actor) throws SQLException {
        String sql = "INSERT INTO actor(name, dob, nationality)" +
                " VALUES (?, ?, ?)";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, actor.getName());
            ps.setString(2, actor.getDob());
            ps.setString(3, actor.getNationality());
            ps.executeUpdate();
        }
    }

    public List<Actors> getAllActors() throws SQLException {
        List<Actors> actors = new ArrayList<>();
        String sql = "SELECT * FROM actor";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()) {
                Actors actor = new Actors();
                actor.setId(rs.getInt("id"));
                actor.setName(rs.getString("name"));
                actor.setDob(rs.getString("dob"));
                actor.setNationality(rs.getString("nationality"));
                actors.add(actor);
            }
        }
        return actors;
    }

    public Actors searchActorByName(String name) throws SQLException {
        String sql = "SELECT * FROM actor WHERE name=?";
        Actors actor = null;

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    actor = new Actors();
                    actor.setId(rs.getInt("id"));
                    actor.setName(rs.getString("name"));
                    actor.setDob(rs.getString("dob"));
                    actor.setNationality(rs.getString("nationality"));
                }
            }

            return actor;
        }
    }

    public List<Actors> getActorsByNationality(String nationality) throws SQLException {
        List<Actors> actors = new ArrayList<>();
        String sql = "SELECT * FROM actor WHERE nationality=?";
        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()) {
                Actors actor = new Actors();
                actor.setId(rs.getInt("id"));
                actor.setName(rs.getString("name"));
                actor.setDob(rs.getString("dob"));
                actor.setNationality(rs.getString("nationality"));
                actors.add(actor);
            }
        }
        return actors;
    }

    public void updateActors(Actors actor) throws SQLException {
        String sql = "UPDATE actor SET name = ?, department = ?, salary = ? WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, actor.getName());
            ps.setString(2, actor.getDob());
            ps.setString(3, actor.getNationality());
            ps.setInt(4, actor.getId());
            ps.executeUpdate();
        }
    }

    public void deleteActors(int id) throws SQLException {
        String sql = "DELETE FROM actor WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        }
    }
}
