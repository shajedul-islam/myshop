package com.cdip.java.myshop.controller;

import com.cdip.java.myshop.dao.OwnerDAO;
import com.cdip.java.myshop.model.Owner;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.util.List;

public class OwnerController {

    public TextField nameTextField;
    public TextField phoneNumberTextField;

    public void create(ActionEvent actionEvent) {
        Owner owner = new Owner();
        owner.setName(nameTextField.getText());
        owner.setPhoneNumber(Long.parseLong(phoneNumberTextField.getText()));

        OwnerDAO ownerDAO = new OwnerDAO();
        ownerDAO.save(owner);
    }

    public List<Owner> getAll() {
        OwnerDAO ownerDAO = new OwnerDAO();
        return ownerDAO.findAll();
    }
}
