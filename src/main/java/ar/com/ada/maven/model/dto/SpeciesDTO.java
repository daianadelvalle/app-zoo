package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class SpeciesDTO {
    //attr
    private int id;
    private String vulgarName;
    private String scientificName;
    private Boolean ext;
    private FamiliyDTO familyID;

    //constructors

    public SpeciesDTO() {
    }

    public SpeciesDTO(int id, String vulgarName, String scientificName, Boolean ext, FamiliyDTO familyID) {
        this.id = id;
        this.vulgarName = vulgarName;
        this.scientificName = scientificName;
        this.ext = ext;
        this.familyID = familyID;
    }

    //getter and setter

    public int getId() {
        return id;
    }

    public String getVulgarName() {
        return vulgarName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public Boolean getExt() {
        return ext;
    }

    public FamiliyDTO getFamilyID() {
        return familyID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVulgarName(String vulgarName) {
        this.vulgarName = vulgarName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public void setExt(Boolean ext) {
        this.ext = ext;
    }

    public void setFamilyID(FamiliyDTO familyID) {
        this.familyID = familyID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpeciesDTO that = (SpeciesDTO) o;
        return id == that.id &&
                Objects.equals(vulgarName, that.vulgarName) &&
                Objects.equals(scientificName, that.scientificName) &&
                Objects.equals(ext, that.ext) &&
                Objects.equals(familyID, that.familyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vulgarName, scientificName, ext, familyID);
    }

    @Override
    public String toString() {
        return "SpeciesDTO{" + "id=" + id + ", nameV='" + vulgarName + '\'' + ", nameC='" + scientificName + '\'' + ", ext=" + ext + ", familyID=" + familyID + '}';
    }

}
