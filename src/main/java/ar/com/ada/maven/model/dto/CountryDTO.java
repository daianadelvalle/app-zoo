package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class CountryDTO {

    //attr
    private int id;
    private String name;
    private Integer isoCode;
    private ContinentDDTO continent;

    //constructors
    public CountryDTO() {}

    public CountryDTO(int id) {
        this.id = id;
    }

    public CountryDTO(String name) {
        this.name = name;
    }

    public CountryDTO(ContinentDDTO continentID) {
        this.continent = continent;
    }

    public CountryDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CountryDTO(String name, ContinentDDTO continent) {
        this.name = name;
        this.continent = continent;
    }

    public CountryDTO(int id, String name, ContinentDDTO continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }

    public CountryDTO(String name, Integer isoCode, ContinentDDTO continent) {
        this.name = name;
        this.isoCode = isoCode;
        this.continent = continent;
    }

    public CountryDTO(int id, String name, Integer isoCode, ContinentDDTO continent) {
        this.id = id;
        this.name = name;
        this.isoCode = isoCode;
        this.continent = continent;
    }

    //getter and setter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public ContinentDDTO getContinent() {
        return continent;
    }
    public Integer getIsoCode() { return isoCode; }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public  void setContinent(ContinentDDTO continent) {
        this.continent = continent;
    }
    public void setIsoCode(Integer isoCod) { this.isoCode = isoCode; }
    //overrides


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDTO that = (CountryDTO) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(continent, that.continent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, continent);
    }

    @Override
    public String toString() {
        return "ID: " + id + "  NOMBRE: " + name + "  ISO-CODE: " + isoCode + "\nCONTINENTE AL QUE PERTENECE: " + continent + "\n";
    }
}
