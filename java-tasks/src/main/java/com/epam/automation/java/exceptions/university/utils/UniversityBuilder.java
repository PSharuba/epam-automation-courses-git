package com.epam.automation.java.exceptions.university.utils;

import com.epam.automation.java.exceptions.university.entities.Faculty;
import com.epam.automation.java.exceptions.university.entities.University;
import com.epam.automation.java.exceptions.university.enums.FacultyType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UniversityBuilder {
    private static final List<String> UNIVERSITY_NAMES = Arrays.asList("BSU", "BNTU", "MSLU");
    private static final int DEFAULT_FACULTY_COUNT = 3;
    private static final int DEFAULT_GROUP_PER_FACULTY_COUNT = 3;

    public static University createUniversity() {
        Random random = new Random();
        String name = UNIVERSITY_NAMES.get(random.nextInt(UNIVERSITY_NAMES.size()));

        ArrayList<Faculty> faculties = new ArrayList<>();
        for (int i = 0; i < DEFAULT_FACULTY_COUNT; i++) {
            FacultyType facultyType = FacultyType.values()[random.nextInt(FacultyType.values().length)];
            faculties.add(FacultyBuilder.createFaculty(DEFAULT_GROUP_PER_FACULTY_COUNT, facultyType));
        }
        return new University(name, faculties);
    }

}
