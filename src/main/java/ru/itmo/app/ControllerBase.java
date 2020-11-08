package ru.itmo.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerBase {

    @FXML
    protected Button buttonCreate, imageButtonAvatar, buttonAddName, buttonAddPatr, buttonSearch, buttonStatistic;

    @FXML
    private BorderPane mainPane;

    @FXML
    protected void logout() {
        imageButtonAvatar.setOnAction(event -> {
            Stage stage = (Stage) imageButtonAvatar.getScene().getWindow();
            stage.close();
//            imageButtonAvatar.getScene().getWindow().hide();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getClassLoader().getResource("/sample/layer/sample.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
        });
    }


    @FXML
    protected void addName() {
        buttonAddName.setOnAction(event -> {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("addName");
            mainPane.setCenter(view);
//            Parent root = null;
//            try {
//                root = FXMLLoader.load(getClass().getClassLoader().getResource("/sample/layer/addName.fxml"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Stage primaryStage = new Stage();
//            primaryStage.setTitle("Diary");
//            primaryStage.setScene(new Scene(root, 1024, 700));
//            primaryStage.show();
//            buttonAddName.getScene().getWindow().hide();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getClassLoader().getResource("/sample/layer/addName.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
        });
    }

    @FXML
    protected void search() {
        buttonSearch.setOnAction(event -> {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("search");
            mainPane.setCenter(view);
//            Parent root = null;
//            try {
//                root = FXMLLoader.load(getClass().getClassLoader().getResource("/sample/layer/search.fxml"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Stage primaryStage = new Stage();
//            primaryStage.setTitle("Diary");
//            primaryStage.setScene(new Scene(root, 1024, 700));
//            primaryStage.show();
//            buttonSearch.getScene().getWindow().hide();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getClassLoader().getResource("/sample/layer/search.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
        });
    }

    @FXML
    protected void addPatr() {
        buttonAddPatr.setOnAction(event -> {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("addPatr");
            mainPane.setCenter(view);
//            Parent root = null;
//            try {
//                root = FXMLLoader.load(getClass().getClassLoader().getResource("/sample/layer/addPatr.fxml"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Stage primaryStage = new Stage();
//            primaryStage.setTitle("Diary");
//            primaryStage.setScene(new Scene(root, 1024, 700));
//            primaryStage.show();
//            buttonAddPatr.getScene().getWindow().hide();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getClassLoader().getResource("/sample/layer/addPatr.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
        });
    }



    @FXML
    protected void statistic() {
        buttonStatistic.setOnAction(event -> {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("statistic");
            mainPane.setCenter(view);

//            Parent root = null;
//            try {
//                root = FXMLLoader.load(getClass().getClassLoader().getResource("/sample/layer/statistic.fxml"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Stage primaryStage = new Stage();
//            primaryStage.setTitle("Diary");
//            primaryStage.setScene(new Scene(root, 1024, 700));
//            primaryStage.show();

//            buttonStatistic.getScene().getWindow().hide();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getClassLoader().getResource("/sample/layer/statistic.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
        });
    }

    @FXML
    protected void create() {
        buttonCreate.setOnAction(event -> {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("create");
            mainPane.setCenter(view);
//            Parent root = null;
//            try {
//                root = FXMLLoader.load(getClass().getClassLoader().getResource("/sample/layer/create.fxml"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Stage primaryStage = new Stage();
//            primaryStage.setTitle("Diary");
//            primaryStage.setScene(new Scene(root, 1024, 700));
//            primaryStage.show();
//            buttonCreate.getScene().getWindow().hide();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getClassLoader().getResource("/sample/layer/create.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
        });
    }

}
