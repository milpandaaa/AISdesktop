package ru.itmo.app.controller;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonSuperUser;

    @FXML
    private Button buttonUser;

    static boolean privilege = false;

    public boolean isPrivilege() {
        return privilege;
    }

    public void setPrivilege(boolean privilege) {
        Controller.privilege = privilege;
    }

    @FXML
    void loginSuperUser(){
        privilege = true;
        buttonSuperUser.setOnAction(event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("layer/base.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage = new Stage();
            primaryStage.setTitle("");
            primaryStage.setScene(new Scene(root, 1024, 700));
            primaryStage.show();
        });
    }

    @FXML
    void loginUser(){
        buttonUser.setOnAction(event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("layer/base.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage = new Stage();
            primaryStage.setTitle("");
            primaryStage.setScene(new Scene(root, 1024, 700));
            primaryStage.show();
        });
    }


}
