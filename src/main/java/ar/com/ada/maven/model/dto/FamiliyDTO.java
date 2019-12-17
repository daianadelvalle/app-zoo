package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class FamiliyDTO {

    //attr
    private int id;
    private String name;

    //constructors

    public FamiliyDTO() {
    }

    public FamiliyDTO(int id, String name) {
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

    //overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamiliyDTO that = (FamiliyDTO) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "FamiliyDTO{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
