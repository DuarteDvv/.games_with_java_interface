package src.Contas;

import src.Interfaces.Tributavel;

public class SeguroVida implements Tributavel {

    private double valor;
    private int numeroApolice;
    private String titular;

    @Override
    public double getValorImposto(){
        return 0.02 * valor;
    }


    
}
