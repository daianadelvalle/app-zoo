package ar.com.ada.maven.model.dto;

import java.util.Date;
import java.util.Objects;

public class AnimalDTO {
    //attr
    private int id;
    private String sex;
    private Date birth;
    private SpeciesDTO speciesID;
    private CountryDTO countryID;

    //constructors


    public AnimalDTO() {
    }

    public AnimalDTO(int id, String sex, Date birth, SpeciesDTO speciesID, CountryDTO countryID) {
        this.id = id;
        this.sex = sex;
        this.birth = birth;
        this.speciesID = speciesID;
        this.countryID = countryID;
    }

    public int getId() {
        return id;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirth() {
        return birth;
    }

    public SpeciesDTO getSpeciesID() {
        return speciesID;
    }

    public CountryDTO getCountryID() {
        return countryID;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSpeciesID(SpeciesDTO speciesID) {
        this.speciesID = speciesID;
    }

    public void setCountryID(CountryDTO countryID) {
        this.countryID = countryID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDTO animalDTO = (AnimalDTO) o;
        return id == animalDTO.id &&
                speciesID == animalDTO.speciesID &&
                countryID == animalDTO.countryID &&
                Objects.equals(sex, animalDTO.sex) &&
                Objects.equals(birth, animalDTO.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sex, birth, speciesID, countryID);
    }

    @Override
    public String toString() {
        return "AnimalDTO{" + "id=" + id + ", sex='" + sex + '\'' + ", speciesID=" + speciesID + ", countryID=" + countryID + '}';
    }
}
