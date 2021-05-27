package main.java.ua.Lysenko.HW6;

public class Task1 {

    public static void main(String[] args) {

        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();


        phone1.number = "06712345678";
        phone1.model = "Iphone";
        phone1.weight = 120;


        phone2.number = "05087654321";
        phone2.model = "Samsung";
        phone2.weight = 105;

        phone3.number = "0630001111";
        phone3.model = "Xiaomi";
        phone3.weight = 150;

        System.out.println("Number: " + phone1.getNumber());

        Phone x = new Phone();
        x.receiveCall("Alex");
        // или
        phone1.receiveCall("John");

    }
}

