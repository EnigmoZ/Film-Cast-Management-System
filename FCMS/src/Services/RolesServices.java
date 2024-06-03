package Services;
import java.sql.SQLException;
import java.util.List;

import DAO.RolesDAO;
import Models.Actors;
import Models.Roles;

public class RolesServices {
    private RolesDAO roleDAO;

    public RolesServices() {
        this.roleDAO = new RolesDAO();
    }

    public void addRole(Roles role) throws SQLException {
        roleDAO.addRole(role);
    }

    public List<Roles> getAllRoles() throws SQLException {
        return roleDAO.getAllRoles();
    }

    public List<Roles> getRolesByFilmId(int filmId) throws SQLException {
        return roleDAO.getRolesByFilmId(filmId);
    }

    public void updateRoles(Roles role) throws SQLException{
        roleDAO.updateRoles(role);
    }

    public void deleteRoles(int id) throws SQLException{
        roleDAO.deleteRoles(id);
    }
}
