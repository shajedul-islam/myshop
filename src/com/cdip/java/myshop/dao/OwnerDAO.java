package com.cdip.java.myshop.dao;

import com.cdip.java.myshop.db.ConnectionFactory;
import com.cdip.java.myshop.model.Owner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO {

    private static String INSERT_QUERY = "INSERT INTO owner(name, phone_number) VALUES(?, ?)";

    public Owner save(Owner owner) {
        // save owner in database
        // connect to database
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, owner.getName());
            preparedStatement.setLong(2, owner.getPhoneNumber());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                long newId = rs.getLong(1);
                System.out.println("id: " + newId);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Error creating owner: ", ex);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) { /* ignored */ }
        }
        return owner;
    }

    public List<Owner> getAll() {
        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM owner");
            List<Owner> owners = new ArrayList<Owner>();
            while(rs.next())
            {
                Owner owner = extractOwnerFromResultSet(rs);
                owners.add(owner);
            }
            return owners;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Owner extractOwnerFromResultSet(ResultSet rs) throws SQLException {
        Owner owner = new Owner();
        owner.setId( rs.getInt("id") );
        owner.setName( rs.getString("name") );
        owner.setPhoneNumber( rs.getLong("phone_number") );
        return owner;
    }
}
