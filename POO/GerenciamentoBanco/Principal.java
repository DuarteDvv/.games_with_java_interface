package GerenciamentoBanco;

import src.*;

public class Main 
{
    public static void main(String[] args){
        Conta a = new Conta("Luis", 12, 0,"27/2/2032");
        
        System.out.println(a.imprimeDados());
    }
}