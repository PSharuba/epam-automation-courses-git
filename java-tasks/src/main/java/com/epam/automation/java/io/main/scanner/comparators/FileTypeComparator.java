package com.epam.automation.java.io.main.scanner.comparators;

import java.io.File;
import java.util.Comparator;

public class FileTypeComparator implements Comparator<File> {

    @Override
    public int compare(File a, File b) {
        if(a.isFile() && b.isDirectory())
            return -1;
        if(a.isDirectory() && b.isFile())
            return 1;
        return 0;
    }
}
