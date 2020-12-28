package com.epam.automation.java.io.optional;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Pavel Sharuba 2020
 * Создать и заполнить файл случайными целыми числами.
 * Отсортировать содержимое файла по возрастанию.
 */

public class RandomNumbersFileFiller {
    private static final String DEFAULT_OUTPUT_FILE = "src/main/resources/RandomNumbers.txt";
    private static final int DEFAULT_RANDOM_BORDER = 100;
    private static final int DEFAULT_NUMBER_COUNT = 10;

    public void fillFileWithRandomNumbers(int numberCount, int randomBorder) {
        Random random = new Random();
        for (int i = 0; i < numberCount; i++)
            System.out.print(random.nextInt(randomBorder) + ";");
    }

    public void sortNumbersFromFile(PrintStream stream, String address) {
        System.setOut(stream);
        String[] stringNumbers;
        ArrayList<Integer> numbers = new ArrayList<>();
        try (FileReader reader = new FileReader(address);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String fileLine = bufferedReader.readLine();
            if (fileLine != null) {
                stringNumbers = fileLine.split(";");
                for (String s : stringNumbers) {
                    numbers.add(Integer.parseInt(s));
                }
                numbers.sort(Integer::compareTo);
                System.out.print("\n");
                numbers.forEach((n -> System.out.print(n + ";")));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        RandomNumbersFileFiller filler = new RandomNumbersFileFiller();
        File file = new File(DEFAULT_OUTPUT_FILE);
        if (file.exists()) file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file.exists() && file.isFile()) {
            try (PrintStream stream = new PrintStream(new FileOutputStream(DEFAULT_OUTPUT_FILE, true))) {
                System.setOut(stream);
                filler.fillFileWithRandomNumbers(DEFAULT_NUMBER_COUNT, DEFAULT_RANDOM_BORDER);
                filler.sortNumbersFromFile(stream, DEFAULT_OUTPUT_FILE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
