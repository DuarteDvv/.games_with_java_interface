package src.Contas;

public class ContaPoupança extends Conta{

    @Override
    public boolean sacar (double sacado){
        return (super.saldo - sacado) >= 0 ? (super.saldo -= sacado) == super.saldo : false;
    }
    @Override
    public String getTipoDeConta(){
        return "Conta Poupança";
    }

}