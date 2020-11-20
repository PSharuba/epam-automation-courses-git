package com.epam.automation.java.fundamentals.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SecondOptionalTask {

    static void deleteMaxElement(Integer[][] matrix) {
        ArrayList<ArrayList<Integer>> listMatrix = matrixToArrayList(matrix);
        int maxI = 0;
        int maxJ = 0;
        int maxElement = listMatrix.get(0).get(0);
        for (int i = 0; i < listMatrix.size(); i++) {
            for (int j = 0; j < listMatrix.get(i).size(); j++) {
                int number = listMatrix.get(i).get(j);
                if (number > maxElement) {
                    maxElement = number;
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        for (int i = 0; i < listMatrix.size(); i++) {
            listMatrix.get(i).remove(maxJ);
        }
        listMatrix.remove(maxI);
        System.out.println("Max element is " + maxElement +
                " in (" + (maxI + 1) + ";" + (maxJ + 1) + ")");
        printMatrix(arrayListToMatrix(listMatrix));
    }

    static void sumBetweenPositives(Integer[][] matrix) {
        int size = matrix.length;
        int[] lineSums = new int[size];
        boolean foundFirstPositive;
        for (int i = 0; i < size; i++) {
            foundFirstPositive = false;
            int lineSum = 0;
            int j = 0;
            while (j < size) {
                if (matrix[i][j] > 0 && !foundFirstPositive) {
                    lineSum += matrix[i][j];
                    foundFirstPositive = true;
                } else if (matrix[i][j] > 0) {
                    lineSum += matrix[i][j];
                    break;
                } else if (foundFirstPositive) {
                    lineSum += matrix[i][j];
                }
                j++;
            }
            lineSums[i] = foundFirstPositive ? lineSum : 0;
        }
        for (int i = 0; i < size; i++) {
            System.out.println("Sum of line №" + (i + 1) + ": " + lineSums[i]);
        }
    }

    static ArrayList<ArrayList<Integer>> matrixToArrayList(Integer[][] matrix) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            list.add(new ArrayList<>(Arrays.asList(matrix[i])));
        }
        return list;
    }

    static Integer[][] arrayListToMatrix(ArrayList<ArrayList<Integer>> list) {
        Integer[][] matrix = new Integer[list.size()][list.size()];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = list.get(i).toArray(Integer[]::new);
        }
        return matrix;
    }

    static void printMatrix(Integer[][] matrix) {
        for (Integer[] arr : matrix) {
            System.out.print("[\t");
            for (Integer i : arr) {
                System.out.print(i + "\t");
            }
            System.out.print("]\n");
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix;
        Scanner inputScanner = new Scanner(System.in);
        int matrixSize;
        int numbersRange;
        System.out.println("Enter matrix size N");
        while (true) {
            if (inputScanner.hasNextInt()) {
                matrixSize = inputScanner.nextInt();
                break;
            }
            System.out.println("Please enter INTEGER");
            inputScanner.nextLine();
        }
        System.out.println("Enter numbers range M");
        while (true) {
            if (inputScanner.hasNextInt()) {
                numbersRange = inputScanner.nextInt();
                break;
            }
            System.out.println("Please enter INTEGER");
            inputScanner.nextLine();
        }
        inputScanner.close();

        matrix = new Integer[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = (int) (Math.random() * (2 * numbersRange) - numbersRange);
            }
        }

        System.out.println("Matrix:\n");
        printMatrix(matrix);
        System.out.println("\nSums of lines between positives:");
        sumBetweenPositives(matrix);
        System.out.println("\nMatrix without max element");
        deleteMaxElement(matrix);
    }
}
