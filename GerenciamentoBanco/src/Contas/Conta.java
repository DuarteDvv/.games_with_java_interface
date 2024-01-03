package src.Contas;

import java.util.Comparator;

import src.Data;

public abstract class Conta implements Comparable<Conta>{
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
    sacar(valor);
    destino.depositar(valor);
  }

  public void sacar (double sacado){

    if((saldo - sacado) >= 0){ 
      saldo -= sacado;
    }
    else if(sacado < 0){
      throw new IllegalArgumentException("Erro, saque negativo");

    }
    else{
      throw new IllegalArgumentException("Erro, saldo insuficiente");
    }
  }


  public void depositar (double depositado){
    if(depositado < 0){
      throw new IllegalArgumentException("Erro, deposito negativo");
    }
    saldo += depositado;
  }

  public double rendimentoMensal (){
    return saldo * 0.1;
  }

  @Override
  public String toString(){
    return String.format("%s %i %2.f %s",titular + " " + numero + " " + saldo + " " + dataEntrada);
  }

  @Override
  public boolean equals(Object object){
    if(object == null){
      return false;
    }

    if(!(object instanceof Conta)){
      return false;
    }

    Conta conta = (Conta) object;
    return (this.agencia == conta.agencia && this.numero == conta.numero) ;

  }

  @Override
  public int compareTo(Conta outraConta){
    return this.titular.compareTo(outraConta.titular);

  }

  public static Comparator<Conta> ComparadorPorNumero = Comparator.comparing(Conta::getNumero);

  private int getNumero(){
    return numero;
  }

  public abstract String getTipoDeConta();



};
