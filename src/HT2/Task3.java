package HT2;

public class Task3 {

    public static void main(String[] args) {

        System.out.println("Entered number " + isEven(-4));
    }

    static String isEven(int x) {
       if (x == 0) {
           return "is zero";
       } else {
           String result = x % 2 == 0 ? "is even" : "is not even";
           return result;
       }

    }
}
