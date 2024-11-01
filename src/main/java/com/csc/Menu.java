package com.csc;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        // Test cases for the promptForValue function
        Integer value1 = promptForValue("Please enter a value between 0 and 50", "Your value is invalid", 0, 50, 25);
        if (value1 != null) {
            System.out.println("The value chosen by the user is " + value1);
        } else {
            System.out.println("The user aborted the input.");
        }
    }

    public static Integer promptForValue(String prompt, String errorMessage, int lowerBound, int upperBound, int defaultValue) {
        try (Scanner scanner = new Scanner(System.in)) {
            Integer value = null;
            while (true) {
                System.out.println(prompt + " (or type 'default' to use the default value: " + defaultValue + ", or 'exit' to abort)");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    return null;
                } else if (input.isEmpty() || input.equalsIgnoreCase("default")) {
                    value = defaultValue;
                    break;
                } else if (input.matches("\\d+")) {
                    value = Integer.parseInt(input);
                    if (value >= lowerBound && value <= upperBound) {
                        break;
                    } else {
                        System.out.println(errorMessage);
                    }
                } else {
                    System.out.println(errorMessage);
                }
            }
            return value;
        }
    }
    
}
