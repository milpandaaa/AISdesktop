package ru.itmo.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.List;

public class ControllerUpdate extends ControllerCreate{

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
    private Button buttonUpdate;

    @FXML
    private AnchorPane anchorPane;

    ComboBox<HideableItem<String>> comboBoxNames;
    ComboBox<HideableItem<String>> comboBoxPatronymics;
    ComboBox<HideableItem<String>> comboBoxCountry;
    ComboBox<HideableItem<String>> comboBoxGender;
    ComboBox<HideableItem<String>> comboBoxOfficeOfInitiation;
    ComboBox<HideableItem<String>> comboBoxArticles;
    ComboBox<HideableItem<String>> comboBoxOfficeOfDecision;
    ComboBox<HideableItem<String>> comboBoxOfficeArrival;
    ComboBox<HideableItem<String>> comboBoxOfficeDeparture;
    ComboBox<HideableItem<String>> comboBoxOfficeOfPreparingReport;
    ComboBox<HideableItem<String>> comboBoxPunishment;

    @Override
    protected void initialize() {
        comboBoxNames = createComboBox(names, 60, 145);
        comboBoxPatronymics = createComboBox(patronymics, 60, 210);
        comboBoxCountry = createComboBox(countries, 60, 340);
        comboBoxOfficeOfInitiation = createComboBox(offices, 360, 255);
        comboBoxArticles = createComboBox(articles, 360, 520);
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
        anchorPane.getChildren().addAll(comboBoxNames, comboBoxPatronymics, comboBoxCountry, comboBoxArticles,
                comboBoxOfficeArrival, comboBoxOfficeDeparture, comboBoxOfficeOfDecision, comboBoxOfficeOfInitiation,
                comboBoxPunishment, comboBoxOfficeOfPreparingReport, comboBoxGender);
    }

    @FXML
    private void update() {
        buttonUpdate.setOnAction(event -> {
            String id = textFieldID1.getText() + textFieldID2.getText() + textFieldID3.getText() + textFieldID4.getText();

        });
    }


}
