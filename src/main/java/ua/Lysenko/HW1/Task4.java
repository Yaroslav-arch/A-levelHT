package main.java.ua.Lysenko.HW1;

public class Task4 {
    public static void main(String[] args) {
        int original = Integer.parseInt(args[0]);
        int reversed = 0;

        for(;original != 0; original /= 10) {
            int digit = original % 10;
            reversed = reversed * 10 + digit;
        }

        System.out.println("Reversed Number: " + reversed);
    }
}

