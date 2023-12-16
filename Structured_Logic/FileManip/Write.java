package FileManip;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Write {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("Structured_Logic\\FileManip\\Dados.txt", true))) {
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

                salvarRegistro(dataOutputStream, nome, codigo, nota1, nota2);

                
                scanner.nextLine();
            }

            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void salvarRegistro(DataOutputStream dataOutputStream, String nome, int codigo, int nota1, int nota2) throws IOException {
        // Converter a String para um array de bytes
        byte[] nomeBytes = nome.getBytes("UTF-8");

        // Escrever o tamanho do nome como um inteiro
        dataOutputStream.writeInt(nomeBytes.length);

        // Escrever o nome como uma sequência de bytes
        dataOutputStream.write(nomeBytes);

        // Escrever o código e as notas como números inteiros
        dataOutputStream.writeInt(codigo);
        dataOutputStream.writeInt(nota1);
        dataOutputStream.writeInt(nota2);
    }
    
}
