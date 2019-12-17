package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class CityDTO {

    //attr
    public int id;
    public String name;
    public CountryDTO CountryID;

    public CityDTO() {}

    public CityDTO(int id, String name, CountryDTO countryID) {
        this.id = id;
        this.name = name;
        CountryID = countryID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryDTO getCountryID() {
        return CountryID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryID(CountryDTO countryID) {
        CountryID = countryID;
    }
    //Overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDTO cityDTO = (CityDTO) o;
        return id == cityDTO.id &&
                Objects.equals(name, cityDTO.name) &&
                Objects.equals(CountryID, cityDTO.CountryID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, CountryID);
    }

    @Override
    public String toString() {
        return "CityDTO{" + "id=" + id + ", name='" + name + '\'' + ", CountryID=" + CountryID + '}';
    }
}
