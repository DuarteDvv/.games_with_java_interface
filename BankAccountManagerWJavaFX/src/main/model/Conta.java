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

  public Conta(String tit){

    titular = tit;
    saldo = 0;
    numeroDeContas++;
    identificador = numeroDeContas;
  }

  public Conta (String tit, double sald){
    
    titular = tit;
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
    return String.format("%s %i %2.f %s",titular + " || " + numero + " || " + saldo + " || " + dataEntrada);
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
    return this.titular.compareTo(outraConta.titular);  // 1

  }

  private int getNumero(){
    return numero;
  }
  
  public static Comparator<Conta> comparadorPorNumero = Comparator.comparing(Conta::getNumero); // 2

  public Comparator<Conta> comparadorPorNumero2 = new Comparator<>(){  // 3
    public int compare(Conta c1,Conta c2 ){
      return Integer.compare(c1.numero, c2.numero);
    }
  };

  public int comparadorPorNumero3(List<Conta> list){  // 4
    list.sort((c1,c2) -> { return Integer.compare(c1.numero, c2.numero);});
  }

 

  public abstract String getTipoDeConta();



};
