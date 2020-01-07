package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.AnimalDTO;
import ar.com.ada.maven.model.dto.CountryDTO;
import ar.com.ada.maven.model.dto.SpeciesDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnimalDAO implements DAO<AnimalDTO>{

    private Boolean willCloseConnection = true;
    private SpeciesDAO speciesDAO = new SpeciesDAO(false);
    private CountryDAO countryDAO = new CountryDAO(false);

    public AnimalDAO() {
    }

    public AnimalDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public List<AnimalDTO> findAll() {
        String sql = "SELECT * FROM Animal";
        List<AnimalDTO> animals = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                SpeciesDTO species = speciesDAO.findById(rs.getInt("species_id"));
                CountryDTO country = countryDAO.findById(rs.getInt("country_id"));
                AnimalDTO animal = new AnimalDTO(rs.getInt("id"), rs.getString("sex"), rs.getDate("birth"), species, country);
                animals.add(animal);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR ANIMAL findAll : " + e.getMessage());
        }

        return animals;
    }

    @Override
    public AnimalDTO findById(Integer id) {
        String sql = "SELECT * FROM Animal WHERE Id = ?";
        AnimalDTO animal = null;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                SpeciesDTO species = speciesDAO.findById(rs.getInt("species_id"));
                CountryDTO country = countryDAO.findById(rs.getInt("country_id"));
                animal = new AnimalDTO(rs.getInt("id"), rs.getString("sex"), rs.getDate("birth"), species, country);
            } if (willCloseConnection)
                connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR ANIMAL findById : " + e.getMessage());
        }
        return animal;
    }

    @Override
    public Boolean save(AnimalDTO animal) {
        String sql = "INSERT INTO Animal (sex, birth, species_id, country_id) VALUES (?, ?, ?, ?)";
        int affectedRows = 0;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, animal.getSex());
            Date date = new Date(animal.getBirth().getTime());
            preparedStatement.setDate(2, date);
            preparedStatement.setInt(3, animal.getSpeciesID().getId());
            preparedStatement.setInt(4, animal.getCountryID().getId());
            affectedRows = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR ANIMAL save : " + e.getMessage());
        }
        return affectedRows == 1;
    }

    @Override
    public Boolean update(AnimalDTO animal, Integer id) {
        String sql = "UPDATE Animal SET sex = ?, birth = ?, species_id = ?, country_id = ? WHERE Id = ?";
        int hasUpdate = 0;

        AnimalDTO animalDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, animal.getSex());
            Date date = new Date(animal.getBirth().getTime());
            preparedStatement.setDate(2, date);
            preparedStatement.setInt(3, animal.getSpeciesID().getId());
            preparedStatement.setInt(4, animal.getCountryID().getId());
            preparedStatement.setInt(5, animal.getId());

            if (!(animal.getBirth().equals(animalDB.getBirth()) && animal.getBirth().equals(animalDB.getBirth()) &&
                    animal.getSpeciesID().equals(animalDB.getSpeciesID()) && animal.getCountryID().equals(animalDB.getCountryID())));
            hasUpdate = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR ANIMAL update : " + e.getMessage());
        }

        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Animal WHERE Id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            hasDelete = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR ANIMAL delete : " + e.getMessage());
        }
        return hasDelete == 1;
    }
}
