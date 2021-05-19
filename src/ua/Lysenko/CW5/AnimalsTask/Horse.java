package ua.Lysenko.CW5.AnimalsTask;

public class Horse extends Animal{
    Horse(String food, String location){
        this.food = food;
        this.location = location;
    }
    private int hoofs = 4;
    @Override
    protected void makeNoise() {
        super.makeNoise();
        System.out.println("ИГО-ГО");
    }
    @Override
    protected void eat() {
        super.eat();
        System.out.println("Овёс");
    }
}
