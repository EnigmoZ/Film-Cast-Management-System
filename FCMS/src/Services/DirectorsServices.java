package Services;
import Models.Directors;
import DAO.DirectorDAO;

import java.sql.SQLException;
import java.util.List;

public class DirectorsServices {
    private DirectorDAO directorDAO;

    public DirectorsServices() {
        this.directorDAO = new DirectorDAO();
    }

    public void addDirector(Directors director) throws SQLException {
        directorDAO.addDirector(director);
    }

    public List<Directors> getAllDirectors() throws SQLException {
        return directorDAO.getAllDirectors();
    }

    public Directors searchDirectorByName(String name) throws SQLException {
        return directorDAO.searchDirectorByName(name);
    }

    public void updateDirector(Directors director) throws SQLException {
        directorDAO.updateDirectors(director);
    }

    public void deleteDirector(int directorId) throws SQLException {
        directorDAO.deleteDirectors(directorId);
    }
}
