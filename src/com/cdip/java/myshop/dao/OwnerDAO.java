package com.cdip.java.myshop.dao;

import com.cdip.java.myshop.db.ConnectionFactory;
import com.cdip.java.myshop.model.Owner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OwnerDAO {

    public Owner save(Owner owner) {
        // save owner in database
        // connect to database
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO owner(name, phone_number) " +
                    "VALUES ( '" + owner.getName() + "', " + owner.getPhoneNumber() + ")");
        } catch (Exception ex) {
            throw new RuntimeException("Error creating owner: ", ex);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) { /* ignored */ }
        }
        return owner;
    }
}
