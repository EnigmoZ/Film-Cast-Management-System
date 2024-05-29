package Models;

public class Films {
    private int id;
    private String title;
    private String genre;
    private int release_year;
    private int director_id;
    private int studio_id;

    public Films(){

    }
    public Films(int id, String title, String genre, int release_year,int director_id, int studio_id){
        this.id = id;
        this.title = title;
        this.genre= genre;
        this.release_year = release_year;
        this.director_id = director_id;
        this.studio_id = studio_id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public int getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    @Override
    public String toString() {
        return "Films{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", release_year=" + release_year +
                ", director_id=" + director_id +
                ", studio_id=" + studio_id +
                '}';
    }
}
