package Services;
import java.sql.SQLException;
import java.util.List;

import DAO.RolesDAO;
import Models.Roles;

public class RolesServices {
    private RolesDAO roleDAO;

    public RolesServices() {
        this.roleDAO = new RolesDAO();
    }

    public void addRole(Roles role) throws SQLException {
        roleDAO.addRole(role);
    }

    public List<Roles> getRolesByFilmId(int filmId) throws SQLException {
        return roleDAO.getRolesByFilmId(filmId);
    }
}
