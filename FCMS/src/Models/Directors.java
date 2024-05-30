package Models;

public class Directors {
     private int id;
     private String name;
     private String dob;
     private String nationality;

     public Directors(){

     }
     public Directors( int id,String name, String dob, String nationality){
         this.id = id;
         this.name = name;
         this.dob = dob;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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
                ", dob='" + dob + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
