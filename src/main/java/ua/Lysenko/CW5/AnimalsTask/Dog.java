package main.java.ua.Lysenko.CW5.AnimalsTask;

public class Dog extends Animal {
    Dog(String food, String location) {
        this.food = food;
        this.location = location;
    }

    private String quality = "Преданность";

    @Override
    protected void makeNoise() {
        System.out.println("ГАВ");
    }

    @Override
    protected void eat() {
        System.out.println("Кость");
    }
}
