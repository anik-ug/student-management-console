package com.example.student_management;

import com.example.student_management.model.Student;
import com.example.student_management.service.StudentService;
import com.example.student_management.util.InputUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}
	@Override
	public void run(String... args) {
		StudentService service = new StudentService();
		service.loadFromFile();
		service.printSavedData();
		while (true) {
			System.out.println("\n--- Student Management System ---");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Exit");
//			System.out.print("Enter your choice: ");

//
			int choice = InputUtil.readInt("Enter your choice: ");

			switch (choice) {
				case 1:

					int roll = InputUtil.readInt("Enter Roll Number: ");
					String name = InputUtil.readString("Enter Name: ");

					int age = InputUtil.readInt("Enter Age: ");
					String course = InputUtil.readString("Enter Course: ");
					service.addStudent(new Student(roll, name, age, course));
					break;

				case 2:
					service.displayStudents();
					break;

				case 3:
					System.out.print("Enter Roll Number to search: ");
//					int roll = sc.nextInt();
					int scrRoll = InputUtil.readInt("Enter Roll Number: ");
					Student s = service.getStudentByRollNumber(scrRoll);
					if (s != null) {
						System.out.println(s);
					}
					else System.out.println("Student not found.");
					break;

				case 4:
					int updRoll = InputUtil.readInt("Enter Roll Number to update: ");
					String newName = InputUtil.readString("Enter New Name: ");
					int newAge = InputUtil.readInt("Enter New Age: ");
					String newCourse = InputUtil.readString("Enter New Course: ");
					service.updateStudent(updRoll, newName, newAge, newCourse);
					break;

				case 5:
					int delRoll = InputUtil.readInt("Enter Roll Number to delete: ");
					service.deleteStudent(delRoll);
					break;

				case 6:
					System.out.println("Exiting... Goodbye!");
					System.exit(0);

				default:
					System.out.println("Invalid choice! Try again.");
			}
		}
	}
}
