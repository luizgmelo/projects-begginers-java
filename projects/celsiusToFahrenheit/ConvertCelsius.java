package celsiusToFahrenheit;

import java.util.Scanner;

public class ConvertCelsius {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Degree Celsius:");
        double celsius = scanner.nextDouble();
        scanner.close();
        double fahrenheit = celsius * 1.8 + 32;
        System.out.println("F°="+fahrenheit);
    }
}
