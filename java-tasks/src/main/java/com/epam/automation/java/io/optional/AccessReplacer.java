package com.epam.automation.java.io.optional;

import java.io.*;
import java.util.ArrayList;

/**
 * Pavel Sharuba 2020
 * Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
 */

public class AccessReplacer {

    private static final String DEFAULT_INPUT_FILE = "src/main/java/com/epam/automation/java/classes/Student.java";
    private static final String DEFAULT_OUTPUT_FILE = "src/main/resources/PrivateStudent.txt";
    private static final String PUBLIC_MODIFIER = "public ";
    private static final String PRIVATE_MODIFIER = "private ";

    public void replacePublicWithPrivate(String address) {
        ArrayList<String> fileLines = new ArrayList<>();
        try (FileReader reader = new FileReader(address);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            bufferedReader.lines().forEach(fileLines::add);
            fileLines.forEach((n) -> System.out.println(n.replace(PUBLIC_MODIFIER, PRIVATE_MODIFIER)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AccessReplacer replacer = new AccessReplacer();
        File outputFile = new File(DEFAULT_OUTPUT_FILE);
        File inputFile = new File(DEFAULT_INPUT_FILE);
        try {
            outputFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputFile.exists() && inputFile.isFile() && outputFile.exists() && outputFile.isFile()) {
            try (PrintStream stream = new PrintStream(new FileOutputStream(DEFAULT_OUTPUT_FILE));
            ) {
                System.setOut(stream);
                replacer.replacePublicWithPrivate(DEFAULT_INPUT_FILE);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else System.out.println("Input and/or output files doesn't exist!");
    }
}

