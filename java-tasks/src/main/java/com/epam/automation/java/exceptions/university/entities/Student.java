package com.epam.automation.java.exceptions.university.entities;

import com.epam.automation.java.exceptions.university.exceptions.IllegalSubjectCountException;

import java.util.ArrayList;

public class Student {
    private long id;
    private String name;
    private String surname;
    private ArrayList<Subject> subjects;

    public Student(long id, String name, String surname, ArrayList<Subject> subjects) {
        if (id >= 0) {
            this.id = id;
        } else throw new IllegalArgumentException("Wrong ID format in Student constructor. ID: " + id);
        if (name.isBlank() || surname.isBlank()) {
            throw new IllegalArgumentException("Empty name and/or surname in Student constructor.\n" +
                    "Name: " + name + " Surname: " + surname);
        } else {
            this.name = name;
            this.surname = surname;
        }
        if (subjects.size() > 0) {
            this.subjects = subjects;
        } else throw new IllegalSubjectCountException("Empty subjects list in Student constructor.");
    }

    public double getAvgMark() {
        double avgMark = 0.;
        for (Subject s : subjects)
            avgMark += s.getMark();
        return avgMark / subjects.size();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Empty name in Student setName().");
        } else {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname.isBlank()) {
            throw new IllegalArgumentException("Empty surname in Student setSurname().");
        } else {
            this.surname = name;
        }
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public int getSubjectsCount() {
        return subjects.size();
    }

    public Subject getSubjectByName(String name) {
        Subject subject = null;
        for (Subject s : subjects) {
            if (s.getSubjectType().name().toUpperCase().equals(name.toUpperCase()))
                subject = s;
            break;
        }
        return subject;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        if (subjects.size() > 0) {
            this.subjects = subjects;
        } else throw new IllegalSubjectCountException("Empty subjects list in Student setSubjects().");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student №").append(id)
                .append("\nName: ").append(name).append(" ").append(surname)
                .append("\nSubjects:\n");
        for (Subject s : subjects) {
            builder.append(s.toString());
        }
        builder.append('\n');
        return builder.toString();
    }
}
