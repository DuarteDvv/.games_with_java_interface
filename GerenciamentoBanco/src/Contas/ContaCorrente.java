package src.Contas;

import src.Interfaces.Tributavel;

public class ContaCorrente extends Conta implements Tributavel {
    
    @Override
    public double getValorImposto(){
        return 0.01 * super.saldo;
    }

    @Override
    public void sacar (double sacado){

        if((super.saldo - sacado - 0.10) >= 0){ 
          super.saldo -= sacado - 0.10;
          }
        else if(sacado < 0){
          throw new IllegalArgumentException("Erro, saque negativo");
    
        }
        else{
          throw new IllegalArgumentException("Erro, saldo insuficiente");
        }
      }

    @Override
    public String getTipoDeConta(){
        return  "Conta Corrente";
    }
}