package com.cdip.java.myshop.dao;

import com.cdip.java.myshop.model.Owner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OwnerDAO {

    public Owner save(Owner owner) {
        // save owner in database
        // save owner in database
        // connect to database

        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/myshop_db?"
                            + "user=root&password=root");

            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO owner(name, phone_number) " +
                    "VALUES ( '" + owner.getName() + "', " + owner.getPhoneNumber() + ")");


        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        return owner;
    }
}
