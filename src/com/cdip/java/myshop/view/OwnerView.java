package com.cdip.java.myshop.view;

import com.cdip.java.myshop.controller.OwnerController;
import com.cdip.java.myshop.model.Owner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class OwnerView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("create_owner.fxml"));
        primaryStage.setTitle("Create Owner");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
