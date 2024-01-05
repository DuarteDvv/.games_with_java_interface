package src.Contas;

public class ContaPoupança extends Conta{

    @Override
    public void sacar (double sacado){

        if((super.saldo - sacado) >= 0){ 
          super.saldo -= sacado;
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
        return "Conta Poupança";
    }

}