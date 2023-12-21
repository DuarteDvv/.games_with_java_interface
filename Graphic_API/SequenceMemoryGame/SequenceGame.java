
package SequenceMemoryGame;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.*;

public class SequenceGame extends JFrame {

    private int Quantidade = 1;
    private Random Rand;
    private JPanel Panel;
    private JButton A,B,C,D,E;
    private ArrayList<JButton> MachineOrder = new ArrayList<>();
    private ArrayList<JButton> UserClicks = new ArrayList<>();

    SequenceGame(){
        setTitle("Sequence Memory Game");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        


        ActionListener Action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                UserClicks.add((JButton) e.getSource());
            }
        };

        A = new JButton() {
            {
            addActionListener(Action);
            }
            
        };

        B = new JButton() {
            {
            addActionListener(Action);
            }
            
        };

        C = new JButton() {
            
            {
            addActionListener(Action);
            }

        };

        D = new JButton() {
            
            {
            addActionListener(Action);
            }

        };

        E = new JButton() {
            
        
            {
            addActionListener(Action);
            }
            
        };

        
        
        Panel = new JPanel();

        Panel.add(A);
        Panel.add(B);
        Panel.add(C);
        Panel.add(D);
        Panel.add(E);

        add(Panel);
        setVisible(true);
    }


    public static void main(String[] args){
        new SequenceGame();
    }
    
}
