package com.epam.automation.java.exceptions.university.entities;

import com.epam.automation.java.exceptions.university.enums.FacultyType;
import com.epam.automation.java.exceptions.university.exceptions.IllegalGroupCountException;

import java.util.ArrayList;

public class Faculty {
    private FacultyType facultyType;
    private ArrayList<Group> groups;

    public Faculty(FacultyType facultyType, ArrayList<Group> groups) {
        this.facultyType = facultyType;
        if (groups.size() > 0)
            this.groups = groups;
        else throw new IllegalGroupCountException("Empty groups list in Faculty constructor.");
    }

    public double getAvgMarkBySubject(String subjectName) {
        double avgMark = 0.;
        int groupsCount = groups.size();
        for (Group g : groups) {
            double markInGroup = g.getAvgMarkBySubject(subjectName);
            if (markInGroup != -1)
                avgMark += markInGroup;
            else groupsCount--;
        }
        if (groupsCount <= 0) return -1;
        return avgMark / groupsCount;
    }

    public double getAvgMarkBySubjectInGroup(String subjectName, int groupNumber) {
        return groups.get(groupNumber).getAvgMarkBySubject(subjectName);
    }

    public String getFacultyName() {
        return facultyType.getFacultyName();
    }

    public FacultyType getFacultyType() {
        return facultyType;
    }

    public void setFacultyType(FacultyType facultyType) {
        this.facultyType = facultyType;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        if (groups.size() > 0)
            this.groups = groups;
        else throw new IllegalGroupCountException("Empty groups list in Faculty setGroups.");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(facultyType.getFacultyName()).append("\nGroups:\n");
        for (Group g : groups) {
            builder.append(g.toString());
        }
        builder.append("\n");
        return builder.toString();
    }
}
