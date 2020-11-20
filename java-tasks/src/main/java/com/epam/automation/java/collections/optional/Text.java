package com.epam.automation.java.collections.optional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Pavel Sharuba 2020
 * Задан файл с текстом на английском языке. Выделить все различные слова.
 * Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.
 */

public class Text {
    private List<String> words;

    public Text(String fileAddress) throws IOException {
        setText(fileAddress);
    }

    private String deletePunctuation(String line) {
        return line.replace(",", "")
                .replace(".", "")
                .replace("!", "")
                .replace("?", "")
                .replace("-", "")
                .replace(";", "")
                .replace(":", "")
                .replace("\"", "")
                .replace("\t", "")
                .replace("'", "");
    }

    public void setText(String fileAddress) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileAddress));
        List<String> words = new ArrayList<>();
        while (reader.ready()) {
            String[] line = deletePunctuation(reader.readLine()).split("\\s");
            words.addAll(Arrays.asList(line));
        }
        this.words = words;
    }

    public HashSet<String> findUniqueWords() {
        HashSet<String> uniqueWords = new HashSet<>();
        for (String s : words) {
            uniqueWords.add(s.toLowerCase());
        }
        return uniqueWords;
    }

    public static void main(String[] args) throws IOException {
        Text text = new Text("data\\englishText.txt");
        HashSet<String> uniqueWords = text.findUniqueWords();
        System.out.println(uniqueWords.size() + " unique words " + uniqueWords);
    }
}
