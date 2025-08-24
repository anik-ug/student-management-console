# Student Management System (Console)
A simple console-based Java application to manage students using collections and file persistence.

## Features
- Add, view, search, update, and delete students
- Data saved to `students.dat` using Object Serialization
- Sorting by roll number, name, or age
- Input utility to prevent Scanner issues

## Technologies
- Java 17+
- No external dependencies

## How to Run
```bash
javac -d out src/com/example/student_management/**/*.java
java -cp out com.example.student_management.Main
