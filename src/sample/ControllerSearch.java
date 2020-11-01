package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerSearch {
    @FXML
    protected Button buttonCreate, imageButtonAvatar, buttonAddName, buttonAddPatr, buttonSearch, buttonStatistic;

    @FXML
    private ObservableList<ModelTable> data = FXCollections.observableArrayList();
    @FXML
    private TableView<ModelTable> table;

    @FXML
    private TableColumn<ModelTable, Integer> idColumn;

    @FXML
    private TableColumn<ModelTable, String> nameColumn;

    @FXML
    private TableColumn<ModelTable, Void> colBtn;


    @FXML
    private TextField filterField;

    @FXML
    protected void logout() {
        imageButtonAvatar.setOnAction(event -> {
            imageButtonAvatar.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/layer/sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }


    @FXML
    protected void addName() {
        buttonAddName.setOnAction(event -> {
            buttonAddName.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/layer/addName.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    @FXML
    protected void search() {
        buttonSearch.setOnAction(event -> {
            buttonSearch.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/layer/search.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    @FXML
    protected void addPatr() {
        buttonAddPatr.setOnAction(event -> {
            buttonAddPatr.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/layer/addPatr.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }


    @FXML
    protected void statistic() {
        buttonStatistic.setOnAction(event -> {
            buttonStatistic.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/layer/statistic.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    @FXML
    protected void create() {
        buttonCreate.setOnAction(event -> {
            buttonCreate.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/layer/create.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }


    @FXML
    protected void initialize() throws SQLException, ClassNotFoundException {
//        initData();
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        addButtonToTable();
//
//        table.setItems(data);
//        searchOnTableId();
    }

    private void addButtonToTable() {

        Callback<TableColumn<ModelTable, Void>, TableCell<ModelTable, Void>> cellFactory = new Callback<TableColumn<ModelTable, Void>, TableCell<ModelTable, Void>>() {

            @Override
            public TableCell<ModelTable, Void> call(final TableColumn<ModelTable, Void> param) {
                final TableCell<ModelTable, Void> cell = new TableCell<ModelTable, Void>() {

                    private final Button btn = new Button("Подробнее");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            ModelTable data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data.getId());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        table.getColumns().add(colBtn);

    }

    @FXML
    private void initData() throws SQLException, ClassNotFoundException {
        String querry = "SELECT * FROM card";
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(querry)) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt(Const.CARD_ID);
                Integer first_name = resultSet.getInt(Const.CARD_FIRST_NAME);
                Integer patronymic = resultSet.getInt(Const.CARD_PATRONYMIC);
                String last_name = resultSet.getString(Const.CARD_LAST_NAME);
                String date_of_birth = resultSet.getString(Const.CARD_DATE_OF_BIRTH);
                String name = last_name + " " + searchDictionaryWord(Const.NAME_TABLE, Const.NAME, first_name) + " " + searchDictionaryWord(Const.PATRONYMIC_TABLE, Const.PATRONYMIC, patronymic) + ", " + date_of_birth;
                data.add(new ModelTable(id, name));
            }
        }
    }

    private String searchDictionaryWord(String table, String nameColumn, Integer valueColumn) throws SQLException {
        String query = "SELECT " + nameColumn + " FROM " + table + " where id_" + nameColumn + " = " + valueColumn;
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            resultSet.next();
            String answer = resultSet.getString(nameColumn);
            return answer;
        }
    }

    private void searchOnTableId() {
        ObservableList data = table.getItems();
        filterField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                table.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<ModelTable> subentries = FXCollections.observableArrayList();

            long count = table.getColumns().stream().count();
            for (int i = 0; i < table.getItems().size(); i++) {
                for (int j = 0; j < count; j++) {
                    String entry = "" + table.getColumns().get(j).getCellData(i);
                    if (entry.toLowerCase().contains(value)) {
                        subentries.add(table.getItems().get(i));
                        break;
                    }
                }
            }
            table.setItems(subentries);
        });
    }


}
