package FileManip;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Read {
    public static void main(String[] args){
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("Structured_Logic\\FileManip\\Dados.txt"))) {
            int totalAlunos = 0;
            int aprovados = 0;
            int exame = 0;
            int reprovados = 0;
            int somaNotas = 0;

            while (dataInputStream.available() > 0) {
                int tamanhoNome = dataInputStream.readInt();

                byte[] nomeBytes = new byte[tamanhoNome];
                dataInputStream.readFully(nomeBytes);
                String nome = new String(nomeBytes, "UTF-8");

                int codigo = dataInputStream.readInt();
                int nota1 = dataInputStream.readInt();
                int nota2 = dataInputStream.readInt();

                int media = (nota1 + nota2) / 2;
                somaNotas += media;

                System.out.println("Aluno: " + nome);
                System.out.println("Código: " + codigo);
                System.out.println("Nota 1: " + nota1);
                System.out.println("Nota 2: " + nota2);
                System.out.println("Média: " + media);

                if (media >= 7) {
                    System.out.println("Situação: Aprovado\n");
                    aprovados++;
                } else if (media >= 4) {
                    System.out.println("Situação: Exame\n");
                    exame++;
                } else {
                    System.out.println("Situação: Reprovado\n");
                    reprovados++;
                }

                totalAlunos++;
            }

            double mediaTurma = (double) somaNotas / totalAlunos;

            System.out.println("Estatísticas:");
            System.out.println("Total de alunos: " + totalAlunos);
            System.out.println("Aprovados: " + aprovados);
            System.out.println("Em exame: " + exame);
            System.out.println("Reprovados: " + reprovados);
            System.out.println("Média da turma: " + mediaTurma);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
    

