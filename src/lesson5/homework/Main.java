package lesson5.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int number = 2;
        int degree = 4;
        System.out.println(exponentiation(number, degree));
    }

// возведение в степень

    public static int exponentiation (int number, int degree) {
        if (degree < 0) {
            throw new IllegalArgumentException("method return integer, it is not possible with degree < 0");
        }
        if (degree == 0) {
            return 1;
        }
        if(degree == 1) {
            return number;
        }
        return number * exponentiation(number, degree - 1);
    }

}
