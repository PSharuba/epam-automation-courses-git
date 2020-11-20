package com.epam.automation.java.classes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StudentService {
    private final static int NAMES_LIST_SIZE = 11;
    private final static int SURNAMES_LIST_SIZE = 8;
    private final static int PATRONYMISC_LIST_SIZE = 5;
    private final static int COURSES_COUNT = 5;
    private final static int FACULTIES_COUNT = 9;
    private Student[] students;
    private List<String> namesList;
    private List<String> surnamesList;
    private List<String> patronymicsList;

    public StudentService(int studentsNumber) {
        students = new Student[studentsNumber];
        namesList = Arrays.asList("Pavel", "Mary", "Elizabeth", "Dmitry", "Egor", "Victoria", "Ivan", "Petr", "Anton", "Ulia", "Polina");
        surnamesList = Arrays.asList("Sharuba", "Zheltok", "Kapusta", "Borsch", "Smetana", "Zvezda", "Kofeek", "Chaika");
        patronymicsList = Arrays.asList("Vladimirovich", "Petrovich", "Ivanovich", "Pavlovich", "Dmitrievich");
        for (int i = 0; i < studentsNumber; i++) {
            students[i] = generateStudent(i);
        }
    }

    public Student generateStudent(int id) {
        String name = namesList.get(new Random().nextInt(NAMES_LIST_SIZE - 1));
        String surname = surnamesList.get(new Random().nextInt(SURNAMES_LIST_SIZE - 1));
        String patronymic = patronymicsList.get(new Random().nextInt(PATRONYMISC_LIST_SIZE - 1));
        int year = new Random().nextInt(15) + 1990;
        int day = new Random().nextInt(364)+1;
        LocalDate dateOfBirth = LocalDate.ofYearDay(year, day);
        int faculty = new Random().nextInt(FACULTIES_COUNT - 1);
        int course = new Random().nextInt(COURSES_COUNT - 1);
        int group = new Random().nextInt(9) + 1;
        return new Student(id, name, surname, patronymic, dateOfBirth, Faculty.values()[faculty], Course.values()[course], group);
    }

    public void printAllStudentsOfFaculty(Faculty faculty) {
        System.out.println("List of all students of " + faculty.getFacultyName());
        for (Student student : students) {
            if (student.getFaculty() == faculty) {
                System.out.println(student.toString() + "\n\n");
            }
        }
    }

    public void printAllStudentsByFacultyAndCourse() {
        for (Faculty faculty : Faculty.values()) {
            System.out.println("List of students of " + faculty.getFacultyName() + ":\n");
            for (Course course : Course.values()) {
                System.out.println("List of students of " + course.getCourseName() + ":\n");
                for (Student student : students) {
                    if (student.getFaculty() == faculty && student.getCourse() == course) {
                        System.out.println(student.toString() + "\n\n");
                    }
                }
            }
        }
    }

    public void printStudentsBornAfterYear(int year) {
        for (Student s : students) {
            if (s.isBornAfter(year)) {
                System.out.println(s.toString() + "\n\n");
            }
        }
    }

    public void getStudentsOfGroup(Faculty faculty, Course course, int group) {
        if (group > 0) {
            System.out.println("Students of " + group + " group, " + course.getCourseName() + " of " + faculty.getFacultyName());
            for (Student s : students) {
                if (s.getFaculty() == faculty && s.getCourse() == course && s.getGroup() == group) {
                    System.out.println(s.toString() + "\n\n");
                }
            }
        }
    }
}