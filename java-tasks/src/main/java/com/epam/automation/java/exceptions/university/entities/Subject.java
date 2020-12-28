package com.epam.automation.java.exceptions.university.entities;

import com.epam.automation.java.exceptions.university.enums.SubjectType;
import com.epam.automation.java.exceptions.university.exceptions.IllegalMarkException;

public class Subject {
    private SubjectType subjectType;
    private int mark;

    public Subject(SubjectType subjectType, int mark) {
        this.subjectType = subjectType;
        if (mark < 0 || mark > 10) {
            throw new IllegalMarkException("Wrong mark in Subject constructor. Mark: " + mark);
        } else
            this.mark = mark;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if (mark < 0 || mark > 10) {
            throw new IllegalMarkException("Wrong mark in Subject setMark(). Mark: " + mark);
        } else
            this.mark = mark;
    }

    @Override
    public String toString() {
        return subjectType.getSubjectName() +
                ", mark= " + mark +
                '\n';
    }
}
