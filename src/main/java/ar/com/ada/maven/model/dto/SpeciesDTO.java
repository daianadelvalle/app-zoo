package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class SpeciesDTO {
    //attr
    private int id;
    private String nameV;
    private String nameC;
    private Boolean ext;
    private FamiliyDTO familyID;

    //constructors

    public SpeciesDTO() {
    }

    public SpeciesDTO(int id, String nameV, String nameC, Boolean ext, FamiliyDTO familyID) {
        this.id = id;
        this.nameV = nameV;
        this.nameC = nameC;
        this.ext = ext;
        this.familyID = familyID;
    }

    //getter and setter

    public int getId() {
        return id;
    }

    public String getNameV() {
        return nameV;
    }

    public String getNameC() {
        return nameC;
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

    public void setNameV(String nameV) {
        this.nameV = nameV;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
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
                Objects.equals(nameV, that.nameV) &&
                Objects.equals(nameC, that.nameC) &&
                Objects.equals(ext, that.ext) &&
                Objects.equals(familyID, that.familyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameV, nameC, ext, familyID);
    }

    @Override
    public String toString() {
        return "SpeciesDTO{" + "id=" + id + ", nameV='" + nameV + '\'' + ", nameC='" + nameC + '\'' + ", ext=" + ext + ", familyID=" + familyID + '}';
    }

}
