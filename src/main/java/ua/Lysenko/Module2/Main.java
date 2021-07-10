package ua.Lysenko.Module2;

import ua.Lysenko.Module2.date.Date;
import ua.Lysenko.Module2.utils.DateFormatter;
import ua.Lysenko.Module2.controller.DateController;

public class Main {
    public static void main(String[] args) {
        DateController dateController = new DateController();
        dateController.run();
    }
}
