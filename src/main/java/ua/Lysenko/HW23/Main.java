package ua.Lysenko.HW23;

import ua.Lysenko.HW23.dao.AutoDao;
import ua.Lysenko.HW23.entity.Auto;
import ua.Lysenko.HW23.entity.GearType;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AutoDao AutoDao = new AutoDao();
        Auto Auto = new Auto("Volvo", 20000.99, "20-10-2016", "10-10-2019", GearType.AUTO, 60);
        AutoDao.createAuto(Auto);

        AutoDao.insertAuto();

        Auto Auto1 = new Auto("Audi", 35555.0, "15-12-2019", "01-01-2021", GearType.HAND, 45);
        AutoDao.createAuto(Auto1);
        AutoDao.updateAuto(Auto1);

        List<Auto> Autos = AutoDao.getAutos();
        Autos.forEach(s -> System.out.println(s.getTitle()));

        Auto Auto2 = AutoDao.getAutoById(1);
        System.out.println(Auto2.getTitle());

        AutoDao.deleteAuto(1);

    }
}

