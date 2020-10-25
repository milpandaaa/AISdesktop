package sample;

import javafx.fxml.FXML;
import java.sql.SQLException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerAddName extends ControllerSearch{
    @FXML
    private Button buttonAddNames;

    @FXML
    private TextField textFieldAddName;

    @FXML
    public void addName(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        buttonAddNames.setOnAction(event -> {
            try {
                dbHandler.addName(textFieldAddName.getText());
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}
