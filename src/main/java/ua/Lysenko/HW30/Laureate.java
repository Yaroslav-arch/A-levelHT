package ua.Lysenko.HW30;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class Laureate {
    private String firstname;
    private String surname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date born;
    private List<Prize> prizes;

    @Data
    private static class Prize {
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
        private Date year;
    }

}


