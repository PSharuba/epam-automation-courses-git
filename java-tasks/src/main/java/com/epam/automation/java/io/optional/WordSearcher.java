package com.epam.automation.java.io.optional;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Pavel Sharuba 2020
 * Из текстового файла ввести последовательность строк.
 * Выделить отдельные слова, разделяемые пробелами.
 * Написать метод поиска слова по образцу-шаблону.
 * Вывести найденное слово в другой файл.
 */
public class WordSearcher {
    private static final String DEFAULT_INPUT_FILE = "src/main/resources/poem.txt";
    private static final String DEFAULT_OUTPUT_FILE = "src/main/resources/SearchedWord.txt";
    private static final String DEFAULT_WORD = "ад";

    public ArrayList<String> readWordsFromFile(String address) {
        ArrayList<String> fileLines = new ArrayList<>();
        ArrayList<String> allWords = new ArrayList<>();
        ArrayList<String> distinctWords = new ArrayList<>();
        try (FileReader reader = new FileReader(address);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            bufferedReader.lines().forEach(fileLines::add);
            fileLines.forEach((line) -> allWords.addAll(Arrays.asList(line.replace(",", "")
                    .replace(".", "")
                    .replace(";", "")
                    .replace(":", "")
                    .toLowerCase().split(" "))));
            distinctWords = (ArrayList<String>) allWords.stream().distinct().collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return distinctWords;
    }

    public void findCharSequenceInArrayAndWriteToFile(String fileAddress, ArrayList<String> wordsList, String charSequence) {
        ArrayList<String> searchResult = new ArrayList<>();
        for (String word : wordsList) {
            if (word.lastIndexOf(charSequence.toLowerCase()) != -1) {
                searchResult.add(word);
            }
        }
        try (PrintStream stream = new PrintStream(new FileOutputStream(fileAddress));
        ) {
            System.setOut(stream);
            if (searchResult.size() > 0) {
                searchResult.forEach(System.out::println);
            } else {
                System.out.print("No results found!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WordSearcher searcher = new WordSearcher();
        ArrayList<String> words;
        words = searcher.readWordsFromFile(DEFAULT_INPUT_FILE);
        searcher.findCharSequenceInArrayAndWriteToFile(DEFAULT_OUTPUT_FILE, words, DEFAULT_WORD);
    }
}
