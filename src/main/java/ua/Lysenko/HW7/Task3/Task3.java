package main.java.ua.Lysenko.HW7.Task3;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        Vector firstOne = new Vector(1.0, 2.0, 3.0);
        Vector secondOne = new Vector(3.0, 4.0, 5.0);
        int n = 5;
        Vector[] arrayOfVectors = Vector.getVectorsArray(n);
        System.out.println(Arrays.toString(arrayOfVectors));


        System.out.println("Длина вектора: " + firstOne.getLength());

        Vector resultOfMultiplication = firstOne.multiplicationOfVectors(secondOne);
        System.out.println("Результат умножения: " + resultOfMultiplication.toString());

        System.out.println("Косинус векторов: " + firstOne.getVectorCosine(secondOne));

        Vector resultOfSum = firstOne.sumOfVectors(secondOne);
        System.out.println("Результат сложения: " + resultOfSum.toString());

        Vector resultOfSubstr = Vector.substrOfVectors(firstOne, secondOne);
        System.out.println("Результат вычитания: " + resultOfSubstr);

        System.out.println(firstOne); //итоговая проверка, что оригиналы не поменялись
        System.out.println(secondOne);
    }




}
