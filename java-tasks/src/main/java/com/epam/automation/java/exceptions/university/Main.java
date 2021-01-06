package com.epam.automation.java.exceptions.university;


import com.epam.automation.java.exceptions.university.entities.Faculty;
import com.epam.automation.java.exceptions.university.entities.Group;
import com.epam.automation.java.exceptions.university.entities.University;
import com.epam.automation.java.exceptions.university.enums.SubjectType;
import com.epam.automation.java.exceptions.university.utils.UniversityBuilder;

import java.util.Random;

/**
 * Pavel Sharuba 2020
 * В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы.
 * У каждого студента есть несколько учебных предметов по которым он получает оценки.
 * Необходимо реализовать иерархию студентов, групп и факультетов.
 *
 * -Посчитать средний балл по всем предметам студента
 * -Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
 * -Посчитать средний балл по предмету для всего университета
 *
 * Релизовать следующие исключения:
 * -Оценка ниже 0 или выше 10
 * -Отсутсвие предметов у студента (должен быть хотя бы один)
 * -Отсутствие студентов в группе
 * -Отсутствие групп на факультете
 * -Отсутствие факультетов в университете
 */
public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        University university = null;
        try {
            university = UniversityBuilder.createUniversity();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        Faculty facultyToSearch = university.getFaculties().get(0);
        Group groupToSearch = facultyToSearch.getGroups().get(0);
        String subjectToSearch = SubjectType.values()[random.nextInt(SubjectType.values().length)].name();

        System.out.println(university.toString());

        double avgMark = university.getAvgMarkBySubject(subjectToSearch);
        while (avgMark == -1) {
            subjectToSearch = SubjectType.values()[random.nextInt(SubjectType.values().length)].name();
            avgMark = university.getAvgMarkBySubject(subjectToSearch);
        }
        System.out.println("\nAVG mark in university on " + subjectToSearch + ": "
                + avgMark);

        avgMark = facultyToSearch.getAvgMarkBySubject(subjectToSearch);
        System.out.println("AVG mark on " + subjectToSearch + " at "
                + facultyToSearch.getFacultyName() + ": "
                + avgMark);

        avgMark = groupToSearch.getAvgMarkBySubject(subjectToSearch);
        System.out.println("AVG mark on " + subjectToSearch + " in group №"
                + groupToSearch.getNumber() + ": "
                + avgMark);
    }
}
