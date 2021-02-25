package com.epam.automation.java.exceptions.university.utils;

import com.epam.automation.java.exceptions.university.entities.Student;
import com.epam.automation.java.exceptions.university.entities.Subject;
import com.epam.automation.java.exceptions.university.enums.SubjectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StudentBuilder {
    private static final List<String> NAMES_LIST = Arrays.asList("Pavel", "Mary", "Elizabeth", "Dmitry", "Egor", "Victoria", "Ivan", "Petr", "Anton", "Ulia", "Polina");
    private static final List<String> SURNAMES_LIST = Arrays.asList("Sharuba", "Zheltok", "Kapusta", "Borsch", "Smetana", "Zvezda", "Kofeek", "Chaika");

    public static ArrayList<Student> createStudents(int count, ArrayList<SubjectType> subjectTypes) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            students.add(createStudent(i, subjectTypes));
        }
        return students;
    }

    public static Student createStudent(int id, ArrayList<SubjectType> subjectTypes) {
        String name = NAMES_LIST.get(new Random().nextInt(NAMES_LIST.size()));
        String surname = SURNAMES_LIST.get(new Random().nextInt(SURNAMES_LIST.size()));
        ArrayList<Subject> subjects = new ArrayList<>();
        Random random = new Random();
        for (SubjectType type : subjectTypes) {
            subjects.add(new Subject(type, random.nextInt(7) + 4));
        }
        return new Student(id, name, surname, subjects);
    }
}
