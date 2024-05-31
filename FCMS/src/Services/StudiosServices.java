package Services;
import DAO.StudiosDAO;
import Models.Studios;

import java.sql.SQLException;
import java.util.List;

public class StudiosServices {
    private StudiosDAO studioDAO;

    public StudiosServices() {
        this.studioDAO = new StudiosDAO();
    }

    public void addStudio(Studios studio) throws SQLException {
        studioDAO.addStudio(studio);
    }

    public List<Studios> getAllStudios() throws SQLException {
        return studioDAO.getAllStudios();
    }

    public Studios searchStudioByName(String name) throws SQLException {
        return studioDAO.searchStudioByName(name);
    }

    public void updateStudio(Studios studio) throws SQLException {
        studioDAO.updateStudios(studio);
    }

    public void deleteStudio(int studioId) throws SQLException {
        studioDAO.deleteStudios(studioId);
    }


}
