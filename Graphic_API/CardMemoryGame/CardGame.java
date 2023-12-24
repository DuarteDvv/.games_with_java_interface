package CardMemoryGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CardGame extends JFrame {

    private int Mark = 0;
    private int Cartas;
    private JButton UltimoButton = null;
    private Map<JButton,Color> MapaDeBotoes = new HashMap<>();
    private ArrayList<Color> paleta = new ArrayList<>();

    CardGame() {
        setTitle("MemoryCard");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

        escolherDificuldade();
        PreencherPaleta();
        iniciarJogo();

    }

    public void escolherDificuldade() {
        Object[] options = {"Easy", "Medium", "Hard"};
        int escolha = JOptionPane.showOptionDialog(this,"Escolha a dificuldade:","Escolha de Dificuldade",JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

        switch (escolha) {
            case 0:
                Cartas = 12;
                break;
            case 1:
                Cartas = 16;
                break;
            case 2:
                Cartas = 20;
                break;
            default:
                System.exit(0);
        }
    }

    public void iniciarJogo() {

        ActionListener Action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JButton CurrentButton = (JButton) e.getSource();
                //mostra cor

                if(UltimoButton == null){
                    CurrentButton.setBackground(MapaDeBotoes.get(CurrentButton));
                    UltimoButton = CurrentButton;
                    
                    //Deixa cor mostrando
                }
                else{
                    if(CurrentButton.getBackground() == UltimoButton.getBackground()){
                        CurrentButton.setBackground(MapaDeBotoes.get(CurrentButton));
                        //deixa ambas as cores mostrando
                        UltimoButton = null;
                    }
                    else{
                        UltimoButton.setBackground(null);
                        CurrentButton.setBackground(MapaDeBotoes.get(CurrentButton));
                        

                        CurrentButton.setBackground(null);
                        //esconde cor de ambos
                        UltimoButton = null;

                    }
                }

            }
        };

        for(int i = 0; i < Cartas/2 ;i++){
            Color CurrentColor = geradorDeCor(Cartas/2);

            MapaDeBotoes.put(new JButton(){ {addActionListener(Action);} }, CurrentColor);
            MapaDeBotoes.put(new JButton(){ {addActionListener(Action);} }, CurrentColor);  
        }

        JPanel Base = new JPanel(){
            {
                switch(Cartas) {
                    case 12:
                        setLayout(new GridLayout(4,3));
                        break;
                    case 16:
                        setLayout(new GridLayout(4,4));
                        break;
                    case 20:
                        setLayout(new GridLayout(4,5));
                        break;
                }

                for(Map.Entry<JButton,Color > Mapa : MapaDeBotoes.entrySet()){
                    add(Mapa.getKey());
                }
            }
        };

        add(Base);
        setVisible(true);
        
    }



    public void PreencherPaleta(){
        paleta.add(Color.BLACK);
        paleta.add(Color.BLUE);
        paleta.add(Color.GREEN);
        paleta.add(Color.CYAN);
        paleta.add(Color.MAGENTA);
        paleta.add(Color.ORANGE);
        paleta.add(Color.PINK);
        paleta.add(Color.RED);
        paleta.add(Color.YELLOW);
        paleta.add(Color.DARK_GRAY);
    }

   public Color geradorDeCor(int q) {
       
        Random rand = new Random();
        int index = rand.nextInt(q-Mark);
        Mark++;
        Color cor = paleta.get(index);
        paleta.remove(index);

        return cor;
    }


    public static void main(String[] args) {
        new CardGame();
    }
}