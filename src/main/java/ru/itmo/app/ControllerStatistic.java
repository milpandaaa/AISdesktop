package ru.itmo.app;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerStatistic{

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    protected void initialize() throws SQLException, ClassNotFoundException {
        XYChart.Series setl = new XYChart.Series();
        setl.getData().add(new XYChart.Data("Совершенные дела", stageStatistic(Const.CARD_DATE_OF_COMMISSION)));
        setl.getData().add(new XYChart.Data("Возбужденные дела", stageStatistic(Const.CARD_DATE_OF_INITIATION)));
        setl.getData().add(new XYChart.Data("Дела с протоколом", stageStatistic(Const.CARD_DATE_OF_PREPARING_REPORT)));
        setl.getData().add(new XYChart.Data("Решенные дела", stageStatistic(Const.CARD_DATE_OF_DECISION)));
        setl.getData().add(new XYChart.Data("Вступление в силу дела", stageStatistic(Const.CARD_DATE_OF_ENTRY_INTO_FORCE)));
        setl.getData().add(new XYChart.Data("Вступление в силу дела", stageStatistic(Const.CARD_DATE_OF_DECISION)));
        setl.getData().add(new XYChart.Data("Решенные дела", stageStatistic(Const.CARD_DATE_SENTENCE_ENFORCEMENT)));
        barChart.getData().addAll(setl);

    }

    private Integer stageStatistic(String process) throws SQLException {
        String querry = "SELECT COUNT(*) FROM " + Const.CARD_TABLE + " where " + process + " IS NOT NULL";
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(querry)) {
            resultSet.next();
            Integer answer = resultSet.getInt(1);
            return answer;
        }
    }
}
