package ua.Lysenko.Module2.date;

import lombok.Getter;
import lombok.Setter;
import ua.Lysenko.Module2.TimeInSeconds;

import java.util.Comparator;

@Getter
@Setter
public class Date {
    private long secondsAbs;
    private long daysAbs;
    private long dayOfYear;
    private long year;
    private long month;
    private long day;
    private long hour;
    private long minute;
    private long second;
    private String delimiter;

    public Date() {
        this.year = 0;
        this.month = 1;
        this.day = 1;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

//    public Date(long year, long month, long day, long hour, long minute, long seconds) {
//        this.year = year;
//        this.month = month;
//        this.day = day;
//        this.hour = hour;
//        this.minute = minute;
//        this.second = seconds;
//        setSecondsAbs();
//        setDateFromSecondsAbs();
//    }

    public void setSecondsAbs() {
        if (isLeap(year) && month > 2) {
            secondsAbs = second + minute * 60 + hour * 360 + day * 8640 + (daysFromBeginningOfTheYear(month, day) + 1) * 8640
                    + year * 3_153_600 + amendmentOnLeap(year) * 8640;

        } else {
            secondsAbs = second + minute * 60 + hour * 360 + daysFromBeginningOfTheYear(month, day) * 8640
                    + year * 3_153_600 + amendmentOnLeap(year) * 8640;
        }
    }

    public void setDateFromSecondsAbs() {
        long someQuantity = secondsAbs;
        this.year = someQuantity / TimeInSeconds.YEAR_IN_SECONDS;
        this.daysAbs = this.secondsAbs % TimeInSeconds.DAY_IN_SECONDS;
        someQuantity = this.secondsAbs - this.daysAbs * TimeInSeconds.DAY_IN_SECONDS;

        int countOfLeap = 0;
        for (int i = 0; i <= year; i++) {
            if (isLeap(i)) {
                countOfLeap++;
            }
        }
        this.dayOfYear = this.daysAbs % 365 + countOfLeap;
        if (this.dayOfYear > 365) {
            this.year = this.year + this.dayOfYear / 365;
            this.dayOfYear = isLeap(this.year)
                    ? this.dayOfYear % 366
                    : this.dayOfYear % 365;

            monthAndDayFromDaysAbs(this.dayOfYear);
        }
        this.hour = someQuantity / TimeInSeconds.HOUR_IN_SECONDS;
        someQuantity = someQuantity / TimeInSeconds.HOUR_IN_SECONDS;
        this.minute = someQuantity / TimeInSeconds.MINUTE_IN_SECONDS;
        this.second = someQuantity % TimeInSeconds.MINUTE_IN_SECONDS;

    }

    private long daysFromBeginningOfTheYear(long month, long day) {
        switch ((int) month) {
            case 1:
                return day;
            case 2:
                return 31 + day;
            case 3:
                return 59 + day;
            case 4:
                return 90 + day;
            case 5:
                return 120 + day;
            case 6:
                return 151 + day;
            case 7:
                return 181 + day;
            case 8:
                return 212 + day;
            case 9:
                return 243 + day;
            case 10:
                return 273 + day;
            case 11:
                return 304 + day;
            case 12:
                return 334 + day;
            default:
                throw new IllegalArgumentException("The month should be from 1 to 12");
        }

    }

    private long amendmentOnLeap(long year) {
        long counter = 0;
        while (year != 0) {
            if (isLeap(year)) {
                counter++;
            }
            year--;
        }
        return counter;
    }

    private boolean isLeap(long year) {
        if (getYear() % 4 != 0 || year % 100 == 0 && year % 400 != 0) {
            return false;
        } else return true;
    }

    private void monthAndDayFromDaysAbs(long dayOfYear) {

        if (dayOfYear < 31) {
            this.month = 1;
            this.day = dayOfYear;
        } else if (dayOfYear <= 59) {
            this.month = 2;
            this.day = dayOfYear - 31;
        } else if (dayOfYear <= 90) {
            this.month = 3;
            this.day = dayOfYear - 59;
        } else if (dayOfYear <= 120) {
            this.month = 4;
            this.day = dayOfYear - 90;
        } else if (dayOfYear <= 151) {
            this.month = 5;
            this.day = dayOfYear - 120;
        } else if (dayOfYear <= 181) {
            this.month = 6;
            this.day = dayOfYear - 151;
        } else if (dayOfYear <= 212) {
            this.month = 7;
            this.day = dayOfYear - 181;
        } else if (dayOfYear <= 243) {
            this.month = 8;
            this.day = dayOfYear - 212;
        } else if (dayOfYear <= 273) {
            this.month = 9;
            this.day = dayOfYear - 243;
        } else if (dayOfYear <= 304) {
            this.month = 10;
            this.day = dayOfYear - 273;
        } else if (dayOfYear <= 334) {
            this.month = 11;
            this.day = dayOfYear - 304;
        } else if (dayOfYear <= 365) {
            this.month = 12;
            this.day = dayOfYear - 334;
        } else if (dayOfYear == 366) {
            month = 12;
            day = 31;
        }
    }

}
