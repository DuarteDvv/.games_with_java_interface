package src;

import src.Interfaces.Autenticavel;

public class Diretor extends Funcionario implements Autenticavel {

    @Override
    public boolean autentica(int senha) {
        //
        return false;
    }
    
}
