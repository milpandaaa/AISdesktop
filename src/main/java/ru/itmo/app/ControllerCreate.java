package ru.itmo.app;

import com.sun.javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

public class ControllerCreate extends ControllerSearch {
    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private TextField textFieldPatronymic;

    @FXML
    private TextField textFieldDateOfBirth;

    @FXML
    private TextField textFieldGender;

    @FXML
    private TextField textFieldDateOfPreparingReport;

    @FXML
    private TextField textFieldDateOfCommission;

    @FXML
    private TextField textFieldRegion;

    @FXML
    private TextField textFieldOutdoors;

    @FXML
    static ComboBox<HideableItem<String>> comboBoxCountry;

    @FXML
    private TextField textFieldPlaceOfCommission;

    @FXML
    private TextField textFieldDateOfInitiation;

    @FXML
    private TextField textFieldOfficeOfInitiation;

    @FXML
    private TextField textFieldNameOfInitiation;

    @FXML
    private TextField textFieldNameOfPreparingReport;

    @FXML
    private TextField textFieldArticle;

    @FXML
    private TextField textFieldOfficeOfDecision;

    @FXML
    private TextField textFieldPunishment;

    @FXML
    private TextField textFieldPunishmentSum;

    @FXML
    private TextField textFieldDateOfEntryIntoForce;

    @FXML
    private TextField textFieldAmount;

    @FXML
    private TextField textFieldOfficeArrival;

    @FXML
    private TextField textFieldOfficeDeparture;


    @FXML
    private TextField textFieldDateSentenceEnforcement;

    @FXML
    private TextField textFieldDateOfDecision;

    @FXML
    private TextField textFieldDateArrival;

    @FXML
    private TextField textFieldDateDeparture;

    @FXML
    private TextField textFieldDecision;

    @FXML
    private TextField textFieldNameOfDecision;

    @FXML
    private TextField textFieldOfficeOfPreparingReport;

    @FXML
    private TextField textFieldID1;

    @FXML
    private TextField textFieldID2;

    @FXML
    private TextField textFieldID3;

    @FXML
    private TextField textFieldID4;

    @FXML
    private Button buttonAdd;

    private static final DatabaseHandler dbHandler = new DatabaseHandler();

//    static Set<ModelComboBox> countries = new TreeSet<ModelComboBox>(Comparator.comparing(ModelComboBox::getName)) {{
//        try {
//            initData(Const.COUNTRY_TABLE, Const.COUNTRY_ID, Const.COUNTRY_NAME);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }};

static Set<ModelComboBox> countries = new TreeSet<ModelComboBox>(Comparator.comparing(ModelComboBox::getName)) {{
    add(new ModelComboBox(1, "Afghanistan"));
    add(new ModelComboBox(2, "Albania"));
    add(new ModelComboBox(3, "Algeria"));
    add(new ModelComboBox(4, "Andorra"));
    add(new ModelComboBox(5, "Angola"));
    add(new ModelComboBox(6, "Antigua and Barbuda"));
    add(new ModelComboBox(7, "Argentina"));
}};

    private List<String> loadFromDb() {
        return countries.stream()
                .map(ModelComboBox::getName)
                .collect(Collectors.toList());
    }

