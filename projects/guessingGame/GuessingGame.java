package guessingGame;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int machineNumber = random.nextInt(101); // 0 - 100
        Scanner scanner = new Scanner(System.in);
        System.out.println("===GUESSING GAME===");
        System.out.println("You have " + 10 + " attempts");
        for (int attempts = 10; attempts > 0; attempts--) {
            System.out.print("Guess a number between (0-100):");
            int guess = scanner.nextInt();
            if (guess == machineNumber) {
                System.out.println("You won the number I thought was " + machineNumber);
                System.out.println("Attempts: " + attempts);
                System.exit(0);
            } else if (machineNumber < guess) {
                System.out.println("The number I thought is smaller than " + guess);
            } else {
                System.out.println("The number I thought is bigger than " + guess);
            }
        }
        scanner.close();
        System.out.println("Game over the number I thought was " + machineNumber);
    }
}

