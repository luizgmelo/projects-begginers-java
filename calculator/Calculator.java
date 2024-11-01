import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a number:");
            int firstNumber = scan.nextInt();
            System.out.print("Enter other number:");
            int secondNumber = scan.nextInt();
            scan.nextLine();
            System.out.print("Enter some operation (+,-,/,x):");
            String operation = scan.nextLine();

            switch (operation) {
                case "+":
                    System.out.println(firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber));
                    break;
                case "-":
                    System.out.println(firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber));
                    break;
                case "/":
                    System.out.println(firstNumber + " / " + secondNumber + " = " + (float)(firstNumber / secondNumber));
                    break;
                case "x":
                    System.out.println(firstNumber + " x " + secondNumber + " = " + (firstNumber * secondNumber));
                    break;
                default:
                    System.out.println("Invalid Operation");
            }

            System.out.print("Want close the program: (Y/N):");
            if (scan.nextLine().equalsIgnoreCase("Y")) {
                break;
            }
        }
    }
}
