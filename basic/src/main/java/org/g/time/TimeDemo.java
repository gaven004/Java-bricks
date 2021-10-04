package org.g.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class TimeDemo {
    public static void now() {
        /**
         * The Java time-scale is used for all date-time classes.
         * This includes Instant, LocalDate, LocalTime,
         * OffsetDateTime, ZonedDateTime and Duration.
         */

        /**
         * 旧的java.util.Date不支持纳秒，而新的时间类，则全部支持到纳秒
         *
         * 如Instant的内容结构分为两部分：
         *
         * // The number of seconds from the epoch of 1970-01-01T00:00:00Z.
         * private final long seconds;
         *
         * // The number of nanoseconds, later along the time-line, from the seconds field.
         * private final int nanos;
         */

        // 2021-10-03T13:54:29.618786Z
        // UTC
        System.out.println(Instant.now());

        // 2021-10-03T21:54:29.679768+08:00
        System.out.println(OffsetDateTime.now());

        // 2021-10-03T21:54:29.681184+08:00[Asia/Shanghai]
        System.out.println(ZonedDateTime.now());

        // 2021-10-03
        System.out.println(LocalDate.now());

        // 21:54:29.681536
        System.out.println(LocalTime.now());

        // 2021-10-03T21:54:29.681669
        System.out.println(LocalDateTime.now());
    }

    public static void parse() {
        String s = "2021-10-03T13:54:29.618786Z";
        Instant instant = Instant.parse(s);
        System.out.println("Expectd: " + s + "  Actual: " + instant);

        s = "2021-10-03T21:54:29.681669";
        LocalDateTime localDateTime = LocalDateTime.parse(s);
        System.out.println("Expectd: " + s + "  Actual: " + localDateTime);

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(' ')
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter();

        s = "2021-10-03 21:54:29.618786";
        localDateTime = LocalDateTime.parse(s, formatter);
        System.out.println("Expectd: " + s + "  Actual: " + localDateTime);

        // Do not use SimpleDateFormat to handle nanoseconds !!!
    }

    public static void format() {
        // This class is immutable and thread-safe.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        System.out.println(formatter.format(now));
    }

    public static void plus() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // 变量now在plus运算时是不变的
        now.plusDays(1);
        System.out.println(now);

        // plus运算，如果结果是同一时间点，则返回now，否则返回一个新的LocalDateTime
        now = now.plusDays(1);
        System.out.println(now);
    }
}
