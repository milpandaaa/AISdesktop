package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerAddPatr extends ControllerSearch {
    @FXML
    private Button buttonAddPatrs;

    @FXML
    private TextField textFieldAddPatr;

    private static final DatabaseHandler dbHandler = new DatabaseHandler();

    @FXML
    public void add() {
        buttonAddPatrs.setOnAction(event -> dbHandler.addPatr(textFieldAddPatr.getText()));
    }
}
