package Services;
import DAO.FilmsDAO;
import Models.Films;

import java.sql.SQLException;
import java.util.List;

public class FilmsServices {
    private FilmsDAO filmDAO;

    public FilmsServices() {
        this.filmDAO = new FilmsDAO();
    }

    public void addFilm(Films film) throws SQLException {
        filmDAO.addFilm(film);
    }

    public List<Films> getAllFilms() throws SQLException {
        return filmDAO.getAllFilms();
    }

    public Films searchFilmByTitle(String title) throws SQLException {
        return filmDAO.searchFilmByTitle(title);
    }

//    public List<Films> getFilmsByGenre(String genre) throws SQLException {
//        return filmDAO.getFilmsByGenre(genre);
//    }

    public void updateFilms(Films film) throws  SQLException{
        filmDAO.updateFilms(film);
    }

    public void deleteFilms(int filmId) throws SQLException{
        filmDAO.deleteFilms(filmId);
    }
}
