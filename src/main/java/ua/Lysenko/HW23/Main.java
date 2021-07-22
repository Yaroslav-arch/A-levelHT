package ua.Lysenko.HW23;

import ua.Lysenko.HW23.dao.AutoDao;
import ua.Lysenko.HW23.entity.Auto;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Date date1 = new Date(16, 12, 20);
        Date date2 = new Date(20, 07, 10);
        Date date3 = new Date(19, 06, 11);
        Date date4 = new Date(21, 10, 22);

        AutoDao AutoDao = new AutoDao();
        Auto Auto = new Auto("Volvo", 20000.99, date1, date2, "Auto", 60);
        AutoDao.createAuto(Auto);

        AutoDao.insertAuto();

        // update Auto
        Auto Auto1 = new Auto("Audi", 35555.0, date3, date4, "Hand", 45);
        AutoDao.updateAuto(Auto1);

        // get Autos
        List<Auto> Autos = AutoDao.getAutos();
        Autos.forEach(s -> System.out.println(s.getTitle()));

        // get single Auto
        Auto Auto2 = AutoDao.getAutoById(1);
        System.out.println(Auto2.getTitle());

        // delete Auto
        AutoDao.deleteAuto(1);

    }
}

