package ru.itmo.app;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

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
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement prSt = DatabaseConnection.getInstance().getConnection().prepareStatement(insert)) {
            prSt.setInt(1, id);
            prSt.setString(2, last_name);
            setInteger(3, first_name, prSt);
            setInteger(4, patronymic, prSt);
            setDate(5, date_of_birth, prSt);
            setInteger(6, gender, prSt);
            setInteger(7, country, prSt);
            setInteger(8, region, prSt);
            prSt.setString(9, outdoors);
            setDate(10, date_of_commission, prSt);
            prSt.setString(11, place_of_commission);
            setDate(12, date_of_initiation, prSt);
            setInteger(13, office_of_initiation, prSt);
            prSt.setString(14, name_of_initiation);
            setDate(15, date_of_preparing_report, prSt);
            setInteger(16, office_of_preparing_report, prSt);
            prSt.setString(17, name_of_preparing_report);
            setInteger(18, id_article, prSt);
            setDate(19, date_of_decision, prSt);
            prSt.setString(20, decision);
            setInteger(21, office_of_decision, prSt);
            prSt.setString(22, name_of_decision);
            setInteger(23, punishment, prSt);
            setInteger(24, sum, prSt);
            setDate(25, date_of_entry_into_force, prSt);
            setDate(26,date_sentence_enforcement, prSt);
            setInteger(27, amount, prSt);
            prSt.executeUpdate();
            System.out.println(prSt);
        } catch (SQLException e) {
            AlertSending.alertError();
            e.printStackTrace();
        }
    }

    private void setInteger(Integer parameterIndex, Integer attribute, PreparedStatement prSt) throws SQLException {
        if (attribute == null) {
            prSt.setNull(parameterIndex, Types.INTEGER);
        }
        else
            prSt.setInt(parameterIndex, attribute);
    }

    private void setDate(Integer parameterIndex, String attribute, PreparedStatement prSt) throws SQLException {
        if(attribute==null)
            prSt.setNull(parameterIndex, Types.DATE);
        else {
            if (attribute.equals("")) {
                prSt.setNull(parameterIndex, Types.DATE);
            } else
                prSt.setString(parameterIndex, attribute);
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
            prSt.setInt(1, card);
            setDate(2, dateDeparture, prSt);
            setInteger(3, officeDeparture, prSt);
            setDate(4, dateArrival, prSt);
            setInteger(5, officeArrival, prSt);
            prSt.executeUpdate();
        } catch (SQLException e) {
            AlertSending.alertError();
            e.printStackTrace();
        }
    }

    public void editCard(Integer id, String last_name, Integer first_name, Integer patronymic, String date_of_birth,
                         Integer gender, Integer country, Integer region, String outdoors,
                         String date_of_commission, String place_of_commission,
                         String date_of_initiation, Integer office_of_initiation, String name_of_initiation,
                         String date_of_preparing_report, Integer office_of_preparing_report, String name_of_preparing_report, Integer id_article,
                         String date_of_decision, String decision, Integer office_of_decision, String name_of_decision, Integer punishment, Integer sum,
                         String date_of_entry_into_force,
                         String date_sentence_enforcement, Integer amount){
        String update = "UPDATE " + Const.CARD_TABLE + " SET " +
                Const.CARD_LAST_NAME + " = ?, " + Const.CARD_FIRST_NAME + " = ?, " + Const.CARD_PATRONYMIC + " = ?, " + Const.CARD_DATE_OF_BIRTH + " = ?, " +
                Const.CARD_GENDER + " = ?, " + Const.CARD_COUNTY + " = ?, " + Const.CARD_REGION + " = ?, " + Const.CARD_OUTDOORS + " = ?, " +
                Const.CARD_DATE_OF_COMMISSION + " = ?, " + Const.CARD_PLACE_OF_COMMISSION + " = ?, " + Const.CARD_DATE_OF_INITIATION + " = ?, " + Const.CARD_OFFICE_OF_INITIATION + " = ?, " +
                Const.CARD_NAME_OF_INITIATION + " = ?, " + Const.CARD_DATE_OF_PREPARING_REPORT + " = ?, " + Const.CARD_OFFICE_OF_PREPARING_REPORT + " = ?, " + Const.CARD_NAME_OF_PREPARING_REPORT + " = ?, " +
                Const.CARD_ARTICLE + " = ?, " + Const.CARD_DATE_OF_DECISION + " = ?, " + Const.CARD_DECISION + " = ?, " + Const.CARD_OFFICE_OF_DECISION + " = ?, " +
                Const.CARD_NAME_OF_DECISION + " = ?, " + Const.CARD_PUNISHMENT + " = ?, " + Const.CARD_SUM + " = ?, " + Const.CARD_DATE_OF_ENTRY_INTO_FORCE + " = ?, " +
                Const.CARD_DATE_SENTENCE_ENFORCEMENT + " = ?, " + Const.CARD_AMOUNT + " = ? " +
        " WHERE " + Const.CARD_ID +" = ?";
        try (PreparedStatement prSt = DatabaseConnection.getInstance().getConnection().prepareStatement(update)) {
            prSt.setString(1, last_name);
            setInteger(2, first_name, prSt);
            setInteger(3, patronymic, prSt);
            setDate(4, date_of_birth, prSt);
            setInteger(5, gender, prSt);
            setInteger(6, country, prSt);
            setInteger(7, region, prSt);
            prSt.setString(8, outdoors);
            setDate(9, date_of_commission, prSt);
            prSt.setString(10, place_of_commission);
            setDate(11, date_of_initiation, prSt);
            setInteger(12, office_of_initiation, prSt);
            prSt.setString(13, name_of_initiation);
            setDate(14, date_of_preparing_report, prSt);
            setInteger(15, office_of_preparing_report, prSt);
            prSt.setString(16, name_of_preparing_report);
            setInteger(17, id_article, prSt);
            setDate(18, date_of_decision, prSt);
            prSt.setString(19, decision);
            setInteger(20, office_of_decision, prSt);
            prSt.setString(21, name_of_decision);
            setInteger(22, punishment, prSt);
            setInteger(23, sum, prSt);
            setDate(24, date_of_entry_into_force, prSt);
            setDate(25,date_sentence_enforcement, prSt);
            setInteger(26, amount, prSt);
            prSt.setInt(27, id);
            prSt.executeUpdate();
        } catch (SQLException e) {
            AlertSending.alertError();
            e.printStackTrace();
        }
    }

    public void editReferral(Integer card, String dateDeparture, Integer officeDeparture,
                            String dateArrival, Integer officeArrival){
        String update = "UPDATE " + Const.REFERRAL_TABLE + " SET " +
                Const.REFERRAL_DATE_DEPARTURE + " = ?, " + Const.REFERRAL_OFFICE_DEPARTURE + " = ?, " +
                Const.REFERRAL_DATE_ARRIVAL + " = ?, " + Const.REFERRAL_OFFICE_ARRIVAL + " = ? " + " WHERE " + Const.REFERRAL_CARD +" = ?";

        try (PreparedStatement prSt = DatabaseConnection.getInstance().getConnection().prepareStatement(update)) {
            setDate(1, dateDeparture, prSt);
            setInteger(2, officeDeparture, prSt);
            setDate(3, dateArrival, prSt);
            setInteger(4, officeArrival, prSt);
            prSt.setInt(5, card);
            prSt.executeUpdate();
        } catch (SQLException e) {
            AlertSending.alertError();
            e.printStackTrace();
        }
    }



}
