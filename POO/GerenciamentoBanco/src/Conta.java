package src;


public class Conta
{


  private String titular;

  private int numero;

  private double saldo;

  private String dataEntrada;




  public Conta (String tit, int num, double sald, String datae)
  {
    titular = tit;
    numero = num;
    saldo = sald;
    dataEntrada = datae;
    
  }

  public boolean sacar (double sacado)
  {

    return (saldo - sacado) >= 0 ? (saldo -= sacado) == saldo : false;


  }


  public void depositar (double depositado)
  {

    saldo += depositado;

  }

  public double rendimentoMensal ()
  {

    return saldo * 0.1;

  }


  public String imprimeDados ()
  {
    return titular + " " + numero + " " + saldo + " " + dataEntrada;

  }



};
