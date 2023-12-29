package src;

public class ContaPoupança extends Conta{

    @Override
    public boolean sacar (double sacado){
        return (saldo - sacado) >= 0 ? (saldo -= sacado) == saldo : false;
    }
    @Override
    public String getTipoDeConta(){
        return super.getTipoDeConta() + "Poupança";
    }

}