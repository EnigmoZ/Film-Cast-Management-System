package Services;
import DAO.AwardsDAO;
import Models.Awards;

import java.sql.SQLException;
import java.util.List;

public class AwardsServices {
    private AwardsDAO awardDAO;

    public AwardsServices() {
        this.awardDAO = new AwardsDAO();
    }

    public void addAward(Awards award) throws SQLException {
        awardDAO.addAward(award);
    }

    public List<Awards> getAllAwards() throws SQLException {
        return awardDAO.getAllAwards();
    }

    public Awards searchAwardByName(String name) throws SQLException {
        return awardDAO.searchAwardByName(name);
    }

    public void updateAward(Awards award) throws SQLException {
        awardDAO.updateAward(award);
    }

    public void deleteAward(int awardId) throws SQLException {
        awardDAO.deleteAward(awardId);
    }




}
