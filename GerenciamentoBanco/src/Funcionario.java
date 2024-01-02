package src;

public abstract class Funcionario {
    private String nome;
    private String cpf;
    private double salario;

    private static int numeroDeFuncionarios;

    public static int getNFuncionarios(){
        return numeroDeFuncionarios;
    }
    
}