    private static void initData(String tableName, String coloumnId, String coloumnName) throws SQLException {
        String querry = "SELECT * FROM " + tableName;
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(querry)) {
            while (resultSet.next()) {
                Integer code = resultSet.getInt(coloumnId);
                String name = resultSet.getString(coloumnName);
                countries.add(new ModelComboBox(code, name));
            }
        }
    }

    public static class HideableItem<T> {
        private final ObjectProperty<T> object = new SimpleObjectProperty<>();
        private final BooleanProperty hidden = new SimpleBooleanProperty();

        private HideableItem(T object) {
            setObject(object);
        }

        private ObjectProperty<T> objectProperty() {
            return this.object;
        }

        private T getObject() {
            return this.objectProperty().get();
        }

        private void setObject(T object) {
            this.objectProperty().set(object);
        }

        private BooleanProperty hiddenProperty() {
            return this.hidden;
        }

        private boolean isHidden() {
            return this.hiddenProperty().get();
        }

        private void setHidden(boolean hidden) {
            this.hiddenProperty().set(hidden);
        }

        @Override
        public String toString() {
            return getObject() == null ? null : getObject().toString();
        }
    }


    private static <T> ComboBox<HideableItem<T>> createComboBoxWithAutoCompletionSupport(List<T> items) {
        ObservableList<HideableItem<T>> hideableHideableItems = FXCollections.observableArrayList(
                hideableItem -> new Observable[]{hideableItem.hiddenProperty()});
        items.forEach(item ->
        {
            HideableItem<T> hideableItem = new HideableItem<>(item);
            hideableHideableItems.add(hideableItem);
        });


        FilteredList<HideableItem<T>> filteredHideableItems = new FilteredList<>(hideableHideableItems, t -> !t.isHidden());

        ComboBox<HideableItem<T>> comboBox = new ComboBox<>();
        comboBox.setItems(filteredHideableItems);


        @SuppressWarnings("unchecked")
        HideableItem<T>[] selectedItem = (HideableItem<T>[]) new HideableItem[1];

        comboBox.addEventHandler(KeyEvent.KEY_PRESSED, event ->
        {
            if (!comboBox.isShowing()) return;
            comboBox.setEditable(true);
            comboBox.getEditor().clear();
        });

        comboBox.showingProperty().addListener((observable, oldValue, newValue) ->
        {
            System.out.println("+++value 3");
            if (newValue) {
                @SuppressWarnings("unchecked")
                ListView<HideableItem> lv = ((ComboBoxListViewSkin<HideableItem>) comboBox.getSkin()).getListView();

                Platform.runLater(() ->
                {
                    if (selectedItem[0] == null)
                    {
                        double cellHeight = ((Control) lv.lookup(".list-cell")).getHeight();
                        lv.setFixedCellSize(cellHeight);
                    }
                });

                lv.scrollTo(comboBox.getValue());
            } else {
                HideableItem<T> value = comboBox.getValue();
                if (value != null) selectedItem[0] = value;

                comboBox.setEditable(false);

                System.out.println("+++value 1 " + selectedItem[0]);

                //Added here
                Optional<Integer> any = countries.stream().filter(country -> selectedItem[0].toString().equals(country.getName())).map(ModelComboBox::getCode).findAny();
                any.ifPresent(countryCode -> {
                    System.out.println("My country code here : " + countryCode);
                });

                Platform.runLater(() ->
                {
                    comboBox.getSelectionModel().select(selectedItem[0]);
                    comboBox.setValue(selectedItem[0]);
                });
            }
        });

        comboBox.setOnHidden(event -> hideableHideableItems.forEach(item -> item.setHidden(false)));

        comboBox.getEditor().textProperty().addListener((obs, oldValue, newValue) ->
        {
            if (!comboBox.isShowing()) return;

            System.out.println("+++value 3");
            Platform.runLater(() ->
            {
                if (comboBox.getSelectionModel().getSelectedItem() == null) {
                    hideableHideableItems.forEach(item -> item.setHidden(!item.getObject().toString().toLowerCase().contains(newValue.toLowerCase())));
                } else {
                    boolean validText = false;

                    for (HideableItem hideableItem : hideableHideableItems) {
                        if (hideableItem.getObject().toString().equals(newValue)) {
                            validText = true;
                            break;
                        }
                    }

                    if (!validText) comboBox.getSelectionModel().select(null);
                }
            });
        });

        return comboBox;
    }

    @FXML
    protected void initialize(){
        List<String> countries = loadFromDb();
        comboBoxCountry = createComboBoxWithAutoCompletionSupport(countries);
//        comboBoxCountry.setItems(countries);

    }

    @FXML
    private void add() {
        buttonAdd.setOnAction(event -> {
            String id = textFieldID1.getText() + textFieldID2.getText() + textFieldID3.getText() + textFieldID4.getText();
            dbHandler.createCard(parse(id), textFieldLastName.getText(),
                    parse(textFieldFirstName.getText()), parse(textFieldPatronymic.getText()),
                    textFieldDateOfBirth.getText(), parse(textFieldGender.getText()),
                    parse("jdgfd"),
                    parse(textFieldRegion.getText()),
                    textFieldOutdoors.getText(), textFieldDateOfCommission.getText(), textFieldPlaceOfCommission.getText(),
                    textFieldDateOfInitiation.getText(), parse(textFieldOfficeOfInitiation.getText()),
                    textFieldNameOfInitiation.getText(), textFieldDateOfPreparingReport.getText(),
                    parse(textFieldOfficeOfPreparingReport.getText()),
                    textFieldNameOfPreparingReport.getText(), parse(textFieldArticle.getText()),
                    textFieldDateOfDecision.getText(), textFieldDecision.getText(),
                    parse(textFieldOfficeOfDecision.getText()), textFieldNameOfDecision.getText(),
                    parse(textFieldPunishment.getText()), parse(textFieldPunishmentSum.getText()),
                    textFieldDateOfEntryIntoForce.getText(), textFieldDateSentenceEnforcement.getText(),
                    parse(textFieldAmount.getText()));
            dbHandler.addReferral(parse(id), textFieldDateDeparture.getText(), parse(textFieldOfficeDeparture.getText()),
                    textFieldDateArrival.getText(), parse(textFieldOfficeArrival.getText()));
        });
    }

    private Integer parse(String s){
        try{
            return Integer.valueOf(s);
        }catch (NumberFormatException ex){
            System.err.println("Can't spread " + s);
            return null;
        }
    }
}
