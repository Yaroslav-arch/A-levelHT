package ua.Lysenko.HW7.Task2;

public class Task2Main {
    public static void main(String[] args) {

        Student[] students = new Student[2];
        students[0] = new Student("Alex", "Blare", 112, 4.7);
        students[1] = new Aspirant("Ben", "Franklin", 225, 5.0, "Scientific staff");

//        Student x = new Student();
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getScholarship(students[i].averageMark));
        }
    }
}
