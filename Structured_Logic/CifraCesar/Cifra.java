package CifraCesar;

import java.util.Scanner;

public class Cifra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a frase:");
        String frase = scan.nextLine();

        System.out.println("Digite o valor de K (o deslocamento):");
        int k = scan.nextInt();

        scan.close();
        
        frase = frase.replaceAll(" ", "");

        char[] f = frase.toCharArray();


        for (int i = 0; i < f.length; i++) {
           
            if (Character.isLetter(f[i])) {
                f[i] = Character.toLowerCase(f[i]);
            }
            f[i] = (char) ((int) f[i] + k);
        }

        String fraseCodificada = new String(f);

        System.out.println("Frase codificada: " + fraseCodificada);
    }
}
