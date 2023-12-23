package CardMemoryGame;

import java.util.*;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;


public class CardGame extends JFrame{



    CardGame(){
        setTitle("MemoryCard");
        setSize(500,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        
















        JPanel Base = new JPanel();
        add(Base);

    }

    public void TelaInicial(){
        
        JButton Facil = new JButton();
        JButton Medio = new JButton();
        JButton Dificil = new JButton();

        ActionListener Selecao = new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e){
                    switch((JButton) e.getSource()){
                        case Facil:

                        case Medio:

                        case Dificil:                
                    }

                    

                }
            
        };

        JPanel Dificuldade = new JPanel(new FlowLayout()) {
            {
                add(Facil);
                add(Medio);
                add(Dificil);
            }
        };//Nivel  1 - 4x3 Nivel 2 - 4x4 Nivel 3 - 5x4


    }   



    public static void main(String[] args) {
        new CardGame();
    }
}
