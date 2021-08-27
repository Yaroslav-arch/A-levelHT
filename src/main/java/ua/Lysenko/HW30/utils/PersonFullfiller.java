package ua.Lysenko.HW30.utils;

import ua.Lysenko.HW30.entity.Laureate;
import ua.Lysenko.HW30.entity.LaureatesList;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PersonFullfiller {
    public List<BigInteger> getAgeList(LaureatesList laureatesList) {
        List<BigInteger> ageList = new ArrayList<>();

        DateTimeFormatter awardedDateFormatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy")
                .parseDefaulting(ChronoField.MONTH_OF_YEAR, 12)
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 10)
                .toFormatter();

        DateTimeFormatter bornDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Laureate l : laureatesList.getLaureates()) {
            if (l.getBorn() != null && !l.getBorn().contains("-00") && l.getBorn().contains("-")) {
                l.getPrizes().get(0).setWasAwarded(LocalDate.parse(l.getPrizes().get(0).getYear(), awardedDateFormatter));
                l.setWasBorn((LocalDate.parse(l.getBorn(), bornDateFormatter)));
                l.setAge((int) ChronoUnit.YEARS.between(l.getWasBorn(), l.getPrizes().get(0).getWasAwarded()));
                ageList.add(BigInteger.valueOf(l.getAge()));
            }

        }
        return ageList;
    }
}
