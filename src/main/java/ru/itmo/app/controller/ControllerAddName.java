package ru.itmo.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.itmo.app.AlertSending;
import ru.itmo.app.DatabaseHandler;

public class ControllerAddName {
    @FXML
    public Button buttonAddName;

    @FXML
    private TextField textFieldAddName;

    DatabaseHandler dbHandler = new DatabaseHandler();

    @FXML
    public void add() {
        buttonAddName.setOnAction(event ->{
                    dbHandler.addName(textFieldAddName.getText());
                    AlertSending.alertInfo();
                });
    }
}
