package com.epam.automation.java.classes;

/**
 * Sharuba Pavel 2020
 * Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.
 * Создать массив объектов. Вывести:
 * a) список студентов заданного факультета;
 * b) списки студентов для каждого факультета и курса;
 * c) список студентов, родившихся после заданного года;
 * d) список учебной группы.
 */

public class Main {
    private static final int NUMBER_OF_STUDENTS = 1000;

    public static void main(String[] args) {
        StudentService studentService = new StudentService(NUMBER_OF_STUDENTS);
        studentService.printAllStudentsOfFaculty(Faculty.GEOGRAPHY);
        System.out.println("==================================");
        studentService.printAllStudentsByFacultyAndCourse();
        System.out.println("==================================");
        studentService.printStudentsBornAfterYear(1997);
        System.out.println("==================================");
        studentService.getStudentsOfGroup(Faculty.MMF, Course.FOURTH, 9);
    }
}
