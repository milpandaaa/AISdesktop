package sample;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler {

    public void addName(String name) {
        String insert = "INSERT INTO " + Const.NAME_TABLE + "("
                + Const.NAME + ")" +
                "VALUES(?)";

        try(PreparedStatement prSt = DatabaseConnection.getInstance().getConnection().prepareStatement(insert)) {
            prSt.setString(1, name);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPatr(String name) {
        String insert = "INSERT INTO " + Const.PATRONYMIC_TABLE + "("
                + Const.PATRONYMIC + ")" +
                "VALUES(?)";

        try(PreparedStatement prSt = DatabaseConnection.getInstance().getConnection().prepareStatement(insert)) {
            prSt.setString(1, name);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCard(Integer id, String last_name, Integer first_name, Integer patronymic, String date_of_birth,
                           Integer gender, Integer country, Integer region, String outdoors,
                           String date_of_commission, String place_of_commission,
                           String date_of_initiation, Integer office_of_initiation, String name_of_initiation,
                           String date_of_preparing_report, Integer office_of_preparing_report, String name_of_preparing_report, Integer id_article,
                           String date_of_decision, String decision, Integer office_of_decision, String name_of_decision, Integer punishment, Integer sum,
                           String date_of_entry_into_force,
                           String date_sentence_enforcement, Integer amount){
        String insert = "INSERT INTO " + Const.CARD_TABLE + "("
                + Const.CARD_ID + "," + Const.CARD_LAST_NAME + "," + Const.CARD_FIRST_NAME + "," + Const.PATRONYMIC + "," + Const.CARD_DATE_OF_BIRTH + "," + Const.GENDER + "," + Const.CARD_COUNTY + "," + Const.CARD_REGION + "," + Const.CARD_OUTDOORS + ","
                + Const.CARD_DATE_OF_COMMISSION + "," + Const.CARD_PLACE_OF_COMMISSION + "," +
                Const.CARD_DATE_OF_INITIATION + "," + Const.CARD_OFFICE_OF_INITIATION + "," + Const.CARD_NAME_OF_INITIATION + "," +
                Const.CARD_DATE_OF_PREPARING_REPORT + "," + Const.CARD_OFFICE_OF_PREPARING_REPORT + "," + Const.CARD_NAME_OF_PREPARING_REPORT + "," + Const.CARD_ARTICLE + "," +
                Const.CARD_DATE_OF_DECISION + "," + Const.CARD_DECISION + "," + Const.CARD_OFFICE_OF_DECISION + "," + Const.CARD_NAME_OF_DECISION + "," + Const.CARD_PUNISHMENT + "," + Const.CARD_SUM + "," +
                Const.CARD_DATE_OF_ENTRY_INTO_FORCE + ","
                + Const.CARD_DATE_SENTENCE_ENFORCEMENT + "," + Const.CARD_AMOUNT + ")" +
                "VALUES(?, ?, ?, ?, ?, ?,?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
        try (PreparedStatement prSt = DatabaseConnection.getInstance().getConnection().prepareStatement(insert)) {
            prSt.setString(1, String.valueOf(id));
            prSt.setString(2, last_name);
            prSt.setString(3, String.valueOf(first_name));
            prSt.setString(4, String.valueOf(patronymic));
            prSt.setString(5, date_of_birth);
            prSt.setString(6, String.valueOf(gender));
            prSt.setString(7, String.valueOf(country));
            prSt.setString(8, String.valueOf(region));
            prSt.setString(9, String.valueOf(outdoors));
            prSt.setString(10, String.valueOf(date_of_commission));
            prSt.setString(11, place_of_commission);
            prSt.setString(12, String.valueOf(date_of_initiation));
            prSt.setString(13, String.valueOf(office_of_initiation));
            prSt.setString(14, name_of_initiation);
            prSt.setString(15, String.valueOf(date_of_preparing_report));
            prSt.setString(16, String.valueOf(office_of_preparing_report));
            prSt.setString(17, name_of_preparing_report);
            prSt.setString(18, String.valueOf(id_article));
            prSt.setString(19, String.valueOf(date_of_decision));
            prSt.setString(20, decision);
            prSt.setString(21, String.valueOf(office_of_decision));
            prSt.setString(22, name_of_decision);
            prSt.setString(23, String.valueOf(punishment));
            prSt.setString(24, String.valueOf(sum));
            prSt.setString(25, String.valueOf(date_of_entry_into_force));
            prSt.setString(26, String.valueOf(date_sentence_enforcement));
            prSt.setString(27, String.valueOf(amount));

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addReferral(Integer card, String dateDeparture, Integer officeDeparture,
                            String dateArrival, Integer officeArrival) {
        String insert = "INSERT INTO " + Const.REFERRAL_TABLE + "("
                + Const.REFERRAL_CARD + "," + Const.REFERRAL_DATE_DEPARTURE + "," +
                Const.REFERRAL_OFFICE_DEPARTURE + "," + Const.REFERRAL_DATE_ARRIVAL + "," +
                Const.REFERRAL_OFFICE_ARRIVAL + ")" +
                "VALUES(?,?,?,?,?)";

        try (PreparedStatement prSt = DatabaseConnection.getInstance().getConnection().prepareStatement(insert)) {
            prSt.setString(1, String.valueOf(card));
            prSt.setString(1, dateDeparture);
            prSt.setString(1, String.valueOf(officeDeparture));
            prSt.setString(1, dateArrival);
            prSt.setString(1, String.valueOf(officeArrival));
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
