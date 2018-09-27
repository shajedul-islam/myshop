package com.cdip.java.myshop.dao;

import com.cdip.java.myshop.db.ConnectionFactory;
import com.cdip.java.myshop.model.Owner;

import java.sql.*;

public class OwnerDAO {

    private static String INSERT_QUERY = "INSERT INTO owner(name, phone_number) VALUES(?, ?)";

    public Owner save(Owner owner) {
        // save owner in database
        // connect to database
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, owner.getName());
            preparedStatement.setLong(2, owner.getPhoneNumber());

            preparedStatement.executeUpdate();

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
}
