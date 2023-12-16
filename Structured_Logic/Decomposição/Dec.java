package Decomposição;

import java.util.*;

public class Dec {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numero = scan.nextInt();
        int save = numero;
        int quantidade = 0;
        int divisor = 2;

        if (numero == 1 || numero == 0) {
            System.out.println(quantidade);
        } else {
            while (numero != 1) {
                if (numero % divisor == 0) {
                    numero = numero / divisor;
                    quantidade++;
                } else {
                    divisor++;
                }
            }

            int[] array = new int[quantidade];
            quantidade = 0;
            divisor = 2;

            while (save != 1) {
                if (save % divisor == 0) {
                    save = save / divisor;
                    array[quantidade] = divisor;
                    quantidade++;
                } else {
                    divisor++;
                }
            }

            // Print the prime factors
            System.out.print("Prime factors: ");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }

        scan.close();
    }
}
