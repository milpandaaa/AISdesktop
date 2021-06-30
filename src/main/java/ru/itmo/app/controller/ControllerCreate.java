package ru.itmo.app.controller;

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
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import ru.itmo.app.*;
import ru.itmo.app.model.ModelComboBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class ControllerCreate extends ControllerSearch {
    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldDateOfBirth;

    @FXML
    private TextField textFieldDateOfPreparingReport;

    @FXML
    private TextField textFieldDateOfCommission;

    @FXML
    private TextField textFieldRegion;

    @FXML
    private TextField textFieldOutdoors;

    @FXML
    private TextField textFieldPlaceOfCommission;

    @FXML
    private TextField textFieldDateOfInitiation;

    @FXML
    private TextField textFieldNameOfInitiation;

    @FXML
    private TextField textFieldNameOfPreparingReport;

    @FXML
    private TextField textFieldPunishmentSum;

    @FXML
    private TextField textFieldDateOfEntryIntoForce;

    @FXML
    private TextField textFieldAmount;


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
    private TextField textFieldID1;

    @FXML
    private TextField textFieldID2;

    @FXML
    private TextField textFieldID3;

    @FXML
    private TextField textFieldID4;

    @FXML
    private Button buttonAdd;

    @FXML
    private AnchorPane anchorPane;

    private ComboBox<HideableItem<String>> comboBoxNames = new ComboBox<HideableItem<String>>();
    private ComboBox<HideableItem<String>> comboBoxPatronymics = new ComboBox<HideableItem<String>>();
    private ComboBox<HideableItem<String>> comboBoxCountry = new ComboBox<HideableItem<String>>();
    private ComboBox<HideableItem<String>> comboBoxGender = new ComboBox<HideableItem<String>>();
    private ComboBox<HideableItem<String>> comboBoxOfficeOfInitiation = new ComboBox<HideableItem<String>>();
    private ComboBox<HideableItem<String>> comboBoxArticles = new ComboBox<HideableItem<String>>();
    private ComboBox<HideableItem<String>> comboBoxOfficeOfDecision = new ComboBox<HideableItem<String>>();
    private ComboBox<HideableItem<String>> comboBoxOfficeArrival = new ComboBox<HideableItem<String>>();
    private ComboBox<HideableItem<String>> comboBoxOfficeDeparture = new ComboBox<HideableItem<String>>();
    private ComboBox<HideableItem<String>> comboBoxOfficeOfPreparingReport = new ComboBox<HideableItem<String>>();
    private ComboBox<HideableItem<String>> comboBoxPunishment = new ComboBox<HideableItem<String>>();

    protected static final DatabaseHandler dbHandler = new DatabaseHandler();

    protected static Set<ModelComboBox> countries = new TreeSet<ModelComboBox>(Comparator.comparing(ModelComboBox::getName)) {{
        try {
            addAll(initData(Const.COUNTRY_TABLE, Const.COUNTRY_ID, Const.COUNTRY_NAME));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }};

    protected Set<ModelComboBox> names = new TreeSet<ModelComboBox>(Comparator.comparing(ModelComboBox::getName)) {{
        try {
            addAll(initData(Const.NAME_TABLE, Const.NAME_ID, Const.NAME));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }};

    protected Set<ModelComboBox> patronymics = new TreeSet<ModelComboBox>(Comparator.comparing(ModelComboBox::getName)) {{
        try {
            addAll(initData(Const.PATRONYMIC_TABLE, Const.PATRONYMIC_ID, Const.PATRONYMIC));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }};

    protected static Set<ModelComboBox> offices = new TreeSet<ModelComboBox>(Comparator.comparing(ModelComboBox::getName)) {{
        try {
            addAll(initData(Const.OFFICE_TABLE, Const.OFFICE_ID, Const.OFFICE));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }};

    protected static Set<ModelComboBox> gender = new TreeSet<ModelComboBox>(Comparator.comparing(ModelComboBox::getName)) {{
        try {
            addAll(initData(Const.GENDER_TABLE, Const.GENDER_ID, Const.GENDER));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }};

    protected static Set<ModelComboBox> punichments = new TreeSet<ModelComboBox>(Comparator.comparing(ModelComboBox::getName)) {{
        try {
            addAll(initData(Const.PUNISHMENT_TABLE, Const.PUNISHMENT_ID, Const.PUNISHMENT));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }};

    protected static Set<ModelComboBox> articles = new TreeSet<ModelComboBox>(Comparator.comparing(ModelComboBox::getName)) {{
        try {
            addAll(initData(Const.ARTICLE_TABLE, Const.ARTICLE_ID, Const.ARTICLE));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }};


    protected List<String> loadFromDb(Set<ModelComboBox> set) {
        return set.stream()
                .map(ModelComboBox::getName)
                .collect(Collectors.toList());
    }

    protected static ArrayList<ModelComboBox> initData(String tableName, String coloumnId, String coloumnName) throws SQLException {
        ArrayList<ModelComboBox> treeSet = new ArrayList<ModelComboBox>();
        String querry = "SELECT * FROM " + tableName;
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(querry)) {
            while (resultSet.next()) {
                Integer code = resultSet.getInt(coloumnId);
                String name = resultSet.getString(coloumnName);
                treeSet.add(new ModelComboBox(code, name));
            }
        }
        return treeSet;
    }

    public static class HideableItem<T> {

        private final ObjectProperty<T> object = new SimpleObjectProperty<>();
        private final BooleanProperty hidden = new SimpleBooleanProperty();

        public HideableItem(T object) {
            setObject(object);
        }

        private ObjectProperty<T> objectProperty() {
            return this.object;
        }

        public T getObject() {
            return this.objectProperty().get();
        }

        public void setObject(T object) {
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


    protected static <T> ComboBox<HideableItem<T>> createComboBoxWithAutoCompletionSupport(List<T> items) {
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
            if (newValue) {
                @SuppressWarnings("unchecked")
                ListView<HideableItem> lv = ((ComboBoxListViewSkin<HideableItem>) comboBox.getSkin()).getListView();

                Platform.runLater(() ->
                {
                    if (selectedItem[0] == null) {
                        double cellHeight = ((Control) lv.lookup(".list-cell")).getHeight();
                        lv.setFixedCellSize(cellHeight);
                    }
                });

                lv.scrollTo(comboBox.getValue());
            } else {
                HideableItem<T> value = comboBox.getValue();
                if (value != null) selectedItem[0] = value;

                comboBox.setEditable(false);
//                System.out.println("+++value 1 " + selectedItem[0]);
                //Added here
//                Optional<Integer> any = names.stream().filter(country -> selectedItem[0].toString().equals(country.getName())).map(ModelComboBox::getCode).findAny();
//                any.ifPresent(countryCode -> {
//                    System.out.println("My country code here : " + countryCode);
//                });

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
    protected void initialize() {
        comboBoxNames = createComboBox(names, 60, 145);
        comboBoxPatronymics = createComboBox(patronymics, 60, 210);
        comboBoxCountry = createComboBox(countries, 60, 340);
        comboBoxOfficeOfInitiation = createComboBox(offices, 360, 255);
        comboBoxArticles = createComboBox(articles, 360, 520);
        comboBoxArticles.setMaxWidth(200);
        comboBoxOfficeOfDecision = createComboBox(offices, 360, 695);
        comboBoxOfficeArrival = createComboBox(offices, 660, 430);
        comboBoxOfficeDeparture = createComboBox(offices, 660, 340);
        comboBoxOfficeOfPreparingReport = createComboBox(offices, 360, 430);
        comboBoxPunishment = createComboBox(punichments, 360, 785);
        List<String> listGender = loadFromDb(gender);
        comboBoxGender = createComboBoxWithAutoCompletionSupport(listGender);
        comboBoxGender.setMinHeight(30);
        comboBoxGender.setMinWidth(50);
        comboBoxGender.setStyle("-fx-background-color: #4F8A8B; -fx-background-radius: 5;");
        comboBoxGender.setLayoutX(190);
        comboBoxGender.setLayoutY(275);
        comboBoxGender.setValue(new HideableItem<String>(""));
        anchorPane.getChildren().addAll(comboBoxNames, comboBoxPatronymics, comboBoxCountry, comboBoxArticles,
                comboBoxOfficeArrival, comboBoxOfficeDeparture, comboBoxOfficeOfDecision, comboBoxOfficeOfInitiation,
                comboBoxPunishment, comboBoxOfficeOfPreparingReport, comboBoxGender);
    }

    protected ComboBox<HideableItem<String>> createComboBox(Set<ModelComboBox> set, double x, double y) {
        List<String> list = loadFromDb(set);
        ComboBox<HideableItem<String>> comboBox = createComboBoxWithAutoCompletionSupport(list);
        comboBox.setMinHeight(30);
        comboBox.setMinWidth(180);
        comboBox.setStyle("-fx-background-color: #4F8A8B; -fx-background-radius: 5;");
        comboBox.setLayoutX(x);
        comboBox.setLayoutY(y);
        comboBox.setValue(new HideableItem<String>(""));
        return comboBox;
    }

    protected Integer comboBoxGetValue(ComboBox<HideableItem<String>> comboBox, Set<ModelComboBox> set) {
        final String currentVal = comboBox.getValue().toString();
        return set.stream()
                .filter(country -> currentVal.equals(country.getName()))
                .map(ModelComboBox::getCode)
                .peek(val -> System.out.println("   " + val))
                .findAny()
                .orElse(null);
    }

    @FXML
    private void add() {
        buttonAdd.setOnAction(event -> {
            Integer id = Integer.valueOf(textFieldID1.getText() + textFieldID2.getText() + textFieldID3.getText() + textFieldID4.getText());
            try {
                dbHandler.createCard(id, textFieldLastName.getText(),
                        comboBoxGetValue(comboBoxNames, names),
                        comboBoxGetValue(comboBoxPatronymics, patronymics),
                        LogControl.checkLessDateNow(textFieldDateOfBirth.getId(), textFieldDateOfBirth.getText()),
                        comboBoxGetValue(comboBoxGender, gender),
                        comboBoxGetValue(comboBoxCountry, countries),
                        parseInt(textFieldRegion.getText()),
                        textFieldOutdoors.getText(),
                        LogControl.checkLessDatTimeNow(textFieldDateOfCommission.getId(), textFieldDateOfCommission.getText()), textFieldPlaceOfCommission.getText(),
                        LogControl.checkAfterDate(textFieldDateOfInitiation.getId(), textFieldDateOfInitiation.getText(), textFieldDateOfCommission.getText().substring(0, 10)),
                        comboBoxGetValue(comboBoxOfficeOfInitiation, offices),
                        textFieldNameOfInitiation.getText(),
                        LogControl.checkAfterDate(textFieldDateOfPreparingReport.getId(),textFieldDateOfPreparingReport.getText(),textFieldDateOfInitiation.getText()),
                        comboBoxGetValue(comboBoxOfficeOfPreparingReport, offices),
                        textFieldNameOfPreparingReport.getText(), comboBoxGetValue(comboBoxArticles, articles),
                        LogControl.checkAfterDate(textFieldDateOfDecision.getId(),textFieldDateOfDecision.getText(), textFieldDateOfPreparingReport.getText()),
                        textFieldDecision.getText(), comboBoxGetValue(comboBoxOfficeOfDecision, offices), textFieldNameOfDecision.getText(),
                        comboBoxGetValue(comboBoxPunishment, punichments), parseInt(textFieldPunishmentSum.getText()),
                        LogControl.checkAfterDate(textFieldDateOfEntryIntoForce.getId(),textFieldDateOfEntryIntoForce.getText(), textFieldDateOfDecision.getText()),
                        LogControl.checkAfterDate(textFieldDateSentenceEnforcement.getId(), textFieldDateSentenceEnforcement.getText(),textFieldDateOfEntryIntoForce.getText()),
                        parseInt(textFieldAmount.getText()));
            dbHandler.addReferral(id, LogControl.checkAfterDate(textFieldDateDeparture.getId(), textFieldDateDeparture.getText(), textFieldDateOfCommission.getText().substring(0, 10)), comboBoxGetValue(comboBoxOfficeDeparture, offices),
                    LogControl.checkAfterDate(textFieldDateArrival.getId(), textFieldDateArrival.getText(), textFieldDateDeparture.getText()), comboBoxGetValue(comboBoxOfficeArrival, offices));
            AlertSending.alertInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    protected Integer parseInt(String s) {
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException ex) {
            System.err.println("Can't spread " + s);
            return null;
        }
    }

}
