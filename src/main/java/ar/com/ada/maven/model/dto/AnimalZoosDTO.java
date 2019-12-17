package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class AnimalZoosDTO {

    //attr
    private int id;
    private AnimalDTO animalID;
    private ZooDTO zooID;

    //constructors

    public AnimalZoosDTO() {
    }

    public AnimalZoosDTO(int id, AnimalDTO animalID, ZooDTO zooID) {
        this.id = id;
        this.animalID = animalID;
        this.zooID = zooID;
    }

    //getter and setter

    public int getId() {
        return id;
    }

    public AnimalDTO getAnimalID() {
        return animalID;
    }

    public ZooDTO getZooID() {
        return zooID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnimalID(AnimalDTO animalID) {
        this.animalID = animalID;
    }

    public void setZooID(ZooDTO zooID) {
        this.zooID = zooID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalZoosDTO that = (AnimalZoosDTO) o;
        return id == that.id &&
                Objects.equals(animalID, that.animalID) &&
                Objects.equals(zooID, that.zooID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animalID, zooID);
    }

    @Override
    public String toString() {
        return "Animal_zoosDTO{" +
                "id=" + id +
                ", animalID=" + animalID +
                ", zooID=" + zooID +
                '}';
    }

}
