package com.epam.automation.java.io.main.scanner.comparators;

import java.io.File;
import java.util.Comparator;

public class FileNameComparator implements Comparator<File> {

    @Override
    public int compare(File a, File b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }

}
