package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.CityDTO;
import ar.com.ada.maven.model.dto.ZooDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class ZooDAO implements DAO<ZooDTO> {

    private Boolean willCloseConnection = true;
    private CityDAO cityDAO = new CityDAO(false);

    public ZooDAO() {
    }

    public ZooDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public ArrayList<ZooDTO> findAll() {
        String sql = "SELECT * FROM Zoo";
        ArrayList<ZooDTO> zoos = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                CityDTO city = cityDAO.findById(rs.getInt("city_id"));
                ZooDTO zoo = new ZooDTO(rs.getInt("id"), rs.getInt("number"), rs.getDouble("size"), rs.getDouble("budget"), city);
                zoos.add(zoo);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR ZOO findAll : " + e.getMessage());
        }
        return zoos;
    }

    @Override
    public ZooDTO findById(Integer id) {
        String sql = "SELECT * FROM City WHERE Id = ?";
        ZooDTO zoo = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                CityDTO city = cityDAO.findById(rs.getInt("city_id"));
                zoo = new ZooDTO(rs.getInt("id"), rs.getInt("number"), rs.getDouble("size"), rs.getDouble("budget"), city);
            }
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR ZOO FindById: " + e.getMessage());
        }
        return zoo;
    }

    @Override
    public Boolean save(ZooDTO zoo) {
        String sql = "INSERT INTO Zoo (number, size, budget, city_id) VALUES (?, ?, ?, ?)";
        int affectedRows = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, zoo.getNumber());
            preparedStatement.setDouble(2, zoo.getSize());
            preparedStatement.setDouble(3, zoo.getBudget());
            preparedStatement.setInt(4, zoo.getCity().getId());
            affectedRows = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR ZOO save: " + e.getMessage());
        }
        return affectedRows ==1;
    }

    @Override
    public Boolean update(ZooDTO zoo, Integer id) {
        String sql = "UPDATE Zoo SET number = ?, size = ?, budget = ?, city_id = ? WHERE Id = ?";
        int hasUpdate = 0;

        ZooDTO zooDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, zoo.getNumber());
            preparedStatement.setDouble(2, zoo.getSize());
            preparedStatement.setDouble(3, zoo.getBudget());
            preparedStatement.setInt(4, zoo.getCity().getId());
            preparedStatement.setInt(5, id);

            if (!(zoo.getNumber() == zooDB.getNumber()) && zoo.getSize().equals(zooDB.getSize()) &&
                    zoo.getBudget().equals(zooDB.getBudget()) && zoo.getCity().equals(zooDB.getCity()));
            hasUpdate = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR ZOO update: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE Zoo WHERE Id = ?";
        int hasDelete = 0;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR ZOO delete: " + e.getMessage());
        }
        return hasDelete == 1;
    }
}
