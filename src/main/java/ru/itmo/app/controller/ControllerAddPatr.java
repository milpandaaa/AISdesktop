package ru.itmo.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.itmo.app.AlertSending;
import ru.itmo.app.DatabaseHandler;

public class ControllerAddPatr{
    @FXML
    private Button buttonAddPatrs;

    @FXML
    private TextField textFieldAddPatr;

    private static final DatabaseHandler dbHandler = new DatabaseHandler();

    @FXML
    public void add() {
        buttonAddPatrs.setOnAction(event ->{
            dbHandler.addName(textFieldAddPatr.getText());
            AlertSending.alertInfo();
        });
    }

}
