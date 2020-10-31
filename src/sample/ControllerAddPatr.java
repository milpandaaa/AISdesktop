package sample;

import javafx.fxml.FXML;
import java.sql.SQLException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerAddPatr extends ControllerSearch{
    @FXML
    private Button buttonAddPatrs;

    @FXML
    private TextField textFieldAddPatr;

    @FXML
    public void add(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        buttonAddPatrs.setOnAction(event -> {
            try {
                dbHandler.addPatr(textFieldAddPatr.getText());
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}
