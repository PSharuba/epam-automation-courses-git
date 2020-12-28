package com.epam.automation.java.exceptions.university.enums;

public enum SubjectType {
    MATH {
        @Override
        public String getSubjectName() {
            return "Mathematical science";
        }
    }, PHYSICS {
        @Override
        public String getSubjectName() {
            return "Physics and mechanics";
        }
    }, BIOLOGY {
        @Override
        public String getSubjectName() {
            return "Biology and anatomy";
        }
    }, CHEMISTRY {
        @Override
        public String getSubjectName() {
            return "Chemistry";
        }
    }, PROGRAMMING {
        @Override
        public String getSubjectName() {
            return "Computer programming";
        }
    }, ENGLISH {
        @Override
        public String getSubjectName() {
            return "English";
        }
    };

    public abstract String getSubjectName();
}
