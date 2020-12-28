package com.epam.automation.java.collections.optional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pavel Sharuba 2020
 * Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
 */

public class Poem {
    private List<String> poem;

    private class LinesLengthComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() < s2.length()) {
                return -1;
            }
            return 0;
        }
    }

    public LinesLengthComparator getComparator() {
        return new LinesLengthComparator();
    }

    public Poem() {
    }

    public Poem(List<String> poem) {
        this.poem = poem;
    }

    public void setPoem(List<String> poem) {
        this.poem = poem;
    }

    public void setPoem(String fileAddress) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileAddress));
        List<String> lines = new ArrayList<>();
        while (reader.ready()) {
            lines.add(reader.readLine());
        }
        this.poem = lines;
    }

    public List<String> getPoem() {
        return poem;
    }

    public static void main(String[] args) throws IOException {
        Poem poem = new Poem();
        poem.setPoem("src/main/resources/poem.txt");
        ArrayList<String> lines = (ArrayList<String>) poem.getPoem();
        lines.sort(poem.getComparator());

        System.out.println("Lines of poem sorted by length:");
        for (String s : lines) {
            System.out.println(s);
        }
    }
}
