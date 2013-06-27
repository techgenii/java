package com.practicejava.myregex;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class SimpleDateFormatReadOnly extends SimpleDateFormat {
    private static final long serialVersionUID = 4432029822268771619L;

    public SimpleDateFormatReadOnly(String datePattern) {
        super(datePattern);
        super.setLenient(false);
        // Old way: Caused Daylight saving time problems in the console calendar.
        // TODO - Change to Europe/London after meeting 14/06/2007?
        super.setTimeZone(TimeZone.getTimeZone("GMT"));
		// FIX ME - get from Server? No - set to GMT UFN
        //super.setTimeZone(TimeZone.getTimeZone("Europe/London"));
    }
}