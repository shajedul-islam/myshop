package com.cdip.java.myshop.view;

import com.cdip.java.myshop.controller.ShopController;
import com.cdip.java.myshop.model.Employee;
import com.cdip.java.myshop.model.Owner;

import java.util.ArrayList;
import java.util.List;

public class ShopView {

    public static void main(String[] a) {

        // create an owner object
        Owner owner = new Owner();
        List<Owner> owners = new ArrayList<Owner>();
        owners.add(owner);


        // create some employees
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(employee1);
        employees.add(employee2);


        // take input and create a shop object
        ShopController shopController = new ShopController();
        //shopController.create("Shwapno", "Uttara", owners, employees);
        shopController.create("Shwapno", "Uttara 11 sector");
    }
}
