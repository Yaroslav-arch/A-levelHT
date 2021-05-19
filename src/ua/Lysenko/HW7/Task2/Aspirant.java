package ua.Lysenko.HW7.Task2;

public class Aspirant extends Student{
    public Aspirant(String firstName, String lastName, int group, double averageMark, String workName) {
        super(firstName, lastName, group, averageMark);
        this.workName = workName;
    }


    private String workName = "Some scientific stuff";
    @Override
    int getScholarship(double averageMark) {
        return averageMark == 5.0 ? 200:180;
    }
}
