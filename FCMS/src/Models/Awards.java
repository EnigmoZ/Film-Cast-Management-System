package Models;

public class Awards {
    private int id;
    private String name;
    private String category;
    private String year;

    public Awards (){

    }
    public Awards (int id, String name, String category, String year){
        this.id= id;
        this.name= name;
        this.category = category;
        this.year = year;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Awards{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
