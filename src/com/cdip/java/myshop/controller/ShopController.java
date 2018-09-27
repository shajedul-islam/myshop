package com.cdip.java.myshop.controller;

import com.cdip.java.myshop.dao.ShopDAO;
import com.cdip.java.myshop.model.Employee;
import com.cdip.java.myshop.model.Owner;
import com.cdip.java.myshop.model.Shop;

import java.util.List;

public class ShopController {

    public Shop create(
            String name,
            String location,
            List<Owner> owners,
            List<Employee> employees) {

        Shop shop = new Shop();
        shop.setName(name);
        shop.setLocation(location);
        shop.setOwners(owners);
        shop.setEmployees(employees);

        ShopDAO shopDAO = new ShopDAO();
        shop = shopDAO.save(shop);


        return shop;
    }

    public Shop create(String name, String location) {
        Shop shop = new Shop();
        shop.setName(name);
        shop.setLocation(location);

        ShopDAO shopDAO = new ShopDAO();
        shop = shopDAO.save(shop);

        return shop;
    }

}
