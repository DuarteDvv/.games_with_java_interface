package src.main.model;

import src.main.util.Autenticavel;

public class Diretor extends Funcionario implements Autenticavel {

    @Override
    public boolean autentica(int senha) {
        //
        return false;
    }
    
}
