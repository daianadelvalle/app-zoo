package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//public class AnimalZoosDAO implements DAO<AnimalZoosDTO> {
//
//    private Boolean willCloseConnection = true;
//    private AnimalDAO animalDAO = new AnimalDAO(false);
//    private ZooDAO zooDAO = new ZooDAO(false);

//    public AnimalZoosDAO() {}

//    @Override
//    public ArrayList<AnimalZoosDTO> findAll() {
//        String sql = "SELECT * FROM Animal_zoos";
//        List<AnimalZoosDTO> animalZoos = new ArrayList<>();
//
//        try {
//            Connection connection = DBConnection.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                AnimalDTO animal = animalDAO.findById(rs.getInt("animal_id"));
//                ZooDTO zoo = zooDAO.findById(rs.getInt("zoo_id"));
//                AnimalZoosDTO animalZoo = new AnimalZoosDTO(rs.getInt("id"), animal, zoo);
//                animalZoos.add(animalZoo);
//            }
//            connection.close();
//        } catch (Exception e) {
//            System.out.println("CONNECTION ERROR ANIMAL_ZOO findAll : " + e.getMessage());
//        }
//
//        return animalZoos;
//    }

//    @Override
//    public AnimalZoosDTO findById(Integer id) {
//        String sql = "SELECT * FROM Animal_zoos WHERE Id = ?";
//        AnimalZoosDTO animalZoos = null;
//
//        try {
//            Connection connection = DBConnection.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()) {
//                SpeciesDTO species = speciesDAO.findById(rs.getInt("species_id"));
//                CountryDTO country = countryDAO.findById(rs.getInt("country_id"));
//                animal = new AnimalDTO(rs.getInt("id"), rs.getString("sex"), rs.getDate("birth"), species, country);
//            } if (willCloseConnection)
//                connection.close();
//        } catch (Exception e) {
//            System.out.println("CONNECTION ERROR ANIMAL findById : " + e.getMessage());
//        }
//        return animal;
//        return null;
//    }
//
//    @Override
//    public Boolean save(AnimalZoosDTO animalZoosDTO) {
//        return null;
//    }
//
//    @Override
//    public Boolean update(AnimalZoosDTO animalZoosDTO, Integer id) {
//        return null;
//    }
//
//    @Override
//    public Boolean delete(Integer id) {
//        return null;
//    }
//
//    public AnimalZoosDAO(Boolean willCloseConnection) {
//        this.willCloseConnection = willCloseConnection;
//    }
//}
