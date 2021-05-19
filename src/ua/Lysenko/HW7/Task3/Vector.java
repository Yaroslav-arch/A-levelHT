package ua.Lysenko.HW7.Task3;

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

    double getLength(Vector local) {
        return Math.abs(Math.sqrt(local.x * local.x + local.y * local.y + local.z * local.z));
    }

    Vector multiplicationOfVectors(Vector first, Vector second) {
        Vector result = new Vector();
        if (checkCollinear(first, second)) {
            result.x = result.y = result.z = 0;
        } else {

            result.x = (first.y * second.z - first.z * second.y);
            result.y = (first.z * second.x - first.x * second.z);
            result.z = (first.x * second.y - first.y * second.x);

        }
        return result;
    }

    boolean checkCollinear(Vector first, Vector second) {
        return first.x / second.x == first.y / second.y && first.x / second.x == first.z / second.z;
    }

    double getVectorCosine(Vector first, Vector second) {
        return dotProductOfVectors(first, second) / (getLength(first) * getLength(second));
    }

    double dotProductOfVectors(Vector first, Vector second) { //скалярное умножение векторов
        return first.x * second.x + first.y * second.y + first.z * second.z;
    }

    Vector sumOfVectors(Vector first, Vector second) {
        Vector result = new Vector();
        if (first.x == second.x && first.y == second.y && first.z == second.z) {
            result.x = 0;
            result.y = 0;
            result.z = 0;
        } else {

            result.x = first.x + second.x;
            result.y = first.y + second.y;
            result.z = first.z + second.z;
        }
        return result;
    }

    Vector substrOfVectors(Vector first, Vector second) {
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

}
