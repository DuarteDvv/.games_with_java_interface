package CardMemoryGame;

import java.util.*;
import javax.swing.*;
import java.awt.event.*


public class CardGame extends Jframe{



    CardGame(){
        setTitle("MemoryCard");
        setSize(500,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Jpanel Dificuldade = new Jpanel();
















        Jpanel Base = new Jpanel();
        add(Base);

    }



    public static void main(String[] args) {
        new CardGame();
    }
}
