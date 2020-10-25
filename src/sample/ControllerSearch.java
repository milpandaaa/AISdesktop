package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerSearch {
    @FXML
    protected Button buttonCreate, imageButtonAvatar, buttonAddName, buttonAddPatr, buttonSearch;


    private ObservableList<ModelTable> data = FXCollections.observableArrayList();
    @FXML
    private TableView<ModelTable> table;

    @FXML
    private TableColumn<ModelTable, Integer> idColumn;

    @FXML
    private TableColumn<ModelTable, String> nameColumn;

    @FXML
    private TableColumn buttonColumn;

    @FXML
    public void logout() {
        imageButtonAvatar.setOnAction(event -> {
            imageButtonAvatar.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));
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
    public void addName(){
        buttonAddName.setOnAction(event -> {
            buttonAddName.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/addName.fxml"));
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
    public void search(){
        buttonSearch.setOnAction(event -> {
            buttonSearch.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/search.fxml"));
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
    public void addPatr(){
        buttonAddPatr.setOnAction(event -> {
            buttonAddPatr.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/addPatr.fxml"));
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
    public void create(){
        buttonCreate.setOnAction(event -> {
            buttonCreate.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/create.fxml"));
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
    private void initialize() throws SQLException, ClassNotFoundException {
        initData();
        idColumn.setCellValueFactory(new PropertyValueFactory<ModelTable, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("name"));
//        buttonColumn.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("button"));
        table.setItems(data);
    }


    @FXML
    public void initData() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String querry = "SELECT * FROM card";
        Statement statement = dbHandler.getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(querry);
        while (resultSet.next()){
            Integer id = resultSet.getInt(Const.CARD_ID);
            Integer first_name = resultSet.getInt(Const.CARD_FIRST_NAME);
            Integer patronymic = resultSet.getInt(Const.CARD_PATRONYMIC);
            String last_name = resultSet.getString(Const.CARD_LAST_NAME);
            String date_of_birth = resultSet.getString(Const.CARD_DATE_OF_BIRTH);
            String name =  last_name + " "+seachDictionaryWord(Const.NAME_TABLE, Const.NAME, first_name )  + " " + seachDictionaryWord(Const.PATRONYMIC_TABLE, Const.PATRONYMIC, patronymic)+", "+ date_of_birth;
            System.out.println(name);
            data.add(new ModelTable(id, name));
        }
        resultSet.close();
    }

    public String seachDictionaryWord(String table, String nameColumn, Integer valueColumn) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String querry = "SELECT " + nameColumn + " FROM " + table + " where id_" + nameColumn + " = " + valueColumn;
        Statement statement = dbHandler.getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(querry);
        resultSet.next();
        String answer = resultSet.getString(nameColumn);
        resultSet.close();
        return answer;
    }

}
