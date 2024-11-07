package gpaCalculator;

import java.util.Scanner;

public class GpaCalculator {
    public static void main(String[] args) {
        // Total points / total credits => GPA
        // points for a class = grade * value of credits
        // A = 4, B = 3, ...

        Scanner scanner = new Scanner(System.in);
        int credits = 0;
        int totalCredits = 0;
        int totalPoints = 0;
        boolean moreClasses;

        do {
            boolean isValidCredits;
            do {
                isValidCredits = false;
                System.out.println("Enter the number of credits:");
                String creditsString = scanner.nextLine();
                try {
                    credits = Integer.parseInt(creditsString);
                    isValidCredits = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer");
                }
            } while (!isValidCredits);

            int gradeValue = -1;
            String grade;
            do {
                System.out.println("Enter grade:");
                grade = scanner.nextLine();

                switch (grade.toUpperCase()) {
                    case "A":
                        gradeValue = 4;
                        break;
                    case "B":
                        gradeValue = 3;
                        break;
                    case "C":
                        gradeValue = 2;
                        break;
                    case "D":
                        gradeValue = 1;
                        break;
                    case "F":
                        gradeValue = 0;
                        break;
                    default:
                        System.out.println("Invalid option, please enter a valid grade :(");
                }
            } while (gradeValue == -1);

            int points = gradeValue * credits;

            totalPoints += points;
            totalCredits += credits;

            System.out.println("Would you like to enter another class? (Y/N)");
            String moreClassesString = scanner.nextLine();
            moreClasses = moreClassesString.equalsIgnoreCase("Y");

        } while (moreClasses);

        double gpa = (double) totalPoints / (double) totalCredits;

        System.out.println("Credits:" + totalCredits);
        System.out.println("Points:" + totalPoints);
        System.out.printf("GPA: %.2f", gpa);

        scanner.close();
    }
}
