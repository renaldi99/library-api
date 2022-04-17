package com.enigma.libraryapi.utils;

import org.joda.time.DateTime;

public class AddDayJodaTime {
    public static String addSevenDayJodaTime(String date) {
        DateTime dateTime = new DateTime(date);
        return dateTime
                .plusDays(7)
                .toString("yyyy-MM-dd");
    }
}
