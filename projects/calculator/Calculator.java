package calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a number:");
            double firstNumber = scan.nextDouble();
            System.out.print("Enter other number:");
            double secondNumber = scan.nextDouble();
            System.out.print("Enter some operation (+,-,/,x):");
            char operation = scan.next().charAt(0);
            double result;

            switch (operation) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '/':
                    result = firstNumber / secondNumber;
                    break;
                case 'x':
                    result = firstNumber * secondNumber;
                    break;
                default:
                    System.out.println("Invalid Operation");
                    continue;
            }

            System.out.println(firstNumber+" "+operation+" "+secondNumber+" = "+result);

            System.out.print("Want close the program: (Y/N):");
            char wantClose = scan.next().charAt(0);
            if (wantClose == 'Y' || wantClose == 'y') {
                scan.close();
                break;
            }
        }
    }
}
