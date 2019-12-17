package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.CityDTO;
import ar.com.ada.maven.model.dto.CountryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class CityDAO implements DAO<CityDTO> {

    private Boolean willCloseConnection = true;
    private CountryDAO countryDAO = new CountryDAO(false);

    public CityDAO() {
    }

    public CityDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public ArrayList<CityDTO> findAll() {
        String sql = "SELECT * FROM City";
        ArrayList<CityDTO> cities = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                CountryDTO country = countryDAO.findById(rs.getInt("Country_id"));
                CityDTO city = new CityDTO(rs.getInt("id"), rs.getString("name"), country);
                cities.add(city);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR CITY FindAll: " + e.getMessage());
        }
        return cities;
    }

    @Override
    public CityDTO findById(Integer id) {
        String sql = "SELECT * FROM City WHERE Id = ?";
        CityDTO city = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                CountryDTO country = countryDAO.findById(rs.getInt("Country_id"));
                city = new  CityDTO(rs.getInt("id"), rs.getString("name"), country);
            }
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR CITY FindById: " + e.getMessage());
        }
        return city;
    }

    @Override
    public Boolean save(CityDTO cityDTO) {
        return null;
    }

    @Override
    public Boolean update(CityDTO cityDTO, Integer id) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }
}
