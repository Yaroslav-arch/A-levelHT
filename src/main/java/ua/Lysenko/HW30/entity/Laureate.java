package ua.Lysenko.HW30.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Laureate {
    private String firstname;
    private String surname;
    private int age;
    private LocalDate wasBorn;
    private String born;
    private List<Prize> prizes;

    @Data
    public static class Prize {

        private String year;
        private LocalDate wasAwarded;
    }

}


