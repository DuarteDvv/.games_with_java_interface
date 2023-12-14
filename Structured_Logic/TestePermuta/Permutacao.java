package TestePermuta;
import java.util.Arrays;
import java.util.Scanner;

public class Permutacao {

    private boolean isPermuta(int a, int b) {
        // Converter para strings 
        String A = Integer.toString(a);
        String B = Integer.toString(b);

        // Remover todos os zeros
        A = A.replaceAll("0", "");
        B = B.replaceAll("0", "");

        // Verificar se o tamanho das strings é o mesmo
        if (A.length() != B.length()) {
            return false;
        }

        // Transformar strings em arrays de caracteres e ordenar
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        // Comparar os arrays de caracteres ordenados
        return Arrays.equals(arrA, arrB);
    }

    public static void main(String[] args) {
        Permutacao P = new Permutacao();
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite dois números para verificar se são permutações:");
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.close();

        if (P.isPermuta(a, b)) {
            System.out.println("É permutação");
        } else {
            System.out.println("Não é permutação");
        }
    }
}
