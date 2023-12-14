package Abreviador;

import java.util.*;

public class Abrevia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome completo:");
        String nome = scan.nextLine();
        scan.close();

        String[] nomeSeparado = nome.split(" ");
        for (String n : nomeSeparado) {
            if (n.length() > 2) {
                System.out.print(Character.toUpperCase(n.charAt(0)) + ". ");
            } else {
                System.out.print(n + " ");
            }
        }
    }
}
