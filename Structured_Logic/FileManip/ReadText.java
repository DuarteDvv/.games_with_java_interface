package FileManip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {
    public static void main(String[] args){
       try (BufferedReader Reader = new BufferedReader(new FileReader("Structured_Logic\\FileManip\\Dados.txt"))) {
            int totalAlunos = 0;
            int aprovados = 0;
            int exame = 0;
            int reprovados = 0;
            int somaNotas = 0;
            int nota1 =0;
            int nota2 =0;

            String line;
            while ((line = Reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];

                    switch (key) {
                        case "Nome":
                            System.out.println("Aluno: " + value);
                            break;
                        case "Código":
                            int codigo = Integer.parseInt(value);
                            System.out.println("Código: " + codigo);
                            break;
                        case "Nota Bimestral 1":
                            nota1 = Integer.parseInt(value);
                            
                            System.out.println("Nota 1: " + nota1);
                            break;
                        case "Nota Bimestral 2":
                            nota2 = Integer.parseInt(value);
                            System.out.println("Nota 2: " + nota2);

                            final int media = (nota1 + nota2) / 2;
                            somaNotas += media;

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
                            break;
                    }
                }
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
