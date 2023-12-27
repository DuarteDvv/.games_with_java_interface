package GerenciamentoBanco;

public class Conta {
    private:
        String titular;
        int numero;
        double saldo;
        String dataEntrada;

    public:

        boolean sacar(double sacado){
            saldo - sacado < 0 ? 
            return false : 
            saldo -= sacado; 
            return true;
        }

        void depositar(double depositado){
            saldo += depositado;
        }

        double rendimentoMensal(){
            return saldo*0.1;
        }

        String imprimeDados(){
            
        }


};