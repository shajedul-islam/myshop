package com.cdip.java.myshop.view;

import com.cdip.java.myshop.controller.OwnerController;
import com.cdip.java.myshop.model.Owner;

import java.util.List;

public class OwnerTest {
    public static void main(String[] a) {
        showAll();
    }

    public static void showAll() {
        OwnerController ownerController = new OwnerController();
        List<Owner> owners = ownerController.getAll();

        for(Owner owner : owners) {
            System.out.println("Id: " + owner.getId());
            System.out.println("Name: " + owner.getName());
            System.out.println("Phone: " + owner.getPhoneNumber());
        }
    }
}
