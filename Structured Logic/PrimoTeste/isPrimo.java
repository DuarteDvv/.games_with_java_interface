package PrimoTeste;
import java.util.Scanner;

public class isPrimo {
    private void isP(int a) {
        if (a == 1) {
            System.out.println("Não é primo");
            return;
        }

        for (int i = 2; i <= Math.sqrt(a); ++i) {
            if (a % i == 0) {
                System.out.println("Não é primo");
                return;
            }
        }

        System.out.println("É primo");
    }

    public static void main(String[] args) {
        isPrimo Pri = new isPrimo();
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Digite um número");
            int a = scan.nextInt();
            Pri.isP(a);
        }
    }
}
