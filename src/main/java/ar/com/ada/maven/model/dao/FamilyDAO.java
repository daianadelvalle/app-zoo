package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.FamiliyDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FamilyDAO implements DAO<FamiliyDTO> {

    //constructors
    private  Boolean willCloseConnection = true;

    public FamilyDAO() { }

    public FamilyDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    //overraids

    @Override
    public List<FamiliyDTO> findAll() {
        String sql = "SELECT * FROM Family";
        List<FamiliyDTO> families = new ArrayList<FamiliyDTO>();

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                FamiliyDTO family = new FamiliyDTO(rs.getInt("id"), rs.getString("name"));
                families.add(family);
            }
            connection.close();
        } catch (Exception e ) {
            System.out.println("CONNECTION ERROR FAMILY findAll :: " + e.getMessage());
        }
        return families;
    }

    @Override
    public FamiliyDTO findById(Integer id) {
        String sql = "SELECT * FROM Family WHERE Id = ?";
        FamiliyDTO family = null;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
                family = new FamiliyDTO(rs.getInt("id"), rs.getString("name"));
            if (willCloseConnection)
                connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR FAMILY findById :: " + e.getMessage());
        }
        return family;
    }

    @Override
    public Boolean save(FamiliyDTO familiy) {
        String sql = "INSERT INTO Family (name) VALUES (?)";
        int affectedRows = 0;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, familiy.getName());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR FAMILY save :: " + e.getMessage());
        }
        return affectedRows == 1;
    }

    @Override
    public Boolean update(FamiliyDTO familiy, Integer id) {
        String sql = "UPDATE Family SET name = ? WHERE Id = ?";
        int hasUpdate = 0;

        FamiliyDTO familyDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, familiy.getName());
            preparedStatement.setInt(2, familiy.getId());
            if (!familiy.getName().equals(familyDB.getName()))
                hasUpdate = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e ) {
            System.out.println("CONNECTION ERROR FAMILY update :: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE Family WHERE Id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR FAMILY delete :: " + e.getMessage());
        }
        return hasDelete == 1;
    }
}
