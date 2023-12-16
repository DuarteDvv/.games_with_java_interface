package FileManip;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteText {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        try (PrintWriter printWriter = new PrintWriter(new FileWriter("Structured_Logic\\FileManip\\Dados.txt"))) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Informe os dados do aluno " + i + ":");

                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Código: ");
                int codigo = scanner.nextInt();

                System.out.print("Nota Bimestral 1: ");
                int nota1 = scanner.nextInt();

                System.out.print("Nota Bimestral 2: ");
                int nota2 = scanner.nextInt();

                salvarRegistro(printWriter, nome, codigo, nota1, nota2);

                // Limpar o buffer após a leitura do inteiro para evitar problemas
                scanner.nextLine();
            }

            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void salvarRegistro(PrintWriter printWriter, String nome, int codigo, int nota1, int nota2) {
        printWriter.println("Nome: " + nome);
        printWriter.println("Código: " + codigo);
        printWriter.println("Nota Bimestral 1: " + nota1);
        printWriter.println("Nota Bimestral 2: " + nota2);
        printWriter.println(); // Adicionar uma linha em branco para separar os registros
    }
    
}
