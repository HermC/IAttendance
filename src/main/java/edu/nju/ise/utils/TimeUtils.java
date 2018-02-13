package edu.nju.ise.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间工具类，用于处理不同格式的Date，LocalDateTime与String之间的相互转换
 *
 * @author Hermit
 * @version 1.0 2018/02/13
 *
 * @see LocalDateTime
 * @see Date
 * */
public class TimeUtils {

    private static final DateTimeFormatter
            LOCAL_DATE_TIME_COMMON_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
    private static final SimpleDateFormat
            DATE_TIME_COMMON_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime commonStr2LocalDateTime(final String str) {
        return LocalDateTime.parse(str, LOCAL_DATE_TIME_COMMON_FORMATTER);
    }

    public static String commonLocalDateTime2Str(final LocalDateTime dateTime) {
        return LOCAL_DATE_TIME_COMMON_FORMATTER.format(dateTime);
    }

    public static Date commonStr2Date(final String str) {
        try {
            return DATE_TIME_COMMON_FORMATTER.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static String commonDate2Str(final Date date) {
        return DATE_TIME_COMMON_FORMATTER.format(date);
    }
}
