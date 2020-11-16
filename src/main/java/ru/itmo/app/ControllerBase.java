package ru.itmo.app;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.SQLException;

public class ControllerBase extends Controller{

    @FXML
    protected Button buttonCreate, imageButtonAvatar, buttonAddName, buttonAddPatr, buttonSearch, buttonStatistic;

    @FXML
    protected BorderPane mainPane;


    @FXML
    protected void logout() {
        imageButtonAvatar.setOnAction(event -> {
            setPrivilege(false);
            Stage stage = (Stage) imageButtonAvatar.getScene().getWindow();
            stage.close();
        });
    }


    @FXML
    protected void addName() {
        buttonAddName.setOnAction(event -> {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("addName");
            mainPane.setCenter(view);
        });
    }

    @FXML
    protected void search() {
        buttonSearch.setOnAction(event -> {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("search");
            mainPane.setCenter(view);
        });
    }

    @FXML
    protected void addPatr() {
        buttonAddPatr.setOnAction(event -> {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("addPatr");
            mainPane.setCenter(view);
        });
    }



    @FXML
    protected void statistic() {
        buttonStatistic.setOnAction(event -> {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("statistic");
            mainPane.setCenter(view);
        });
    }

    @FXML
    protected void create() {
        buttonCreate.setOnAction(event -> {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("create");
            mainPane.setCenter(view);
        });
    }

    @FXML
    protected void initialize() throws SQLException, ClassNotFoundException {
        if(!isPrivilege()) {
            buttonAddName.setVisible(false);
            buttonAddPatr.setVisible(false);
        }
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("search");
        mainPane.setCenter(view);
    }

    protected void alertInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Изменения применены");
        alert.showAndWait();
    }
}
