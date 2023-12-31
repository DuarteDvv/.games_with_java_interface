package src.Contas;

import src.Data;

public abstract class Conta{
  private static int numeroDeContas = 0;

  protected String titular;

  protected String agencia;

  protected int numero;

  protected double saldo;

  protected Data dataEntrada;
  
  protected int identificador;


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
      System.out.println("Erro, saldo insuficiente");
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

  public abstract String getTipoDeConta();



};
