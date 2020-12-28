package com.epam.automation.java.exceptions.university.entities;

import com.epam.automation.java.exceptions.university.exceptions.IllegalStudentCountException;

import java.util.ArrayList;

public class Group {
    private int number;
    private ArrayList<Student> students;

    public Group(int number, ArrayList<Student> students) {
        if (number > 0) {
            this.number = number;
        } else throw new IllegalArgumentException("Wrong group number in Group constructor. Number: " + number);
        if (students.size() > 0) {
            this.students = students;
        } else throw new IllegalStudentCountException("Empty students list in Group constructor.");
    }

    public double getAvgMarkBySubject(String subjectName) {
        double avgMark = 0.;
        for (Student s : students) {
            Subject subject = s.getSubjectByName(subjectName);
            if (subject == null) {
                return -1;
            }
            avgMark += subject.getMark();
        }
        return avgMark / students.size();
    }

    public double getAvgMarkByAllSubjects() {
        double avgMark = 0.;
        for (Student s : students) {
            avgMark += s.getAvgMark();
        }
        return avgMark / (students.size());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        } else throw new IllegalArgumentException("Wrong group number in Group setNumber(). Number: " + number);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        if (students.size() > 0) {
            this.students = students;
        } else throw new IllegalStudentCountException("Empty students list in Group setStudents.");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Group ").append(number).append("\nStudents:\n");
        for (Student s : students) {
            builder.append(s.toString());
        }
        builder.append('\n');
        return builder.toString();
    }
}
