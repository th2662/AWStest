package com.ifutsalu.util;

import java.time.format.DateTimeFormatter;

public class DateTimeFormatterUtil {
    public static DateTimeFormatter localDatePattern() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    }

    public static DateTimeFormatter localDateTimePattern() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    }
}
