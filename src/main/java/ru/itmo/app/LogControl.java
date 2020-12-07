package ru.itmo.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LogControl {
    public static String checkLessDateNow(String name, String date) throws ParseException {
        if (!date.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date newDate = sdf.parse(date);
            Date now = new Date();
            if (newDate.before(sdf.parse(sdf.format(now)))) {
                return date;
            } else
                AlertSending.alertError(name);
        }
        return "";
    }

    public static String checkAfterDate(String name, String dateAfter, String dateBefore) throws ParseException {
        checkLessDateNow(name, dateAfter);
        if (!dateAfter.equals("")&&!dateBefore.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date newDateBefore = sdf.parse(dateBefore);
            Date newDateAfter = sdf.parse(dateAfter);
            if (newDateAfter.compareTo(newDateBefore)>=0) {
                return dateAfter;
            } else
                AlertSending.alertError(name);
        }
        return "";
    }

    public static String checkLessDatTimeNow(String name, String dateTimeBefore) throws ParseException {
        String date = dateTimeBefore.substring(0, 10);
        String check = checkLessDateNow(name, date);
        if(!check.equals(""))
            return dateTimeBefore;
        else
            AlertSending.alertError(name);
        return "";
    }
}
