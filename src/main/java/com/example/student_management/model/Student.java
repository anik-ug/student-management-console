package com.example.student_management.model;

import java.io.Serializable;

public class Student implements Serializable {


    private int rollNumber;
    private String name;
    private int age;
    private String course;

    public Student(int rollNumber, String name, int age, String course) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.course = course;
    }
        // Getters and setters
        public int getRollNumber() { return rollNumber; }
        public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public String getCourse() { return course; }
        public void setCourse(String course) { this.course = course; }

        @Override
        public String toString() {
            return "Roll No: " + rollNumber + ", Name: " + name +
                    ", Age: " + age + ", Course: " + course;
        }


}
