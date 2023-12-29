package src;


public class Conta{
  private static int numeroDeContas = 0;

  private String titular;

  private String agencia;

  private int numero;

  private double saldo;

  private Data dataEntrada;
  
  private int identificador;


  public static int getNContas(){
    return Conta.numeroDeContas;
  }

  public Conta(){
    numeroDeContas++;
    identificador = numeroDeContas;
  }

  public Conta (String tit, int num, double sald){
    
    titular = tit;
    numero = num;
    saldo = sald;

    numeroDeContas++;
    identificador = numeroDeContas;
  }
  
  public void transfere(Conta destino, double valor){
    if(sacar(valor)){
      destino.depositar(valor);

    }
    else{
      System.out.Println("Erro, saldo indisponivel");
    }
    

  }
  public boolean sacar (double sacado){
    return (saldo - sacado) >= 0 ? (saldo -= sacado) == saldo : false;
  }


  public void depositar (double depositado){
    saldo += depositado;
  }

  public double rendimentoMensal (){
    return saldo * 0.1;
  }


  public String imprimeDados (){
    return titular + " " + numero + " " + saldo + " " + dataEntrada;

  }

  public String getTipoDeConta(){
    return "Conta";

  }



};
