package src.main.model;

import java.util.Comparator;

import src.Data;

public abstract class Conta implements Comparable<Conta>{
  private static int numeroDeContas = 0;

  protected String titular;

  protected String agencia;

  protected int numero;

  private double saldo;

  protected Data dataEntrada;
  
  protected int identificador;


  public static int getNContas(){
    return Conta.numeroDeContas;
  }

  protected void setSaldo(double newSaldo){
    saldo = newSaldo;
  }
  
  protected double getSaldo(){
    return saldo;

  }

  
  public void transfere(Conta destino, double valor){
    sacar(valor);
    destino.depositar(valor);
  }

  public void sacar (double sacado){

    if(sacado <= 0){ 
      throw new IllegalArgumentException("Saque invalido");
      
    }
    else if((getSaldo() - sacado) < 0){
      throw new IllegalArgumentException("Saldo insuficiente");
    }
    else{
      setSaldo(getSaldo() - sacado);
    }
  }


  public void depositar (double depositado){
    if(depositado <= 0){
      throw new IllegalArgumentException("Deposito invalido");
    }
    
    setSaldo(getSaldo() + depositado);
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
    return this.titular.compareTo(outraConta.titular);  //

  }

  public Comparator<Conta> comparadorPorNumero = new Comparator<>(){ 
    public int compare(Conta c1,Conta c2 ){
      return Integer.compare(c1.numero, c2.numero);
    }
  };

  /* public Comparator<Conta> comparadorPorData = new Comparator<>(){ 
    public int compare(Conta c1,Conta c2 ){
      return 
    }
  };
  */

  public abstract String getTipoDeConta();



};
