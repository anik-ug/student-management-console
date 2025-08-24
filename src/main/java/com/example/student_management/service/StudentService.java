package com.example.student_management.service;
import com.example.student_management.model.Student;
import com.example.student_management.util.InputUtil;
import java.io.*;

import java.util.*;

public class StudentService {
    private List<Student> studentsList = new ArrayList<>();
    private Map<Integer, Student> studentMap = new HashMap<>();
    private static final String DATA_FILE = "students.dat";

    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            studentsList = (List<Student>) ois.readObject();
            studentMap.clear();
            for (Student s : studentsList) {
                studentMap.put(s.getRollNumber(), s);
            }
            System.out.println("Data loaded from file.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(studentsList);
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }


    public void addStudent(Student student) {
        if (studentMap.containsKey(student.getRollNumber())) {
            System.out.println("Error: Student with roll number " + student.getRollNumber() + " already exists!");
            return;
        }
        studentsList.add(student);
        studentMap.put(student.getRollNumber(), student);
        saveToFile();
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        if (studentsList.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        // Ask user for sorting option
        System.out.println("Sort by: 1-Roll Number, 2-Name, 3-Age");
        int sortOption = InputUtil.readInt("Enter choice: ");

        List<Student> sortedList = new ArrayList<>(studentsList);
        switch(sortOption) {
            case 1: sortedList.sort(Comparator.comparingInt(Student::getRollNumber)); break;
            case 2: sortedList.sort(Comparator.comparing(Student::getName)); break;
            case 3: sortedList.sort(Comparator.comparingInt(Student::getAge)); break;
            default: System.out.println("Invalid choice, showing unsorted list.");
        }

        System.out.println("---- Student List ----");
        for (Student s : sortedList) {
            System.out.println(s);
        }
//        System.out.println("---- Student List ----");
//        for (Student s : studentsList) {
//            System.out.println(s);
//        }
    }

    public Student getStudentByRollNumber(int rollNumber) {
        return studentMap.get(rollNumber);
    }

    public void updateStudent(int rollNumber, String name, int age, String course) {
        Student s = getStudentByRollNumber(rollNumber);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }
        s.setName(name);
        s.setAge(age);
        s.setCourse(course);
        saveToFile();
        System.out.println("Student updated successfully.");
    }

    public void deleteStudent(int rollNumber) {
        Student s = getStudentByRollNumber(rollNumber);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }
        studentsList.remove(s);
        studentMap.remove(rollNumber);
        saveToFile();
        System.out.println("Student deleted successfully.");

    }
    public void printSavedData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("No saved data found.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<Student> savedStudents = (List<Student>) ois.readObject();
            if (savedStudents.isEmpty()) {
                System.out.println("No students in the file.");
            } else {
                System.out.println("---- Saved Students in File ----");
                for (Student s : savedStudents) {
                    System.out.println(s);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading saved data: " + e.getMessage());
        }
    }

}
