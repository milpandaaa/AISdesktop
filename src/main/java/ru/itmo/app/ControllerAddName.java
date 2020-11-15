package ru.itmo.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerAddName {
    @FXML
    private Button buttonAddNames;

    @FXML
    private TextField textFieldAddName;

    @FXML
    public void add() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        buttonAddNames.setOnAction(event -> dbHandler.addName(textFieldAddName.getText()));

//        TilePane r = new TilePane();
//        Alert a = new Alert(Alert.AlertType.NONE);
//        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
//                    public void handle(ActionEvent e)
//                    {
//                        a.setAlertType(Alert.AlertType.valueOf(""));
//                        a.show();
//                    }
//                };
//        buttonAddNames.setOnAction(event);
    }
}
