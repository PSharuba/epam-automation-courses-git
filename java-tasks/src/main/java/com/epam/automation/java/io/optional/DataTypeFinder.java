package com.epam.automation.java.io.optional;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Pavel Sharuba 2020
 * Файл содержит символы, слова, целые числа и числа с плавающей запятой.
 * Определить все данные, тип которых вводится из командной строки.
 */
public class DataTypeFinder {
    private static final String DEFAULT_INPUT_FILE = "src/main/resources/Variables.csv";
    private static final String DEFAULT_OUTPUT_FILE = "src/main/resources/FoundData.txt";

    /**
     * @param data - input string
     * @return 1 - Long, 2 - Double, 3 - Char, 0 - String
     */
    private int findDataType(String data) {
        if (data.matches("\\d+"))
            return 1;
        if (data.matches("\\d+.\\d*"))
            return 2;
        if (data.length() == 1)
            return 3;
        return 0;
    }

    public ArrayList<String> readFile(String fileAddress) {
        ArrayList<String> fileLines = new ArrayList<>();
        try (FileReader reader = new FileReader(fileAddress);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            bufferedReader.lines().forEach(fileLines::add);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileLines;
    }

    public void writeDataToFile(String fileAddress, ArrayList<String> data) {
        try (PrintStream stream = new PrintStream(new FileOutputStream(fileAddress));
        ) {
            System.setOut(stream);
            data.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> findDataByType(ArrayList<String> data, int type) {
        ArrayList<String> searchResult = new ArrayList<>();
        for (String s : data) {
            if (findDataType(s) == type)
                searchResult.add(s);
        }

        return searchResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataTypeFinder finder = new DataTypeFinder();
        String input;
        int searchedType = -1;

        System.out.println("Choose data type to search for (int, double, char, string):");
        input = scanner.nextLine().trim().toLowerCase();
        while (searchedType == -1) {
            switch (input) {
                case "int":
                    searchedType = 1;
                    break;
                case "double":
                    searchedType = 2;
                    break;
                case "char":
                    searchedType = 3;
                    break;
                case "string":
                    searchedType = 0;
                    break;
                default:
                    System.out.println("Wrong data type. Try again:");
                    input = scanner.nextLine().toLowerCase();
            }
        }
        ArrayList<String> data = finder.readFile(DEFAULT_INPUT_FILE);
        ArrayList<String> searchResult = finder.findDataByType(data, searchedType);
        finder.writeDataToFile(DEFAULT_OUTPUT_FILE, searchResult);
    }
}
