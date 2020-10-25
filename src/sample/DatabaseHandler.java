package sample;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPost + "/" + dbName +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;

    }

    public void addName(String name) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO "+ Const.NAME_TABLE + "("
                + Const.NAME +")"+
                "VALUES(?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        try {
            prSt.setString(1,name);
            prSt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addPatr(String name) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO "+ Const.PATRONYMIC_TABLE + "("
                + Const.PATRONYMIC +")"+
                "VALUES(?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        try {
            prSt.setString(1,name);
            prSt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createCard(String last_name, Integer first_name, Integer patronymic, LocalDate date_of_birth,
                           Integer gender, Integer country_of_birth, Integer region, Integer country_of_registration,
                           String city, String outdoors, LocalDateTime date_of_commission,
                           String place_of_commission, LocalDate date_of_initiation, Integer office_of_initiation,
                           String name_of_initiation, LocalDate date_of_preparing_report, String name_of_preparing_report,
                           Integer id_article, LocalDate date_of_decision, Integer office_of_decision, Integer punishment,
                           Integer sum, LocalDate date_of_entry_into_force, LocalDate date_sentence_enforcement, Integer amount) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO "+ Const.CARD_TABLE + "("
                + Const.CARD_LAST_NAME + "," + Const.CARD_FIRST_NAME + "," + Const.PATRONYMIC + "," + Const.CARD_DATE_OF_BIRTH + "," +
                Const.GENDER + "," + Const.CARD_COUNTY_0F_BIRTH + "," + Const.CARD_REGION + "," + Const.CARD_COUNTY_0F_REGISTRATION + "," +
                Const.CARD_CITY + "," + Const.CARD_OUTDOORS + "," + Const.CARD_DATE_OF_COMMISSION + "," + Const.CARD_PLACE_OF_COMMISSION + "," +
                Const.CARD_DATE_OF_INITIATION + "," + Const.CARD_OFFICE_OF_INITIATION + "," + Const.CARD_NAME_OF_INITIATION + "," +
                Const.CARD_DATE_OF_PREPARING_REPORT + "," + Const.CARD_NAME_OF_PREPARING_REPORT + "," + Const.CARD_ARTICLE + "," +
                Const.CARD_DATE_OF_DECISION + "," + Const.CARD_DATE_OF_DECISION + "," + Const.CARD_PUNISHMENT + "," + Const.CARD_SUM + "," +
                Const.CARD_DATE_OF_ENTRY_INTO_FORCE + "," + Const.CARD_DATE_SENTENCE_ENFORCEMENT + "," + Const.CARD_AMOUNT +")"+
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        try {
            prSt.setString(1, last_name);
            prSt.setString(2, String.valueOf(first_name));
            prSt.setString(3, String.valueOf(patronymic));
            prSt.setString(4, String.valueOf(date_of_birth));
            prSt.setString(5, String.valueOf(gender));
            prSt.setString(6, String.valueOf(country_of_birth));
            prSt.setString(7, String.valueOf(region));
            prSt.setString(8, String.valueOf(country_of_registration));
            prSt.setString(9, city);
            prSt.setString(10, outdoors);
            prSt.setString(11, String.valueOf(date_of_commission));
            prSt.setString(12, place_of_commission);
            prSt.setString(13, String.valueOf(date_of_initiation));
            prSt.setString(14, String.valueOf(office_of_initiation));
            prSt.setString(15, name_of_initiation);
            prSt.setString(16, String.valueOf(date_of_preparing_report));
            prSt.setString(17, name_of_preparing_report);
            prSt.setString(18, String.valueOf(id_article));
            prSt.setString(19, String.valueOf(date_of_decision));
            prSt.setString(20, String.valueOf(office_of_decision));
            prSt.setString(21, String.valueOf(punishment));
            prSt.setString(22, String.valueOf(sum));
            prSt.setString(23, String.valueOf(date_of_entry_into_force));
            prSt.setString(24, String.valueOf(date_sentence_enforcement));
            prSt.setString(25, String.valueOf(amount));

            prSt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
