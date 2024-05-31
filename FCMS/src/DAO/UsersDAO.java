package DAO;

import Models.Users;
import Utilities.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    public void addUser(Users user) throws SQLException {
        String sql = "INSERT INTO user(username, email, password)" +
                " VALUES (?, ?, ?)";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
        }
    }

    public List<Users> getAllUsers() throws SQLException {
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        }
        return users;
    }

    public Users searchUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM user WHERE username=?";
        Users user = null;

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new Users();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                }
            }

            return user;
        }
    }

    public void updateUsers(Users user) throws SQLException {
        String sql = "UPDATE user SET username = ?, email = ?, password = ? WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
        }
    }

    public void deleteUsers(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        }
    }
}
