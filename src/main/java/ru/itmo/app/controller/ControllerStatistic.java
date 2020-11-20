package ru.itmo.app.controller;

import com.sun.javafx.charts.Legend;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ru.itmo.app.Const;
import ru.itmo.app.DatabaseConnection;

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
    protected void initialize() throws SQLException {
        
        XYChart.Series<String, Integer> setl = new XYChart.Series();
        setl.getData().add(new XYChart.Data("Совершенные дела", stageStatistic(Const.CARD_DATE_OF_COMMISSION)));
        setl.getData().add(new XYChart.Data("Возбужденные дела", stageStatistic(Const.CARD_DATE_OF_INITIATION)));
        setl.getData().add(new XYChart.Data("Дела с протоколом", stageStatistic(Const.CARD_DATE_OF_PREPARING_REPORT)));
        setl.getData().add(new XYChart.Data("Решенные дела", stageStatistic(Const.CARD_DATE_OF_DECISION)));
        setl.getData().add(new XYChart.Data("Вступление в силу дела", stageStatistic(Const.CARD_DATE_OF_ENTRY_INTO_FORCE)));
        setl.getData().add(new XYChart.Data("Вступление в силу дела", stageStatistic(Const.CARD_DATE_OF_DECISION)));
        setl.getData().add(new XYChart.Data("Решенные дела", stageStatistic(Const.CARD_DATE_SENTENCE_ENFORCEMENT)));
        barChart.getData().addAll(setl);
        setl.getData().forEach(d->
                d.getNode().setStyle("-fx-bar-fill: #4F8A8B"));
        Legend legend = (Legend)barChart.lookup(".chart-legend");
        Legend.LegendItem li1=new Legend.LegendItem("Количество дел", new Rectangle(10,4, Color.rgb(79, 138, 139)));
//        Legend.LegendItem li2=new Legend.LegendItem("Over 5 up to 8", new Rectangle(10,4,Color.FIREBRICK));
//        Legend.LegendItem li3=new Legend.LegendItem("Below 5", new Rectangle(10,4,Color.ORANGE));
        legend.getItems().setAll(li1);
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
