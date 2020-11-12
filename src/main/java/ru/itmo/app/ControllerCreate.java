package ru.itmo.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import ru.itmo.app.service.ComboboxService;

import java.util.List;

import static ru.itmo.app.service.ComboboxService.createComboBoxWithAutoCompletionSupport;

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
    private TextField textFieldCountry;

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

    @FXML
    private AnchorPane createAnchorPane;

    private static final DatabaseHandler dbHandler = new DatabaseHandler();

    @Override
    protected void initialize() {
        //<ComboBox fx:id="comboBox"  onAction="#add" prefHeight="25.0" prefWidth="180.0"
        // style="-fx-background-color: #4F8A8B; -fx-background-radius: 5;"
        // AnchorPane.leftAnchor="60.0" AnchorPane.topAnchor="145.0"/>

        ComboboxService comboboxService = new ComboboxService();
        List<String> countries = comboboxService.loadFromDb();

        ComboBox<ComboboxService.HideableItem<String>> comboBox = createComboBoxWithAutoCompletionSupport(countries);
        //comboBox.setMaxWidth(Double.MAX_VALUE);
//        comboBox.setMinWidth(30);
//        comboBox.setPrefWidth(50);
        comboBox.setMinHeight(30);
        comboBox.setMinWidth(100);

        createAnchorPane.getChildren().add(comboBox);
    }

    @FXML
    private void add() {
        buttonAdd.setOnAction(event -> {
            String id = textFieldID1.getText() + textFieldID2.getText() + textFieldID3.getText() + textFieldID4.getText();
            dbHandler.createCard(parse(id), textFieldLastName.getText(),
                    parse(textFieldFirstName.getText()), parse(textFieldPatronymic.getText()),
                    textFieldDateOfBirth.getText(), parse(textFieldGender.getText()),
                    parse(textFieldCountry.getText()), parse(textFieldRegion.getText()),
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

    Integer parse(String s){
        try{
            return Integer.valueOf(s);
        }catch (NumberFormatException ex){
            System.err.println("Не могу распрасить значение" + s);
            return null;
        }
    }
}
