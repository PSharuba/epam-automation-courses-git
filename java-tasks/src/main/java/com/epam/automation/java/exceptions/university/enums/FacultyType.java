package com.epam.automation.java.exceptions.university.enums;

public enum FacultyType {
    MMF {
        @Override
        public String getFacultyName() {
            return "Faculty of Mechanics and Mathematics";
        }
    }, FAMCS {
        @Override
        public String getFacultyName() {
            return "Faculty of Applied Mathematics and Computer Science";
        }
    }, BIOLOGY {
        @Override
        public String getFacultyName() {
            return "Faculty of Biology";
        }
    }, MILITARY {
        @Override
        public String getFacultyName() {
            return "Military Faculty";
        }
    }, GEOGRAPHY {
        @Override
        public String getFacultyName() {
            return "Faculty of Geography and Geoinformatics";
        }
    }, HISTORY {
        @Override
        public String getFacultyName() {
            return "Faculty of History";
        }
    }, PHYSICS {
        @Override
        public String getFacultyName() {
            return "Faculty of Physics";
        }
    }, ECONOMICS {
        @Override
        public String getFacultyName() {
            return "Faculty of Economics";
        }
    }, LAW {
        @Override
        public String getFacultyName() {
            return "Faculty of Law ";
        }
    };

    public abstract String getFacultyName();
}
