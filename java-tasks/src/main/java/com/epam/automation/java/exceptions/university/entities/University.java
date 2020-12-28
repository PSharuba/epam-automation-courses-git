package com.epam.automation.java.exceptions.university.entities;

import com.epam.automation.java.exceptions.university.exceptions.IllegalFacultyCountException;

import java.util.ArrayList;

public class University {
    private String name;
    private ArrayList<Faculty> faculties;

    public University(String name, ArrayList<Faculty> faculties) {
        this.name = name;
        if (faculties.size() > 0) {
            this.faculties = faculties;
        } else throw new IllegalFacultyCountException("Empty faculties list in University constructor.");
    }

    public double getAvgMarkBySubject(String subjectName) {
        double avgMark = 0.;
        int facultiesCount = faculties.size();
        for (Faculty f : faculties) {
            double avgMarkOnFaculty = f.getAvgMarkBySubject(subjectName);
            if (avgMarkOnFaculty == -1)
                facultiesCount--;
            else avgMark += avgMarkOnFaculty;
        }
        if (facultiesCount <= 0) return -1;
        return avgMark / facultiesCount;
    }

    public double getAvgMarkBySubjectOnFaculty(String subjectName, int facultyNumber) {
        return faculties.get(facultyNumber).getAvgMarkBySubject(subjectName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        if (faculties.size() > 0) {
            this.faculties = faculties;
        } else throw new IllegalFacultyCountException("Empty faculties list in University setFaculties().");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append("Faculties:\n");
        for (Faculty f : faculties) {
            builder.append(f.toString());
        }
        return builder.toString();
    }
}
