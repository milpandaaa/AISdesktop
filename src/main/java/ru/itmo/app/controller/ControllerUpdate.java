package ru.itmo.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import ru.itmo.app.AlertSending;
import ru.itmo.app.Const;
import ru.itmo.app.DatabaseConnection;
import ru.itmo.app.model.ModelComboBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

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
    private Text textFieldID;

    @FXML
    private Button buttonUpdate;

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

    @FXML
    protected void initialize() {
        String querry = "SELECT * FROM " + Const.CARD_TABLE + " where " + Const.CARD_ID + " = " + getIdCard();
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(querry)) {
            resultSet.next();
        textFieldID.setText(getIdCard().toString());
        textFieldLastName.setText(parse(resultSet.getString(Const.CARD_LAST_NAME)));
        textFieldDateOfBirth.setText(parse(resultSet.getString(Const.CARD_DATE_OF_BIRTH)));
        textFieldDateOfPreparingReport.setText(parse(resultSet.getString(Const.CARD_DATE_OF_PREPARING_REPORT)));
        textFieldDateOfCommission.setText(parse(resultSet.getString(Const.CARD_DATE_OF_COMMISSION)));
        textFieldRegion.setText(parse(resultSet.getString(Const.CARD_REGION)));
        textFieldOutdoors.setText(parse(resultSet.getString(Const.CARD_OUTDOORS)));
        textFieldPlaceOfCommission.setText(parse(resultSet.getString(Const.CARD_PLACE_OF_COMMISSION)));
        textFieldDateOfInitiation.setText(parse(resultSet.getString(Const.CARD_DATE_OF_INITIATION)));
        textFieldNameOfInitiation.setText(parse(resultSet.getString(Const.CARD_NAME_OF_INITIATION)));
        textFieldNameOfPreparingReport.setText(parse(resultSet.getString(Const.CARD_NAME_OF_PREPARING_REPORT)));
        textFieldPunishmentSum.setText(parse(resultSet.getString(Const.CARD_PUNISHMENT)));
        textFieldDateOfEntryIntoForce.setText(parse(resultSet.getString(Const.CARD_DATE_OF_ENTRY_INTO_FORCE)));
        textFieldAmount.setText(parse(resultSet.getString(Const.CARD_AMOUNT)));
        textFieldDateSentenceEnforcement.setText(parse(resultSet.getString(Const.CARD_DATE_SENTENCE_ENFORCEMENT)));
        textFieldDateOfDecision.setText(parse(resultSet.getString(Const.CARD_DATE_OF_DECISION)));
        textFieldNameOfDecision.setText(parse(resultSet.getString(Const.CARD_NAME_OF_DECISION)));
        textFieldDecision.setText(parse(resultSet.getString(Const.CARD_DECISION)));
        comboBoxNames = createComboBox(names, 60, 145, searchDictionaryWord(Const.NAME_TABLE, Const.NAME, resultSet.getInt(Const.CARD_FIRST_NAME)));
        comboBoxPatronymics = createComboBox(patronymics, 60, 210, searchDictionaryWord(Const.PATRONYMIC_TABLE, Const.PATRONYMIC, resultSet.getInt(Const.CARD_PATRONYMIC)));
        comboBoxCountry = createComboBox(countries, 60, 340, searchDictionaryWord(Const.COUNTRY_TABLE, Const.COUNTRY_NAME, resultSet.getInt(Const.CARD_COUNTY)));
        comboBoxOfficeOfInitiation = createComboBox(offices, 360, 255, searchDictionaryWord(Const.OFFICE_TABLE, Const.OFFICE, resultSet.getInt(Const.CARD_OFFICE_OF_INITIATION)));
        comboBoxArticles = createComboBox(articles, 360, 520, searchDictionaryWord(Const.ARTICLE_TABLE, Const.ARTICLE, resultSet.getInt(Const.CARD_ARTICLE)));
        comboBoxOfficeOfDecision = createComboBox(offices, 360, 695, searchDictionaryWord(Const.OFFICE_TABLE, Const.OFFICE, resultSet.getInt(Const.CARD_OFFICE_OF_DECISION)));
        comboBoxOfficeOfPreparingReport = createComboBox(offices, 360, 430, searchDictionaryWord(Const.OFFICE_TABLE, Const.OFFICE, resultSet.getInt(Const.CARD_OFFICE_OF_PREPARING_REPORT)));
        comboBoxPunishment = createComboBox(punichments, 360, 785, searchDictionaryWord(Const.PUNISHMENT_TABLE, Const.PUNISHMENT, resultSet.getInt(Const.CARD_PUNISHMENT)));
        comboBoxGender = createComboBox(gender, 190, 275, searchDictionaryWord(Const.GENDER_TABLE, Const.GENDER, resultSet.getInt(Const.CARD_GENDER)));
        comboBoxGender.setMinWidth(50);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String select = "SELECT * FROM " + Const.REFERRAL_TABLE + " where " + Const.REFERRAL_CARD + " = " + getIdCard();
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(select)) {
            resultSet.next();
            comboBoxOfficeArrival = createComboBox(offices, 660, 430, searchDictionaryWord(Const.OFFICE_TABLE, Const.OFFICE, resultSet.getInt(Const.REFERRAL_OFFICE_ARRIVAL)));
            comboBoxOfficeDeparture = createComboBox(offices, 660, 340, searchDictionaryWord(Const.OFFICE_TABLE, Const.OFFICE, resultSet.getInt(Const.REFERRAL_OFFICE_DEPARTURE)));
            textFieldDateArrival.setText(parse(resultSet.getString(Const.REFERRAL_DATE_ARRIVAL)));
            textFieldDateDeparture.setText(parse(resultSet.getString(Const.REFERRAL_DATE_DEPARTURE)));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        anchorPane.getChildren().addAll(comboBoxNames, comboBoxPatronymics, comboBoxCountry, comboBoxArticles,
                comboBoxOfficeArrival, comboBoxOfficeDeparture, comboBoxOfficeOfDecision, comboBoxOfficeOfInitiation,
                comboBoxPunishment, comboBoxOfficeOfPreparingReport, comboBoxGender);
    }

    private ComboBox<HideableItem<String>> createComboBox(Set<ModelComboBox> set, double x, double y, String value){
        ComboBox<HideableItem<String>> comboBox = createComboBox(set, x, y);
        comboBox.setValue(new HideableItem<String>(value));
        return comboBox;
    }

    @FXML
    private void add() {
        buttonUpdate.setOnAction(event -> {
            dbHandler.editCard(getIdCard(), textFieldLastName.getText(),
                    comboBoxGetValue(comboBoxNames, names),
                    comboBoxGetValue(comboBoxPatronymics, patronymics),
                    textFieldDateOfBirth.getText(),
                    comboBoxGetValue(comboBoxGender, gender),
                    comboBoxGetValue(comboBoxCountry, countries),
                    parseInt(textFieldRegion.getText()),
                    textFieldOutdoors.getText(),
                    textFieldDateOfCommission.getText(), textFieldPlaceOfCommission.getText(),
                    textFieldDateOfInitiation.getText(), comboBoxGetValue(comboBoxOfficeOfInitiation, offices),
                    textFieldNameOfInitiation.getText(), textFieldDateOfPreparingReport.getText(),
                    comboBoxGetValue(comboBoxOfficeOfPreparingReport, offices),
                    textFieldNameOfPreparingReport.getText(), comboBoxGetValue(comboBoxArticles, articles),
                    textFieldDateOfDecision.getText(), textFieldDecision.getText(),
                    comboBoxGetValue(comboBoxOfficeOfDecision, offices), textFieldNameOfDecision.getText(),
                    comboBoxGetValue(comboBoxPunishment, punichments), parseInt(textFieldPunishmentSum.getText()),
                    textFieldDateOfEntryIntoForce.getText(), textFieldDateSentenceEnforcement.getText(),
                    parseInt(textFieldAmount.getText()));
            dbHandler.editReferral(getIdCard(), textFieldDateDeparture.getText(), comboBoxGetValue(comboBoxOfficeDeparture, offices),
                    textFieldDateArrival.getText(), comboBoxGetValue(comboBoxOfficeArrival, offices));
            AlertSending.alertInfo();
        });
    }


}