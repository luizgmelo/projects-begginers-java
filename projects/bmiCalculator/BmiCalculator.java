package bmiCalculator;

import java.util.Scanner;

public class BmiCalculator {
    // BMI - Body Max Index
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your height(cm):");
        double heightCm = scanner.nextDouble();
        double heightM = heightCm / 100;

        System.out.println("Enter your weight (kg):");
        double weight = scanner.nextDouble();

        double result = weight / Math.pow(heightM, 2);

        System.out.printf("Your BMI is %.1f\n", result);

        String category = "";

        if (result >= 0 && result < 18.5) {
            category = "Underweight";
        } else if (result >= 18.5 && result <= 24.9) {
            category = "Normal weight";
        } else if (result > 25 && result <= 29.9) {
            category = "Overweight";
        } else if (result >= 30 && result <= 34.9) {
            category = "Obesity Class I";
        } else if (result >= 35 && result <= 39.9) {
            category = "Obesity Class II";
        } else if (result >= 40) {
            category = "Obesity Class III";
        }

        System.out.printf("Your BMI is in %s category", category);
    }
}
