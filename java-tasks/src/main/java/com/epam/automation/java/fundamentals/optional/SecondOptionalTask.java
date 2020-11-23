package com.epam.automation.java.fundamentals.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SecondOptionalTask {

    private static void deleteMaxElement(Integer[][] matrix) {
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
        for (ArrayList<Integer> columns : listMatrix) {
            columns.remove(maxJ);
        }
        listMatrix.remove(maxI);
        System.out.println("Max element is " + maxElement +
                " in (" + (maxI + 1) + ";" + (maxJ + 1) + ")");
        printMatrix(arrayListToMatrix(listMatrix));
    }

    private static void sumBetweenPositives(Integer[][] matrix) {
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

    private static ArrayList<ArrayList<Integer>> matrixToArrayList(Integer[][] matrix) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (Integer[] line : matrix) {
            list.add(new ArrayList<>(Arrays.asList(line)));
        }
        return list;
    }

    private static Integer[][] arrayListToMatrix(ArrayList<ArrayList<Integer>> list) {
        Integer[][] matrix = new Integer[list.size()][list.size()];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = list.get(i).toArray(Integer[]::new);
        }
        return matrix;
    }

    private static void printMatrix(Integer[][] matrix) {
        for (Integer[] arr : matrix) {
            System.out.print("[");
            for (Integer element : arr) {
                System.out.printf("%4d ", element);
            }
            System.out.print("]\n");
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix;
        Scanner inputScanner = new Scanner(System.in);
        int matrixSize;
        double numbersRange;
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
            if (inputScanner.hasNextDouble()) {
                numbersRange = inputScanner.nextDouble();
                break;
            }
            System.out.println("Please enter correct number");
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
        System.out.println("\nSums of lines arguments between positive elements:");
        sumBetweenPositives(matrix);
        System.out.println("\nMatrix without max element");
        deleteMaxElement(matrix);
    }
}
