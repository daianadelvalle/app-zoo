package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.ContinentDDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContinentDAO implements DAO<ContinentDDTO> {

    private Boolean willCloseConnection = true;

    public ContinentDAO() {
    }

    public ContinentDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public List<ContinentDDTO> findAll() {
        String sql = "SELECT * FROM Continent";
        List<ContinentDDTO> continents = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ContinentDDTO continent = new ContinentDDTO(rs.getInt("id"), rs.getString("name"));
                continents.add(continent);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return continents;
    }

    @Override
    public ContinentDDTO findById(Integer id) {
        String sql = "SELECT * FROM Continent WHERE id = ?";
        ContinentDDTO continent = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
                continent = new ContinentDDTO(rs.getInt("id"), rs.getString("name"));
            if (willCloseConnection)
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
            System.out.println("CONNECTION ERROR: " + ex.getMessage());
        }
        return continent;
    }

    @Override
    public Boolean save(ContinentDDTO continent) {
        String sql = "INSERT INTO Continent (name) values (?)";
        int affectatedRows = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, continent.getName());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return affectatedRows == 1;
    }

    @Override
    public Boolean update(ContinentDDTO continent, Integer id) {
        String sql = "UPDATE Continent SET name = ? WHERE Id = ?";
        int hasUpdate = 0;

        //para comparar el objeto que quiero actualizar con la base de datos.
        ContinentDDTO continentDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, continent.getName());
            preparedStatement.setInt(2, id);

            if (!continent.getName().equals(continentDB.getName()))
                hasUpdate = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Continent WHERE Id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            hasDelete = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasDelete == 1;
    }
}
