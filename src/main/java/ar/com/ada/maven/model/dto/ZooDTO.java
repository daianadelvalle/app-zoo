package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class ZooDTO {

    //attr
    private int id;
    private int number;
    private Double size;
    private Double budget;
    private CityDTO city;

    public ZooDTO() {
    }

    public ZooDTO(int id, int number, Double size, Double budget, CityDTO city) {
        this.id = id;
        this.number = number;
        this.size = size;
        this.budget = budget;
        this.city = city;
    }

    //getter and setter

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public Double getSize() {
        return size;
    }

    public Double getBudget() {
        return budget;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
    //overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooDTO zooDTO = (ZooDTO) o;
        return id == zooDTO.id &&
                number == zooDTO.number &&
                Objects.equals(size, zooDTO.size) &&
                Objects.equals(budget, zooDTO.budget) &&
                Objects.equals(city, zooDTO.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, size, budget, city);
    }

    @Override
    public String toString() {
        return "ZooDTO{" + "id=" + id + ", number=" + number + ", size=" + size + ", budget=" + budget + "city_id: "+ city; }
}

