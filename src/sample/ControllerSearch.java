package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerSearch {
       @FXML
    private ObservableList<ModelTable> data = FXCollections.observableArrayList();

    @FXML
    private TableView<ModelTable> table;

    @FXML
    private TableColumn<ModelTable, Integer> idColumn;

    @FXML
    private TableColumn<ModelTable, String> nameColumn, dateOfBirthColumn, regColumn;

    @FXML
    TableColumn<ModelTable, Void> colBtn;

    @FXML
    private TextField filterField;

    @FXML
    protected void initialize() throws SQLException, ClassNotFoundException {
        initData();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        regColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        addButtonToTable();
        table.setItems(data);
        searchOnTableId();
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

    }

    @FXML
    private void initData() throws SQLException {
        String querry = "SELECT * FROM card";
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(querry)) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt(Const.CARD_ID);
                Integer first_name = resultSet.getInt(Const.CARD_FIRST_NAME);
                Integer patronymic = resultSet.getInt(Const.CARD_PATRONYMIC);
                String last_name = resultSet.getString(Const.CARD_LAST_NAME);
                String date = resultSet.getString(Const.CARD_DATE_OF_BIRTH);
                Integer country = resultSet.getInt(Const.CARD_COUNTY);
                Integer region = resultSet.getInt(Const.CARD_REGION);
                String outdoors = resultSet.getString(Const.CARD_OUTDOORS);
                String address;
                if(country == 0)
                    address = "";
                else
                    address = searchDictionaryWord(Const.COUNTRY_TABLE, Const.COUNTRY_NAME, country) + ", " + region + ", " + outdoors;
                String name = last_name + " " + searchDictionaryWord(Const.NAME_TABLE, Const.NAME, first_name) + " " +
                        searchDictionaryWord(Const.PATRONYMIC_TABLE, Const.PATRONYMIC, patronymic);
                data.add(new ModelTable(id, name, date, address));
            }
        }
    }

    private String searchDictionaryWord(String table, String nameColumn, Integer valueColumn) throws SQLException {
        if(valueColumn!=null || valueColumn==0 ) {
            String query = "SELECT " + nameColumn + " FROM " + table + " where id_" + nameColumn + " = " + valueColumn;
            try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                resultSet.next();
                return resultSet.getString(nameColumn);
            }
        }
        else
            return "";
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
