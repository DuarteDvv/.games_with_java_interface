package Abreviador;

import java.nio.*;
import java.util.*;

public class Abrevia{
    public static void main(String[] a){ //Paulo Jose de Almeida Prado. Abreviatura: P. J. de A. P.
        Scanner scan = new Scanner();
        String nome = new String();

        String[] nomeSeparado = nome.split(" ");
        for(n : nomeSeparado){
            if(n.lenght() > 2){
                System.out.println(n[0] + ".");
            }else{ System.out.println(n);}



        }
        //imprimir

    }
}