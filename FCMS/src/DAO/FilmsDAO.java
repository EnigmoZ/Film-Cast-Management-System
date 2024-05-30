package DAO;

import Models.Films;
import Utilities.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmsDAO {
    public void addFilm(Films film) throws SQLException {
        String sql = "INSERT INTO film(title, genre, release_year ,director_id ,studio_id)" +
                " VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, film.getTitle());
            ps.setString(2, film.getGenre());
            ps.setInt(3, film.getRelease_year());
            ps.setInt(4, film.getDirector_id());
            ps.setInt(5, film.getStudio_id());
            ps.executeUpdate();
        }
    }

    public List<Films> getAllFilms() throws SQLException {
        List<Films> films = new ArrayList<>();
        String sql = "SELECT * FROM film";

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()) {
                Films film = new Films();
                film.setId(rs.getInt("id"));
                film.setTitle(rs.getString("title"));
                film.setGenre(rs.getString("genre"));
                film.setRelease_year(rs.getInt("release_year"));
                film.setDirector_id(rs.getInt("director_id"));
                film.setStudio_id(rs.getInt("studio_id"));
                films.add(film);
            }
        }
        return films;
    }

    public Films getFilmsById(int id) throws SQLException {
        String sql = "SELECT * FROM film WHERE id=?";
        Films film = null;

        try (Connection con = Utilities.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    film = new Films();
                    film.setId(rs.getInt("id"));
                    film.setTitle(rs.getString("title"));
                    film.setGenre(rs.getString("genre"));
                    film.setRelease_year(rs.getInt("release_year"));
                    film.setDirector_id(rs.getInt("director_id"));
                    film.setStudio_id(rs.getInt("studio_id"));
                }
            }

            return film;
        }
    }

    public void updateFilms(Films film) throws SQLException {
        String sql = "UPDATE film SET title = ?, genre = ?, release_year = ?, director_id = ?, studio_id = ? WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, film.getTitle());
            ps.setString(2, film.getGenre());
            ps.setInt(3, film.getRelease_year());
            ps.setInt(4, film.getDirector_id());
            ps.setInt(5, film.getStudio_id());
            ps.setInt(6, film.getId());
            ps.executeUpdate();
        }
    }

    public void deleteFilms(int id) throws SQLException {
        String sql = "DELETE FROM film WHERE id = ?";

        try (Connection conn = Utilities.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        }
    }
}
