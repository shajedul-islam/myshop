package com.cdip.java.myshop.dao;

import com.cdip.java.myshop.model.Shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ShopDAO {

    public Shop save(Shop shop) {

        System.out.println("Shop Dao save method");
        // save shop in database
        // connect to database
        //

        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/myshop_db?"
                            + "user=root&password=root");

            Statement statement = connection.createStatement();

            //statement.executeQuery("insert into shop values(" + 123 + ", " + shop.getName() + "," + shop.getLocation() + ")");

            statement.executeUpdate("INSERT INTO shop " + "VALUES (123, " + shop.getName() + ", " +shop.getLocation() + ")");


        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return shop;
    }

    public Shop edit(Shop shop) {
        // edit
        return shop;
    }

    public Shop get(long id) {
        // get shop by id
        return new Shop();
    }

    public boolean delete() {
        // delete shop by id
        return true;
    }
}
