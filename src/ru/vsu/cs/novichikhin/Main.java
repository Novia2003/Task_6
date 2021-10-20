package ru.vsu.cs.novichikhin;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readNumber("x: ");
        checkNumberX(x);

        int n = readNumberOfTerms();
        checkNumberOfTerms(n);

        double e = readNumber("e: ");

        double firstSum = findFirstOrSecondOrThirdSum(n, x, 0);
        double secondSum = findFirstOrSecondOrThirdSum(n, x, e);
        double thirdSum = findFirstOrSecondOrThirdSum(n, x, e / 10);
        double functionValue = findFunctionValue(x);

        printResults(n, x, e, firstSum, secondSum, thirdSum, functionValue);
    }

    static double readNumber(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение " + name);
        return scanner.nextDouble();
    }

    static void checkNumberX(double x) {
        if (x < 0) {
            System.out.print("Данные введены неверно (число x должно быть больше 0)");
            System.exit(1);
        }
    }

    static int readNumberOfTerms() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество слагаемых n: ");
        return scanner.nextInt();
    }

    static void checkNumberOfTerms(int n) {
        if (n < 0) {
            System.out.print("Данные введены неверно (количество слагаемых n должно быть больше 0)");
            System.exit(1);
        }
    }

    static double findFirstOrSecondOrThirdSum(int n, double x, double e) {
        double sum = 1;
        int factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
            if (Math.abs(Math.pow(x, i) / factorial) > Math.abs(e)) {
                sum += Math.pow(x, i) / factorial;
            }
        }
        if (Math.abs(e) >= 1) {
            return sum - 1;
        } else {
            return sum;
        }
    }

    static double findFunctionValue(double x) {
        return Math.pow(Math.E, x);
    }

    static void printResults(double n, double x, double e, double firstSum,
                             double secondSum, double thirdSum, double functionValue) {
        System.out.printf("1.Сумма первых %1$.0f слагаемых равна %2$.3f \n", n, firstSum);
        System.out.printf("2.Сумма тех первых %1$.0f слагаемых, которые больше %2$.3f равна %3$.3f \n", n, e, secondSum);
        System.out.printf("3.Сумма тех первых %1$.0f слагаемых, которые больше %2$.3f равна %3$.3f \n", n, e / 10, thirdSum);
        System.out.printf("4.Значение функции при x=%1$.3f равно %2$.3f", x, functionValue);
    }
}

