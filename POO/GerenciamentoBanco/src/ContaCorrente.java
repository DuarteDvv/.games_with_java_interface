package src;

public class ContaCorrente extends Conta{

    @Override
    public boolean sacar (double sacado){
        return (saldo - sacado - 0.10) >= 0 ? (saldo -= sacado + 0.10) == saldo : false;
    }
    @Override
    public String getTipoDeConta(){
        return super.getTipoDeConta() + "Corrente";
    }
}