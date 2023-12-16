package Palpite;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class palpiteExcep {
    static int trys = 0;
    static int random = (int) (Math.random() * 1001);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        jogo: while (true) {
            try {
                int guess = readGuess(scan);
                checkGuess(guess);
                break jogo; 
            } 
            catch (MaiorQueException e) {
                System.out.println("Tente novamente! O número é maior.");
            } 
            catch (MenorQueException e) {
                System.out.println("Tente novamente! O número é menor.");
            }
        }

        scan.close();
        System.out.println("Parabéns, acertou com " + trys + " trys");
    }

    static int readGuess(Scanner scan) {
        System.out.println("Digite o seu palpite:");
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                scan.nextLine(); 
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    static void checkGuess(int guess) throws MaiorQueException, MenorQueException {
        trys++;
        if (guess < random) {
            throw new MaiorQueException();
        } else if (guess > random) {
            throw new MenorQueException();
        }
       
    }
}

class MaiorQueException extends Exception {}

class MenorQueException extends Exception {}
