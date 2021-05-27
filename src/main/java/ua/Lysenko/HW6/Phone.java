package main.java.ua.Lysenko.HW6;

class Phone {
    String number;
    String model;
    int weight;

    Phone(String number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    Phone() {
    }

    void receiveCall(String name) {
        System.out.println("Звонит: " + name);
    }

    String getNumber() {
        return number;
    }

}
