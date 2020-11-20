package com.epam.automation.java.classes;

public class Main {
    public static int NUMBER_OF_STUDENTS = 1000;

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
