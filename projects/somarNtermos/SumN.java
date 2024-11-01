package somarNtermos;

import java.util.Scanner;

// 1/1 – 1/2 + 1/3 – 1/4 + 1/5 – 1/6 + …

public class SumN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        double sum = 0;
        int signal = 1;

        for (int i = 1; i <= n; i++) {
            sum += signal * (1.0/i);
            signal = signal * -1;
        }

        System.out.println("A soma dos " + n + " primeiros termos da série é " + sum);

    }
}
