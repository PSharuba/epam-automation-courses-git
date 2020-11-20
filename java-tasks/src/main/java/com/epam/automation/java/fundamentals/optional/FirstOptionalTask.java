package com.epam.automation.java.fundamentals.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FirstOptionalTask {
    static void findLongest(String[] array) {
        int maxLength = array[0].length();
        String maxNumber = array[0];
        for (String number : array) {
            if (number.length() > maxLength) {
                maxLength = number.length();
                maxNumber = number;
            }
        }
        System.out.println("\nLongest number: " + maxNumber + " Length: " + maxLength);
    }

    static void findShortest(String[] array) {
        int minLength = array[0].length();
        String minNumber = array[0];
        for (String number : array) {
            if (number.length() < minLength) {
                minLength = number.length();
                minNumber = number;
            }
        }
        System.out.println("\nShortest number: " + minNumber + " Length: " + minLength);
    }

    static void sortNumbersByLength(String[] array) {
        Comparator<String> comparatorDirect = (s1, s2) -> s1.length() - s2.length();
        Comparator<String> comparatorReverse = (s1, s2) -> s2.length() - s1.length();
        String[] directOrder = array.clone();
        String[] reverseOrder = array.clone();
        Arrays.sort(directOrder, comparatorDirect);
        Arrays.sort(reverseOrder, comparatorReverse);
        System.out.println("Sorted in direct order:\n" +
                Arrays.toString(directOrder) +
                "\nSorted in reverse order:\n" +
                Arrays.toString(reverseOrder));
    }

    static void avgLength(String[] array) {
        double avgLength = 0;
        int arrayLength = array.length;
        for (String s : array) {
            avgLength += s.length();
        }
        avgLength /= arrayLength;
        System.out.println("\nAVG length: " + avgLength);
        System.out.println("Numbers with length more then avg:");
        for (String s : array) {
            if (s.length() > avgLength)
                System.out.println(s + " Length: " + s.length());
        }
        System.out.println("\nNumbers with length less then avg:");
        for (String s : array) {
            if (s.length() < avgLength)
                System.out.println(s + " Length: " + s.length());
        }
    }

    static void diffDigits(String[] array) {
        int[] diffDigitsNumber = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int[] digits = new int[10];
            for (int j = 0; j < array[i].length(); j++) {
                if (array[i].charAt(j) == '-' || array[i].charAt(j) == ',') continue;
                digits[array[i].charAt(j) - '0']++;
            }
            int diffDigits = 0;
            for (int j = 0; j < 10; j++) {
                if (digits[j] > 0) diffDigits++;
            }
            diffDigitsNumber[i] = diffDigits;
        }
        int minDiffNumber = diffDigitsNumber[0];
        String number = array[0];
        for (int i = 0; i < array.length; i++) {
            if (diffDigitsNumber[i] < minDiffNumber) {
                minDiffNumber = diffDigitsNumber[i];
                number = array[i];
            }
        }
        System.out.println("\nNumber with min number of different digits is "
                + number + " with " + minDiffNumber + " different digits.");
    }

    public static void main(String[] args) {
        int n;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter count of numbers - N>0:");

        while (true) {
            if (inputScanner.hasNextInt()) {
                int number = inputScanner.nextInt();
                if (number > 0) {
                    n = number;
                    inputScanner.nextLine();
                    break;
                }
            }
            System.out.println("Please enter integer N>0.");
            inputScanner.nextLine();
        }

        System.out.println("Enter " + n + " numbers:");

        String[] numbers = new String[n];

        for (int i = 0; i < n; i++) {
            while (true) {
                if (inputScanner.hasNextDouble()) {
                    numbers[i] = inputScanner.nextLine().trim();
                    break;
                }
                System.out.println("Please enter DOUBLE number.");
                inputScanner.nextLine();
            }
        }
        inputScanner.close();

        System.out.println("Your numbers:");
        System.out.println(Arrays.toString(numbers));

        findLongest(numbers);
        findShortest(numbers);
        sortNumbersByLength(numbers);
        avgLength(numbers);
        diffDigits(numbers);
    }
}
