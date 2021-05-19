package ua.Lysenko.HW7.Task2;

public class Student {
    String firstName;
    String lastName;
    int group;
    double averageMark;

    Student(String firstName, String lastName, int group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public Student() {
    }

    int getScholarship(double averageMark) {
        return averageMark == 5.0 ? 100 : 80;
    }
}
