package loginSystem;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "admin";
        String password = "123";

        System.out.print("Username:");
        String usernameField = scanner.nextLine();
        System.out.print("Password:");
        String passwordField = scanner.nextLine();
        scanner.close();

        if (usernameField.equals(username) && passwordField.equals(password)) {
            System.out.println("Welcome! Login successfully");
        } else {
            System.out.println("Wrong Username or Password");
        }
    }
}
