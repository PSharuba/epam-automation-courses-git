package com.epam.automation.java.io.main.scanner;

import com.epam.automation.java.io.main.scanner.comparators.FileNameComparator;
import com.epam.automation.java.io.main.scanner.comparators.FileTypeComparator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryScanner {

    public static final File DEFAULT_OUTPUT_FILE = new File("src/main/resources/FoldersList.txt");
    public static final String DEFAULT_TITLE = "Directory: ";

    public void scanDirectory(File directory, int subfolderNumber) {
        writeFileName(directory, subfolderNumber, false);
        File[] files = directory.listFiles();
        if (files != null && files.length > 0) {
            Arrays.sort(files, new FileTypeComparator().thenComparing(new FileNameComparator()));
            for (File currentFile : files) {
                if (currentFile.isFile()) {
                    writeFileName(currentFile, subfolderNumber, true);
                } else if (currentFile.isDirectory()) {
                    scanDirectory(currentFile, subfolderNumber + 1);
                }
            }
        }
    }

    public void readFile(BufferedReader bufferedReader) {
        ArrayList<String> fileLines = new ArrayList<>();
        bufferedReader.lines().forEach(fileLines::add);
        if (fileLines.size() > 0) {
            if (fileLines.get(0).contains(DEFAULT_TITLE)) {
                int[] filesAndFoldersCount = getFilesAndFoldersCount(fileLines);
                double avgFilesCount = (double) filesAndFoldersCount[0] / filesAndFoldersCount[1];
                System.out.println("Files count: " + filesAndFoldersCount[0] +
                        "\nFolders count: " + filesAndFoldersCount[1] +
                        "\nAVG file/folder count: " + avgFilesCount +
                        "\nAVG file name length: " + getAvgFileNameLength(fileLines));
            } else {
                System.out.println("Wrong file!");
            }
        } else {
            System.out.println("Wrong file!");
        }

    }

    private int[] getFilesAndFoldersCount(ArrayList<String> fileLines) {
        int filesCount = 0;
        int foldersCount = 0;
        for (String line : fileLines) {
            if (!line.isEmpty()) {
                if (line.charAt(0) == '|') {
                    if (line.charAt(1) == ' ') filesCount++;
                    else if (line.charAt(1) == '-') foldersCount++;
                }
            }
        }
        return new int[]{filesCount, foldersCount};
    }

    private double getAvgFileNameLength(ArrayList<String> fileLines) {
        ArrayList<Integer> fileNamesLength = new ArrayList<>();
        for (String line : fileLines) {
            if (!line.isEmpty()) {
                if (line.charAt(0) == '|') {
                    if (line.charAt(1) == ' ') {
                        int pointer = 1;
                        while (line.charAt(pointer) == ' ') {
                            pointer++;
                        }
                        fileNamesLength.add(line.length() - pointer);
                    }
                }
            }
        }
        if (fileNamesLength.size() > 0) {
            double sumLength = 0;
            for (Integer length : fileNamesLength)
                sumLength += length;
            return sumLength / fileNamesLength.size();
        }
        return 0;
    }

    private void writeFileName(File file, int subfolderNumber, boolean isFile) {
        System.out.print("|");
        if (isFile) {
            for (int i = 0; i < subfolderNumber; i++) {
                System.out.print(" ");
            }
        } else {
            for (int i = 0; i < subfolderNumber; i++) {
                System.out.print("-");
            }
        }
        System.out.print(file.getName() + "\n");
    }

    public static void main(String[] args) {
        String path = "D:\\EPAM\\git-course\\epam-automation-courses-git\\java-tasks\\src\\main\\resources\\FoldersList.txt";
        if (args.length >= 0) {
            File fileOrDirectory = new File(path);
            if (fileOrDirectory.exists()) {
                DirectoryScanner scanner = new DirectoryScanner();
                if (fileOrDirectory.isDirectory()) {
                    try (PrintStream stream = new PrintStream(new FileOutputStream(DirectoryScanner.DEFAULT_OUTPUT_FILE))) {
                        System.setOut(stream);
                        System.out.println(DirectoryScanner.DEFAULT_TITLE + fileOrDirectory.getAbsolutePath());
                        scanner.scanDirectory(fileOrDirectory, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (fileOrDirectory.isFile()) {
                    try (FileReader reader = new FileReader(path);
                         BufferedReader bufferedReader = new BufferedReader(reader)) {
                        scanner.readFile(bufferedReader);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Such file or directory doesn't exist!");
            }
        } else {
            System.out.println("Empty command line arguments!");
        }
    }
}
