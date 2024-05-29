package Models;

public class Directors {
     private int id;
     private String name;
     private String DATE;
     private String nationality;

     public Directors(){

     }
     public Directors( int id,String name, String DATE, String nationality){
         this.id = id;
         this.name = name;
         this.DATE = DATE;
         this.nationality = nationality;

     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Directors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DATE='" + DATE + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
