package ar.com.ada.maven.model.dto;

public class ContinentDTO {

    //attr
    private int id;
    private String name;

    //constructors

    public ContinentDTO() {}

    public ContinentDTO(String name) {
        this.name = name;
    }

    public ContinentDTO(int id, String name) {
    this.id = id;
    this.name = name;
    }

    //getter and setter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + "  NOMBRE: " + name;
    }
}
