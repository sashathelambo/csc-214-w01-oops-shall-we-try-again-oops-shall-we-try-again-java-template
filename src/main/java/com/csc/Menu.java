package com.csc;

import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);


    public static Integer prompt(Integer lowerBound, Integer upperBound, Integer defaultValue, String promptMessage, String errorMessage) {
        Integer userValue;

  while (true) {
            String modifiedPrompt = promptMessage;
            if (defaultValue != null) {
                modifiedPrompt += " Enter 'default' to use the default value of " + defaultValue + ".";
            }
            modifiedPrompt += " Enter 'exit' to leave the menu.";

            System.out.println(modifiedPrompt);

            if (!scanner.hasNextLine()) {
                return null;
            }
            
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("default") && defaultValue != null) {
                return defaultValue;
            }

            if (userInput.equalsIgnoreCase("exit")) {
                return null;
            }

            try {
                userValue = Integer.parseInt(userInput);

                if ((lowerBound == null || userValue >= lowerBound) && 
                    (upperBound == null || userValue <= upperBound)) {
                    return userValue;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }
 
    public static void main(String[] args) {
        try {
            Integer value1 = prompt(10, 50, 25, "Please enter a value between 10 and 50:", "Your value is invalid. Please try again.");
            if (value1 != null) {
                System.out.println("The value chosen by the user is " + value1);
            } else {
                System.out.println("The user exited the menu without choosing a value.");
            }

            Integer value2 = prompt(null, 100, null, "Please enter a value less than or equal to 100:", "Your value is invalid. Please try again.");
            if (value2 != null) {
                System.out.println("The value chosen by the user is " + value2);
            } else {
                System.out.println("The user exited the menu without choosing a value.");
            }

            Integer value3 = prompt(-10, null, 0, "Please enter a value greater than or equal to -10:", "Your value is invalid. Please try again.");
            if (value3 != null) {
                System.out.println("The value chosen by the user is " + value3);
            } else {
                System.out.println("The user exited the menu without choosing a value.");
            }

            Integer value4 = prompt(null, null, null, "Please enter any integer value:", "Your value is invalid. Please try again.");
            if (value4 != null) {
                System.out.println("The value chosen by the user is " + value4);
            } else {
                System.out.println("The user exited the menu without choosing a value.");
            }
        } finally {
            scanner.close();
        }
    }
}