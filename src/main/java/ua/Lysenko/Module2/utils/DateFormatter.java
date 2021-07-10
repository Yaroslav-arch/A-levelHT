package ua.Lysenko.Module2.utils;

import ua.Lysenko.Module2.date.Date;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DateFormatter {
    private String pattern;
    private int fields = 7;
    public Map<Long, String> monthMap = new HashMap<>();

    {
        monthMap.put(1L, "january");
        monthMap.put(2L, "february");
        monthMap.put(3L, "march");
        monthMap.put(4L, "april");
        monthMap.put(5L, "may");
        monthMap.put(6L, "june");
        monthMap.put(7L, "july");
        monthMap.put(8L, "august");
        monthMap.put(9L, "september");
        monthMap.put(10L, "october");
        monthMap.put(11L, "november");
        monthMap.put(12L, "december");
    }

    public DateFormatter(String pattern) {
        this.pattern = pattern;
    }

    public DateFormatter() {

    }

    public String format(Date date) {
        String[] splitPattern = pattern.split("/|\s|:|-");
        String[] delimiters = pattern.split("\\w+");
        String[] splitDate = new String[fields];

        for (int i = 0; i < fields; i++) {
            if (splitPattern[i].equals("d")) {
                splitDate[i] = String.valueOf(date.getDay());
            }
            if (splitPattern[i].equals("dd")) {
                splitDate[i] = String.valueOf(date.getDay());
            }
            if (splitPattern[i].equals("m")) {
                splitDate[i] = String.valueOf(date.getMonth());
            }
            if (splitPattern[i].equals("mm")) {
                splitDate[i] = String.valueOf(date.getMonth());
            }
            if (splitPattern[i].equals("mmm")) {
                splitDate[i] = monthMap.get(date.getMonth());
            }
            if (splitPattern[i].equals("yy")) {
                splitDate[i] = String.valueOf(date.getYear());
            }
            if (splitPattern[i].equals("yyyy")) {
                splitDate[i] = String.valueOf(date.getYear());
            }
            if (delimiters[i].equals(":")) {
                splitDate[i] = String.valueOf(date.getHour());
                splitDate[i + 1] = String.valueOf(date.getMinute());
                splitDate[i + 2] = String.valueOf(date.getSecond());
            }
        }

        return Arrays.toString(splitDate);
    }

    public Date parse(String date) {
        Date newDate = new Date();
        String[] splitDate = date.split("/|\\s|:|-");
        String[] delimiters = pattern.split("\\w+");
        String[] splitPattern = pattern.split("/|\\s|:|-");
//        for (int i = 0; i < fields; i++) {
//            if (splitDate[i] == null) {
//                splitDate[i] = "00";
//            }
//        }
        for (int i = 0; i < fields; i++) {
            if (splitPattern[i].equals("d")) {
                newDate.setDay(Long.parseLong(splitDate[i]));
            }
            if (splitPattern[i].equals("dd")) {
                newDate.setDay(Long.parseLong(splitDate[i]));
            }
            if (splitPattern[i].equals("m")) {
                newDate.setMonth(Long.parseLong(splitDate[i]));
            }
            if (splitPattern[i].equals("mm")) {
                newDate.setMonth(Long.parseLong(splitDate[i]));
            }
            if (splitPattern[i].equals("mmm")) {
                newDate.setDay(getMonthNumber(splitDate[i]));
            }
            if (splitPattern[i].equals("yy")) {
                newDate.setYear(Long.parseLong(splitDate[i]));
            }
            if (splitPattern[i].equals("yyyy")) {
                newDate.setYear(Long.parseLong(splitDate[i]));
            }
            if (delimiters[i].equals(":") && delimiters[i + 1].equals(":")) {
                newDate.setHour(Long.parseLong(splitDate[i]));
                newDate.setMinute(Long.parseLong(splitDate[i + 1]));
                newDate.setSecond(Long.parseLong(splitDate[i + 2]));
            }
            if (delimiters[i].equals(":") && !delimiters[i + 1].equals(":")) {
                newDate.setMinute(Long.parseLong(splitDate[i]));
                newDate.setSecond(Long.parseLong(splitDate[i + 1]));
            }
            newDate.setDelimiter(delimiters[0]);
        }
        return newDate;
    }

    public long getMonthNumber(String month) {
        long number = -1;
        for (Map.Entry<Long, String> entry : monthMap.entrySet()) {
            if (entry.getValue().equals("c")) {
                number = entry.getKey();
            }
        }
        return number;
    }
}
