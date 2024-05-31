package DAO;

import Models.Roles;
import Utilities.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO {
    public void addRole(Roles role) throws SQLException {
        String sql = "INSERT INTO role(filmid, actorid, rolename)" +
                " VALUES (?, ?, ?)";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, role.getFilm_id());
            ps.setInt(2, role.getActor_id());
            ps.setString(3, role.getRole_name());
            ps.executeUpdate();
        }
    }

    public List<Roles> getAllRoles() throws SQLException {
        List<Roles> roles = new ArrayList<>();
        String sql = "SELECT * FROM role";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()) {
                Roles role = new Roles();
                role.setId(rs.getInt("id"));
                role.setFilm_id(rs.getInt("filmid"));
                role.setActor_id(rs.getInt("actorid"));
                role.setRole_name(rs.getString("rolename"));
                roles.add(role);
            }
        }
        return roles;
    }

    public List<Roles> getRolesByFilmId(int filmId) throws SQLException {
        List<Roles> roles = new ArrayList<>();
        String sql = "SELECT * FROM role where filmid=?";

        try (Connection con = Utilities.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, filmId);
            try(ResultSet rs = ps.executeQuery(sql)){
                while (rs.next()) {
                    Roles role = new Roles();
                    role.setId(rs.getInt("id"));
                    role.setFilm_id(rs.getInt("filmid"));
                    role.setActor_id(rs.getInt("actorid"));
                    role.setRole_name(rs.getString("rolename"));
                    roles.add(role);
                }
            }
        }
        return roles;
    }

    public Roles getRolesById(int id) throws SQLException {
        String sql = "SELECT * FROM role WHERE id=?";
        Roles role = null;

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    role = new Roles();
                    role.setId(rs.getInt("id"));
                    role.setFilm_id(rs.getInt("filmid"));
                    role.setActor_id(rs.getInt("actorid"));
                    role.setRole_name(rs.getString("rolename"));
                }
            }

            return role;
        }
    }

    public void updateRoles(Roles role) throws SQLException {
        String sql = "UPDATE role SET filmid = ?, actorid = ?, rolename = ? WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, role.getFilm_id());
            ps.setInt(2, role.getActor_id());
            ps.setString(3, role.getRole_name());
            ps.setInt(4, role.getId());
            ps.executeUpdate();
        }
    }

    public void deleteRoles(int id) throws SQLException {
        String sql = "DELETE FROM role WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        }
    }
}
