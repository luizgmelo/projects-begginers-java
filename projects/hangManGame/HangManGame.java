package hangManGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangManGame {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/guilherme/Projects/study/projects-to-begginners/projects/hangManGame/words.txt"));
        Scanner keyboard = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random rand = new Random();

        String word = words.get(rand.nextInt(words.size()));

        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();



        int countWrongs = 0;

        while (true) {
            printOutHangMan(countWrongs);
            System.out.println();
            wordStatus(word, playerGuesses);

            if (countWrongs == 6) {
                System.out.println("You lose!");
                break;
            }

            userGuessLetter(keyboard, playerGuesses);

            if (wordStatus(word, playerGuesses)) {
                System.out.println("You win!");
                break;
            }

            if (userGuessWord(keyboard, word)) {
                System.out.println("You win!");
                break;
            } else {
                countWrongs++;
            }
        }
    }

    private static void printOutHangMan(int countWrongs) {
        System.out.println(" +---+");
        System.out.println(" |   |");
        if (countWrongs >= 1) {
            System.out.println(" O");
        }
        if (countWrongs >= 2) {
            System.out.print("\\");
            if (countWrongs >= 3) {
                System.out.print(" /");
            }
            System.out.println();
        }
        if (countWrongs >= 4) {
            System.out.println(" |");
        }
        if (countWrongs >= 5) {
            System.out.print("/");
            if (countWrongs >= 6) {
                System.out.print(" \\");
            }
            System.out.println();
        }
    }

    private static boolean userGuessWord(Scanner keyboard, String word) {
        System.out.println("Please enter your guess for the word:");
        String playerGuess = keyboard.nextLine();
        if (word.equalsIgnoreCase(playerGuess)) {
            return true;
        } else {
            System.out.println("Nope, Try again");
        }
        return false;
    }

    private static void userGuessLetter(Scanner keyboard, List<Character> playerGuesses) {
        System.out.println("Please enter your letter: ");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.toLowerCase().charAt(0));
    }

    private static boolean wordStatus(String word, List<Character> playerGuesses) {
        int countCorrect = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                countCorrect++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();

        return (word.length() == countCorrect);
    }
}
