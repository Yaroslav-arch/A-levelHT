package ua.Lysenko.CW5.AnimalsTask;

public class TaskAnimals {
    public static void main(String[] args) {
        Animal[] animal = new Animal[3];
        animal[0] = new Cat("Fish", "home");
        animal[1] = new Dog("Meat and bones", "booth");
        animal[2] = new Horse("oat", "stables");
        Vet vet = new Vet();
        for (int i = 0; i < animal.length; i++) {
            vet.treatAnimal(animal[i]);
        }

    }
}
