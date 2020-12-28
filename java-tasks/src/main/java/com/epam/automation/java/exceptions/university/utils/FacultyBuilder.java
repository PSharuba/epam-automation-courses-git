package com.epam.automation.java.exceptions.university.utils;

import com.epam.automation.java.exceptions.university.entities.Faculty;
import com.epam.automation.java.exceptions.university.entities.Group;
import com.epam.automation.java.exceptions.university.entities.Student;
import com.epam.automation.java.exceptions.university.enums.FacultyType;
import com.epam.automation.java.exceptions.university.enums.SubjectType;

import java.util.ArrayList;
import java.util.Random;

public class FacultyBuilder {
    private static final int DEFAULT_SUBJECTS_COUNT_PER_GROUP = 5;
    private static final int DEFAULT_STUDENTS_COUNT = 3;
    private static ArrayList<SubjectType> subjectTypes;
    private static Random random;

    static {
        subjectTypes = new ArrayList<>();
        random = new Random();
    }

    public static Faculty createFaculty(int groupCount, FacultyType facultyType) {
        ArrayList<Group> groups = new ArrayList<>();
        generateSubjects();
        for (int i = 1; i <= groupCount; i++) {
            groups.add(createGroup(i, DEFAULT_STUDENTS_COUNT));
        }
        return new Faculty(facultyType, groups);
    }

    public static Group createGroup(int number, int studentsCount) {
        ArrayList<Student> students = StudentBuilder.createStudents(studentsCount, subjectTypes);
        return new Group(number, students);
    }

    private static void generateSubjects() {
        subjectTypes.clear();
        for (int i = 0; i < DEFAULT_SUBJECTS_COUNT_PER_GROUP; i++) {
            subjectTypes.add(SubjectType.values()[random.nextInt(SubjectType.values().length)]);
        }
    }
}
