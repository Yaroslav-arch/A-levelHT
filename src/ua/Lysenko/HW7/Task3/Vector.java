package ua.Lysenko.HW7.Task3;

import java.util.Random;

public class Vector {
    double x;
    double y;
    double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector() {
    }

    double getLength() {
        return Math.abs(Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z));
    }

    Vector multiplicationOfVectors(Vector local) {
        Vector result = new Vector();
        if (this.checkCollinear(local)) {
            result.x = result.y = result.z = 0;
        } else {

            result.x = (this.y * local.z - this.z * local.y);
            result.y = (this.z * local.x - this.x * local.z);
            result.z = (this.x * local.y - this.y * local.x);

        }
        return result;
    }

    boolean checkCollinear(Vector local) {
        return this.x / local.x == this.y / local.y && this.x / local.x == this.z / local.z;
    }

    double getVectorCosine(Vector local) {
        return dotProductOfVectors(local) / (this.getLength() * local.getLength());
    }

    double dotProductOfVectors(Vector first) { //скалярное умножение векторов
        return first.x * this.x + first.y * this.y + first.z * this.z;
    }

    Vector sumOfVectors(Vector local) {
        Vector result = new Vector();
        if (this.x == local.x && this.y == local.y && this.z == local.z) {
            result.x = 0;
            result.y = 0;
            result.z = 0;
        } else {

            result.x = this.x + local.x;
            result.y = this.y + local.y;
            result.z = this.z + local.z;
        }
        return result;
    }

    static Vector substrOfVectors(Vector first, Vector second) { //сделал static для разнообразия
        Vector result = new Vector();
        if (first.x == second.x && first.y == second.y && first.z == second.z) {
            result.x = 0;
            result.y = 0;
            result.z = 0;
        } else {

            result.x = first.x - second.x;
            result.y = first.y - second.y;
            result.z = first.z - second.z;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    static void setCoordinates(Vector local) {
        Random random = new Random();
        local.x = random.nextDouble();
        local.y = random.nextDouble();
        local.z = random.nextDouble();
    }

    static Vector[] getVectorsArray(int n) {
        Vector[] arrayOfVectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            arrayOfVectors[i] = new Vector();
            Vector.setCoordinates(arrayOfVectors[i]);
        }
        return arrayOfVectors;
    }

}
