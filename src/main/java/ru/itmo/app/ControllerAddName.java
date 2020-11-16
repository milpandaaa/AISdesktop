package ru.itmo.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
