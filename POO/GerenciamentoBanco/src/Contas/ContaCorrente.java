package src.Contas;

import src.Interfaces.Tributavel;

public class ContaCorrente extends Conta implements Tributavel {
    
    @Override
    public double getValorImposto(){
        return 0.01 * super.saldo;
    }

    @Override
    public boolean sacar (double sacado){
        return (super.saldo - sacado - 0.10) >= 0 ? (super.saldo -= sacado + 0.10) == super.saldo : false;
    }

    @Override
    public String getTipoDeConta(){
        return  "Conta Corrente";
    }
}