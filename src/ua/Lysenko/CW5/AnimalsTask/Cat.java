package ua.Lysenko.CW5.AnimalsTask;

public class Cat extends Animal{
    Cat(String food, String location){
        this.food = food;
        this.location = location;
    }
    private String can = "Умеет мурлыкать";
    @Override
    protected void makeNoise() {
        super.makeNoise();
        System.out.println("МЯУ");
    }
    @Override
    protected void eat() {
        super.eat();
        System.out.println("Рыбу");
    }

}
