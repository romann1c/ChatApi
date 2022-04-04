package com.romann1c.chatapi.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateTimeFormatterUtil {
    public static String localDateTimeToJsonFormat(LocalDateTime localDateTime){
        return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static LocalDateTime getLocalDateTimeFromJsonFormat(String localDateTime){
        return LocalDateTime.parse(localDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
