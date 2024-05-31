package Services;
import java.sql.SQLException;
import java.util.List;

import DAO.ActorsDAO;
import Models.Actors;

public class ActorsServices {
    private ActorsDAO actorDAO;

    public ActorsServices() {
        this.actorDAO = new ActorsDAO();
    }

    public void addActor(Actors actor) throws SQLException {
        actorDAO.addActor(actor);
    }

    public List<Actors> getAllActors() throws SQLException {
        return actorDAO.getAllActors();
    }

    public Actors searchActorByName(String name) throws SQLException {
        return actorDAO.searchActorByName(name);
    }

    public List<Actors> getActorsByNationality(String nationality) throws SQLException {
        return actorDAO.getActorsByNationality(nationality);
    }

    public void updateActors(Actors actor) throws SQLException {
        actorDAO.updateActors(actor);
  
    public void updateActorNationality(int actorId, String nationality) throws SQLException {
        actorDAO.updateActorNationality(actorId, nationality);
    }

    public void deleteActors(int actorId) throws SQLException {
        actorDAO.deleteActors(actorId);
    }



}
