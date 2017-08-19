package com.olesm.trading.fxtrading.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

public class DateHelper {

    private static final List<String> holidays = Arrays.asList("01/01", "06/01", "01/04", "03/04", "15/08", "01/11", "11/11", "25/12", "26/12");

    private DateHelper(){

    }

    public static boolean isWeekend(Date date){
        return EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)
                .contains(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
    }

    public static boolean isHoliday(Date date){
        DateFormat df = new SimpleDateFormat("dd/MM");
        return holidays.contains(df.format(date));
    }

}