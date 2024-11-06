package hangManGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangManGame {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("1 ou 2 jogadores?");
        String players = keyboard.nextLine();

        String word;

        if (players.charAt(0) == '1') {
            Scanner scanner = new Scanner(new File("/home/guilherme/Projects/study/projects-to-begginners/projects/hangManGame/words.txt"));

            List<String> words = new ArrayList<>();

            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }

            Random rand = new Random();

            word = words.get(rand.nextInt(words.size()));
            scanner.close();
        } else {
            System.out.println("Pronto! Jogador 1 entre com sua palavra:");
            word = keyboard.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Jogador 2, Boa sorte!:");
        }


        //System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();

        int countWrongs = 0;

        while (true) {
            printOutHangMan(countWrongs);
            System.out.println();
            wordStatus(word, playerGuesses);

            if (countWrongs == 6) {
                System.out.println("Voce perdeu!");
                break;
            }

            userGuessLetter(keyboard, playerGuesses);

            if (wordStatus(word, playerGuesses)) {
                System.out.println("Voce ganhou!");
                break;
            }

            if (userGuessWord(keyboard, word)) {
                System.out.println("Voce ganhou!");
                break;
            } else {
                countWrongs++;
            }
        }
        System.out.println("A palavra era " + word);
        keyboard.close();
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
        System.out.println("Por favor tente chutar a palavra:");
        String playerGuess = keyboard.nextLine();
        if (word.equalsIgnoreCase(playerGuess)) {
            return true;
        } else {
            System.out.println("Nao, Tente novamente");
        }
        return false;
    }

    private static void userGuessLetter(Scanner keyboard, List<Character> playerGuesses) {
        System.out.println("Por favor entre uma letra: ");
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
