package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

public class ControllerAddName extends ControllerSearch{
    @FXML
    private Button buttonAddNames;

    @FXML
    private TextField textFieldAddName;

    @FXML
    public void add(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        buttonAddNames.setOnAction(event -> {
            try {
                dbHandler.addName(textFieldAddName.getText());
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });
//        TilePane r = new TilePane();
//        Alert a = new Alert(Alert.AlertType.NONE);
//        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
//                    public void handle(ActionEvent e)
//                    {
//                        a.setAlertType(Alert.AlertType.valueOf("Добавление прошло успешно"));
//                        a.show();
//                    }
//                };
//        buttonAddNames.setOnAction(event);
    }
}
