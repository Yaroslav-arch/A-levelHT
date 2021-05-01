package HT2;

public class Task3 {

    public static void main(String[] args) {

        System.out.println("Entered number " + isEven(0));
    }

    static String isEven(int x) {
       if (x == 0) {
           return "is zero";
       } else {
           return x % 2 == 0 ? "is even" : "is not even";

       }

    }
}
