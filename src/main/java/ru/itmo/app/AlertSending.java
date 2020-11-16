package ru.itmo.app;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class AlertSending {

    static public void alertError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Ошибка");
        alert.showAndWait();
    }
    static public void alertInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Изменения применены");
        alert.showAndWait();
    }
}
