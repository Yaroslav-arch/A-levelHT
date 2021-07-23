package ua.Lysenko.HW23;

import ua.Lysenko.HW23.dao.AutoDao;
import ua.Lysenko.HW23.entity.Auto;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AutoDao AutoDao = new AutoDao();
        Auto Auto = new Auto("Volvo", 20000.99, "20-10-2016", "10-10-2019", "Auto", 60);
        AutoDao.createAuto(Auto);

        AutoDao.insertAuto();

        // update Auto
        Auto Auto1 = new Auto("Audi", 35555.0, "15-12-2019", "01-01-2021", "Hand", 45);
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

