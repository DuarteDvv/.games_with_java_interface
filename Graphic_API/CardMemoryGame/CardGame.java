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
    private int finalizar = 0;
    private int mark = 0;
    private int cartas;
    private JButton ultimoButton = null;
    private Map<JButton,Color> mapaDeBotoes = new HashMap<>();
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
                cartas = 12;
                break;
            case 1:
                cartas = 16;
                break;
            case 2:
                cartas = 20;
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

                if(ultimoButton == null){
                    CurrentButton.setBackground(mapaDeBotoes.get(CurrentButton));
                    ultimoButton = CurrentButton;
                    
                    //Deixa cor mostrando
                }
                else{
                    if(mapaDeBotoes.get(CurrentButton) == mapaDeBotoes.get(ultimoButton)){
                        CurrentButton.setBackground(mapaDeBotoes.get(CurrentButton));
                        finalizar += 2;
                        //deixa ambas as cores mostrando
                        ultimoButton = null;

                        if (finalizar == cartas ) {
                            JOptionPane.showMessageDialog(CardGame.this, "Parabéns! Você concluiu o jogo!");
                            Timer waiting = new Timer(750, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent a){
                                    System.exit(0);
                                }
                            });

                            waiting.setRepeats(false);
                            waiting.start();
                           
                        }
                    }
                    else{
                        CurrentButton.setBackground(mapaDeBotoes.get(CurrentButton));
                        Timer waiting = new Timer(500, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent a){
                                CurrentButton.setBackground(null);
                                ultimoButton.setBackground(null);
                                ultimoButton = null;
                            }
                        });

                        waiting.setRepeats(false);
                        waiting.start();

                    }
                }

            }
        };

        for(int i = 0; i < cartas/2 ;i++){
            Color CurrentColor = geradorDeCor(cartas/2);

            mapaDeBotoes.put(new JButton(){ {addActionListener(Action); } }, CurrentColor);
            mapaDeBotoes.put(new JButton(){ {addActionListener(Action); } }, CurrentColor);  
        }

        JPanel Base = new JPanel(){
            {
                switch(cartas) {
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

                for(Map.Entry<JButton,Color> Mapa : mapaDeBotoes.entrySet()){
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
        int index = rand.nextInt(q-mark);
        mark++;
        Color cor = paleta.get(index);
        paleta.remove(index);

        return cor;
    }


    public static void main(String[] args) {
        new CardGame();
    }
}