package Models;

public class Roles {
    private int id;
     private int film_id;
    private int actor_id;
     private String role_name ;

     public Roles(){

     }
     public Roles(int id, int film_id, int actor_id, String role_name){
         this.id= id;
         this.film_id = film_id;
         this.actor_id = actor_id;
         this.role_name = role_name;
     }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", film_id=" + film_id +
                ", actor_id=" + actor_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
