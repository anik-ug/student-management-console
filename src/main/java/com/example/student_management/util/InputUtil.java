package com.example.student_management.util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);

    // Read integer safely
    public static int readInt(String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            try {
                number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    // Read string safely
    public static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

//    public static int getIntInput(Scanner scanner, String prompt) {
//        while (true) {
//            System.out.print(prompt);
//            if (scanner.hasNextInt()) {
//                int value = scanner.nextInt();
//                scanner.nextLine(); // consume newline
//                return value;
//            } else {
//                System.out.println("Invalid number, please try again.");
//                scanner.nextLine(); // discard invalid input
//            }
//        }
//    }
}

