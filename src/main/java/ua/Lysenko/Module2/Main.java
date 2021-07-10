package ua.Lysenko.Module2;

import ua.Lysenko.Module2.date.Date;
import ua.Lysenko.Module2.utils.DateFormatter;
import ua.Lysenko.Module2.controller.DateController;

public class Main {
    public static void main(String[] args) {
//        DateFormatter dateFormatter = new DateFormatter("mm/dd/yy");
//        Date date = dateFormatter.parse("01/02/03");
//        dateFormatter.format(date);
//        String format = String.format("%02d", 5);
//        System.out.println(format);
        DateController dateController = new DateController();
        dateController.run();
    }
}
