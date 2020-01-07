package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.FamiliyDTO;
import ar.com.ada.maven.model.dto.SpeciesDTO;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SpeciesDAO implements DAO<SpeciesDTO> {

    private Boolean willCloseConnection = true;
    private FamilyDAO familyDAO = new FamilyDAO(false);
    //constructors

    public SpeciesDAO() { }

    public SpeciesDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public List<SpeciesDTO> findAll() {
        String sql = "SELECT * FROM Species";
        List<SpeciesDTO> speciesList = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                FamiliyDTO family = familyDAO.findById(rs.getInt("family_id"));
                SpeciesDTO species = new SpeciesDTO(rs.getInt("id"), rs.getString("name_v"),
                        rs.getString("name_c"), rs.getBoolean("ext"), family);
                speciesList.add(species);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SPECIES findAll : " + e.getMessage());
        }

        return speciesList;
    }

    @Override
    public SpeciesDTO findById(Integer id) {
        String sql = "SELECT * FROM Species WHERE Id = ?";
        SpeciesDTO species = null;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                FamiliyDTO family = familyDAO.findById(rs.getInt("family_id"));
                species = new SpeciesDTO(rs.getInt("id"), rs.getString("name_v"), rs.getString("name_c"),
                        rs.getBoolean("ext"), family);
            } if (willCloseConnection)
                connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SPECIES findById : " + e.getMessage());
        }
        return species;
    }

    @Override
    public Boolean save(SpeciesDTO species) {
        String sql = "INSERT INTO Species (name_v, name_c, ext, family_id) VALUES (?,?,?,?)";
        int affectedRows = 0;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, species.getVulgarName());
            preparedStatement.setString(2, species.getScientificName());
            preparedStatement.setBoolean(3, species.getExt());
            preparedStatement.setInt(4, species.getFamilyID().getId());
            affectedRows = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SPECIES save : " + e.getMessage());
        }
        return affectedRows == 1;
    }

    @Override
    public Boolean update(SpeciesDTO species, Integer id) {
        String sql = "UPDATE Species SET name_v = ?, name_c = ?, ext = ?, family_id = ? WHERE Id = ?";
        int hasUpdate = 0;

        SpeciesDTO speciesDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, species.getVulgarName());
            preparedStatement.setString(2, species.getScientificName());
            preparedStatement.setBoolean(3, speciesDB.getExt());
            preparedStatement.setInt(4, species.getFamilyID().getId());

            if (!(species.getVulgarName().equals(speciesDB.getVulgarName()) &&
                    species.getScientificName().equals(speciesDB.getScientificName()) &&
                    species.getExt().equals(speciesDB.getExt()) && species.getFamilyID().equals(speciesDB.getFamilyID())));
            hasUpdate = preparedStatement.executeUpdate();
        } catch (Exception e ) {
            System.out.println("CONNECTION ERROR SPECIES update : " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Species WHERE Id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            hasDelete = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SPECIES delete : " + e.getMessage());
        }
        return hasDelete == 1;
    }
}
