package ua.Lysenko.Module2.controller;

import ua.Lysenko.Module2.date.Date;
import ua.Lysenko.Module2.service.impl.DateActionsImpl;
import ua.Lysenko.Module2.utils.DateFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class DateController {
    Scanner scanner = new Scanner(System.in);
    DateFormatter dateFormatter = new DateFormatter();
    DateActionsImpl dateActionsImpl = new DateActionsImpl();
    String pattern;
    String date;
    Date originalDate;

    public void run() {
        originalDate = createDate();
        runNavigation();
        parseDate(scanner.next());
//        enterPattern();
//        enterDate();

//        Date originalDate = dateFormatter.parse(date);
//        operateDate();


    }

    public Date createDate() {
        Date date1 = new Date();
        System.out.println("Please enter year(yy/yyyy)");
        date1.setYear(scanner.nextLong());
        System.out.println("Please enter month(m/mm/mmm)");
        String month = scanner.next();
        if (month.matches("\\d+")) {
            date1.setMonth(Long.parseLong(month));
        } else {
            date1.setMonth(dateFormatter.getMonthNumber(month));
        }
        System.out.println("Please enter day(d/dd)");
        date1.setDay(scanner.nextLong());
        System.out.println("Please enter hour");
        date1.setHour(scanner.nextLong());
        System.out.println("Please enter minute");
        date1.setMinute(scanner.nextLong());
        System.out.println("Please enter second");
        date1.setSecond(scanner.nextLong());
        date1.setSecondsAbs();
//        System.out.println("Please enter delimiter for output('-' or '/')");
//        date1.setDelimiter(scanner.next());

        return date1;
    }

    private void enterPattern() {
        System.out.println("Please enter the pattern of Date using d, dd, m, mm, mmm, yy, yyyy and / or - as splitter");
        pattern = scanner.next();
    }

    private void enterDate() {
        System.out.println("Please enter the Date");
        date = scanner.next();
    }

    private void parseDate(String position) {

        switch (position) {
            case "1":
                printDate(dateActionsImpl.dateDifference(originalDate, createDate()));
                break;
            case "2":
               printDate( dateActionsImpl.dateAdd(originalDate, createDate()));
                break;
            case "3":
                printDate(dateActionsImpl.dateSubtract(originalDate, createDate()));
                break;
            case "4":
                List<Date> dates = new ArrayList<>();
                dates.add(originalDate);
                System.out.println("If you want to add date, please enter 1.");
                System.out.println("If you want to begin arrangement, please enter 2.");
                if (scanner.nextInt() == 1) {
                    createDate();
                } else {
                    dateActionsImpl.dateSort(dates);
                }
                break;
        }

        runNavigation();

    }

    private void runNavigation() {
        System.out.println();
        System.out.println("If you want to find difference between two dates, please enter '1");
        System.out.println("If you want to add time, please enter 2");
        System.out.println("if you want to subtract time, please enter 3");
        System.out.println("if you want to arrange dates, please enter 4");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void printDate(Date date) {
        enterPattern();
        String[] delimiters = pattern.split("\\w+");
        String[] splitPattern = pattern.split("/|\\s|:|-");
        String[] splitDate = new String[7];

        for (int i = 0; i < splitPattern.length; i++) {
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
                splitDate[i] = dateFormatter.monthMap.get(date.getMonth());
            }
            if (splitPattern[i].equals("yy")) {
                splitDate[i] = String.valueOf(date.getYear());
            }
            if (splitPattern[i].equals("yyyy")) {
                splitDate[i] = String.valueOf(date.getYear());
            }

            splitDate[3] = String.valueOf(date.getHour());
            splitDate[4] = String.valueOf(date.getMinute());
            splitDate[5] = String.valueOf(date.getSecond());
            splitDate[6] = delimiters[1];

        }
        String dateStr = String.join(splitDate[6], Arrays.copyOfRange(splitDate, 0, 3));
        String timeStr = String.join(":", Arrays.copyOfRange(splitDate, 3, 6));
        System.out.println(dateStr + " " + timeStr);
    }

}
