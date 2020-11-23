package com.epam.automation.java.classes;



import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private Faculty faculty;
    private Course course;
    private int group;

    public Student(long id, String name, String surname,
                   String patronymic, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        if (dateOfBirth.isBefore(LocalDate.now())) {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public Student(long id, String name, String surname, String patronymic,
                   LocalDate dateOfBirth, Faculty faculty, Course course, int group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        if (dateOfBirth.isBefore(LocalDate.now())) {
            this.dateOfBirth = dateOfBirth;
        }
        this.faculty = faculty;
        this.course = course;
        if (group > 0) {
            this.group = group;
        } else {
            this.group = 1;
        }
    }

    public Student(long id, String name, String surname, String patronymic,
                   LocalDate dateOfBirth, String address, String phone,
                   Faculty faculty, Course course, int group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        if (dateOfBirth.isBefore(LocalDate.now())) {
            this.dateOfBirth = dateOfBirth;
        }
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        if (group > 0) {
            this.group = group;
        } else {
            this.group = 1;
        }
    }

    public boolean isBornAfter(int year) {
        LocalDate dateToCompareWith = LocalDate.of(year, 1, 1).minusDays(1);
        return dateOfBirth.isAfter(dateToCompareWith);
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
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.isBefore(LocalDate.now())) {
            this.dateOfBirth = dateOfBirth;
            return true;
        }
        return false;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public boolean setGroup(int group) {
        if (group > 0) {
            this.group = group;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student: [").append(id).append("] ")
                .append(surname).append(" ").append(name).append(" ").append(patronymic).append(" ")
                .append(dateOfBirth.toString()).append("\n")
                .append("Address: ").append(address).append(". Phone: ").append(phone).append("\n")
                .append(faculty.getFacultyName()).append(", course - ").append(course.name()).append(", group - ").append(group);
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                group == student.group &&
                name.equals(student.name) &&
                surname.equals(student.surname) &&
                Objects.equals(patronymic, student.patronymic) &&
                Objects.equals(dateOfBirth, student.dateOfBirth) &&
                Objects.equals(address, student.address) &&
                Objects.equals(phone, student.phone) &&
                faculty == student.faculty &&
                course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, dateOfBirth, address, phone, faculty, course, group);
    }
}
