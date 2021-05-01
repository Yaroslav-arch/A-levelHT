package HT2;

public class Task2 {
    public static void main(String[] args) {
        double result = findSquare(0,3,4,0,3,5);
        if (result<=0){
            System.out.println("Triange doesn't exist");
        } else {
            System.out.println("The square of triange is " + result);
        }

    }
    static double findSquare  (int x1, int x2, int x3, int y1, int y2, int y3) {
        double a = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1) * (y2-y1));
        double b = Math.sqrt((x3-x2)*(x3-x2) + (y3-y2) * (y3-y2));
        double c = Math.sqrt((x1-x3)*(x1-x3) + (y1-y3) * (y1-y3));

        if(a + b <= c || a + c <= b || b + c <= a) {
            return -1;

        } else {
            double p = (a + b + c) / 2.0;
            double square = (p*(p-a)*(p-b)*(p-c));
            return square;
        }
    }

}
