package com.epam.automation.java.exceptions.university.enums;

public enum SubjectType {

    MATH("Mathematical science") {
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
    private String name;

    SubjectType(String s) {
        this.name = s;
    }

    SubjectType() {

    }

    public String getSubjectName() {
        return name;
    }

    ;
}
