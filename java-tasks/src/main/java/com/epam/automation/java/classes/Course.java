package com.epam.automation.java.classes;

public enum Course {
    FIRST {
        @Override
        public String getCourseName() {
            return "first course";
        }
    }, SECOND {
        @Override
        public String getCourseName() {
            return "first course";
        }
    }, THIRD {
        @Override
        public String getCourseName() {
            return "third course";
        }
    }, FOURTH {
        @Override
        public String getCourseName() {
            return "fourth course";
        }
    }, FIFTH {
        @Override
        public String getCourseName() {
            return "fifth course";
        }
    }, MAGISTRACY {
        @Override
        public String getCourseName() {
            return "magistracy";
        }
    };

    public abstract String getCourseName();
}