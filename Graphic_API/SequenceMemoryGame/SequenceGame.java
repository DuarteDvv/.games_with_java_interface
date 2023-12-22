package SequenceMemoryGame;

import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class SequenceGame extends JFrame {
    private int CurrentButton = 0;
    private int Quantidade = 1;
    private Random Rand = new Random();
    private JPanel GamePanel;
    private JButton A, B, C, D, E;
    private JButton[] Amostra;
    private ArrayList<JButton> MachineOrder = new ArrayList<>();

    SequenceGame() {
        setTitle("Sequence Memory Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener Action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton Button = (JButton) e.getSource();
                Button.setBackground(Color.GREEN);
                if (Button != MachineOrder.get(CurrentButton)) {
                    JOptionPane.showMessageDialog(null, "Sequência incorreta! Fim do Jogo.");
                    System.exit(0);
                } else {
                    CurrentButton++;
                    if (CurrentButton == Quantidade) {
                        // O jogador acertou toda a sequência
                        JOptionPane.showMessageDialog(null, "Sequência correta! Avançando para o próximo nível.");
                        Quantidade++;
                        StartGame();
                    }
                }

                Timer timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e2) {
                        Button.setBackground(Color.RED);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        };

        A = new JButton() {
            {
                setBackground(Color.red);
                addActionListener(Action);
                setEnabled(false);
            }
        };
        B = new JButton() {
            {
                setBackground(Color.red);
                addActionListener(Action);
                setEnabled(false);
            }
        };
        C = new JButton() {
            {
                setBackground(Color.red);
                addActionListener(Action);
                setEnabled(false);
            }
        };
        D = new JButton() {
            {
                setBackground(Color.red);
                addActionListener(Action);
                setEnabled(false);
            }
        };
        E = new JButton() {
            {
                setBackground(Color.red);
                addActionListener(Action);
                setEnabled(false);
            }
        };

        Amostra = new JButton[]{A, B, C, D, E};

        JLabel Nivel = new JLabel("SEU NIVEL ATUAL É \n >> " + Quantidade + " <<");

        // Use GridLayout para organizar os botões simetricamente
        GamePanel = new JPanel(new GridLayout(3, 2, 10, 10));

        GamePanel.add(A);
        GamePanel.add(B);
        GamePanel.add(C);
        GamePanel.add(D);
        GamePanel.add(E);
        GamePanel.add(Nivel);

        add(GamePanel);
        setVisible(true);
        StartGame();
    }

    public void StartGame() {
        CurrentButton = 0;
        MachineOrder.clear();

        for (int i = 0; i < Quantidade; i++) {
            JButton RandBt = Amostra[Rand.nextInt(5)];
            MachineOrder.add(RandBt);
        }

        for (JButton n : MachineOrder) {
            n.setBackground(Color.GREEN);
            Timer timer = new Timer(1600, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e2) {
                    n.setBackground(Color.RED);
                }
            });
            timer.setRepeats(false);
            timer.start();
        }

        ativarBotoes();
    }

    public void ativarBotoes() {
        A.setEnabled(true);
        B.setEnabled(true);
        C.setEnabled(true);
        D.setEnabled(true);
        E.setEnabled(true);
    }

    public void desativarBotoes() {
        A.setEnabled(false);
        B.setEnabled(false);
        C.setEnabled(false);
        D.setEnabled(false);
        E.setEnabled(false);
    }

    public static void main(String[] args) {
        new SequenceGame();
    }
}
