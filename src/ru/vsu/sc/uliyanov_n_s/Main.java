package ru.vsu.sc.uliyanov_n_s;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x = readNumber("X", true);
        int n = (int) readNumber("sequence member number", false);
        double e = readNumber("epsilon", false);

        double sumOfSequence = calculateSumOfSequence(x, n);
        double sumOfSequenceMoreThanEpsilon = calculateSumOfSequenceMoreThanEpsilon(x, n, e);
        double sumOfSequenceMoreThanEpsilonDividedBy10 = calculateSumOfSequenceMoreThanEpsilon(x, n, e / 10);
        double meaningOfFunction = calculateMeaningOfFunction(x);

        printResult(sumOfSequence, sumOfSequenceMoreThanEpsilon, sumOfSequenceMoreThanEpsilonDividedBy10, meaningOfFunction);
    }

    static double readNumber(String text, boolean x) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s:", text);

        double num;

        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
            if (Math.abs(num) > 1 && x) {
                System.out.println("Invalid value! Yoy need to enter a number in the range from -1 to 1! Try again.");
                return readNumber(text, true);
            }
        } else if (x) {
            System.out.println("Invalid value! Yoy need to enter a NUMBER! Try again.");
            return readNumber(text, true);
        } else {
            System.out.println("Invalid value! Yoy need to enter a NUMBER! Try again.");
            return readNumber(text, false);
        }

        return num;
    }

    static double calculateSumOfSequence(double x, int n) {
        double sum = 0;

        for (int i = 0; i <= n; i++) {
            sum += Math.pow(x, i);
        }

        return sum;
    }

    private static double getNMemberOfSequence(double x, int n) {
        return Math.pow(x, n - 1);
    }

    static double calculateSumOfSequenceMoreThanEpsilon(double x, int n, double e) {
        double sum = 0;

        for (int i = 1; i <= n; i++) {
            double nMemberOfSequence = getNMemberOfSequence(x, i);
            if (Math.abs(nMemberOfSequence) > e) {
                sum += getNMemberOfSequence(x, i);
            }
        }

        return sum;
    }

    static double calculateMeaningOfFunction(double x){
        return 1 / (1 - x);
    }

    static void printResult(double sum, double sumWithEpsilon, double sumWithEpsilonDividedBy10, double meaning){
        System.out.println("The sum of the terms of the sequence is equal to " + sum);
        System.out.println("The sum of the terms of the sequence that are greater than E is equal to " + sumWithEpsilon);
        System.out.println("The sum of the terms of the sequence that are greater than E divided by 10 is equal to " + sumWithEpsilonDividedBy10);
        System.out.println("Еhe value of the function is " + meaning);
    }
}
