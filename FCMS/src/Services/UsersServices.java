package Services;
import DAO.UsersDAO;
import Models.Users;

import java.sql.SQLException;
import java.util.List;

public class UsersServices {
    private UsersDAO userDAO;

    public UsersServices() {
        this.userDAO = new UsersDAO();
    }

    public void addUser(Users user) throws SQLException {
        userDAO.addUser(user);
    }

    public List<Users> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public Users searchUserByUsername(String username) throws SQLException {
        return userDAO.searchUserByUsername(username);
    }

    public void updateUser(Users user) throws SQLException {
        userDAO.updateUsers(user);
    }

    public void deleteUser(int userId) throws SQLException {
        userDAO.deleteUsers(userId);
    }
}
