package ru.itmo.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
