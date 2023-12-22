package SequenceMemoryGame;

import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SequenceGame extends JFrame {
    private int currentButton = 0;
    private int quantidade = 1;
    private Random rand = new Random();
    private JPanel gamePanel;
    private JButton A, B, C, D, E;
    private JButton[] amostra;
    private List<JButton> machineOrder = new ArrayList<>();
    private JLabel nivelLabel;

    SequenceGame() {
        setTitle("Sequence Memory Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(Color.GREEN);

                if (button != machineOrder.get(currentButton)) {
                    JOptionPane.showMessageDialog(null, "Sequência incorreta! Fim do Jogo.");
                    System.exit(0);
                } else {
                    currentButton++;
                    if (currentButton == quantidade) {
                        JOptionPane.showMessageDialog(null, "Sequência correta! Avançando para o próximo nível.");
                        quantidade++;
                        nivelLabel.setText("VOCÊ ESTÁ NO NÍVEL >> " + quantidade + " <<");
                        startGame();
                    }
                }

                Timer timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e2) {
                        button.setBackground(Color.RED);
                        if (currentButton == 0) {
                            executeMachineOrder();
                        }
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        };

        A = new JButton();
        B = new JButton();
        C = new JButton();
        D = new JButton();
        E = new JButton();

        amostra = new JButton[]{A, B, C, D, E};

        nivelLabel = new JLabel();
        nivelLabel.setText("VOCÊ ESTÁ NO NÍVEL >> " + quantidade + " <<");

        gamePanel = new JPanel(new GridLayout(3, 2, 10, 10));

        for (JButton button : amostra) {
            button.setBackground(Color.RED);
            button.addActionListener(action);
            button.setEnabled(false);
            gamePanel.add(button);
        }

        gamePanel.add(nivelLabel);

        add(gamePanel);
        setVisible(true);
        startGame();
    }

    private void executeMachineOrder() {
        SwingWorker<Void, JButton> worker = new SwingWorker<Void, JButton>() {
            @Override
            protected Void doInBackground() throws Exception {
                desativarBotoes();
                Thread.sleep(1000);

                for (JButton button : machineOrder) {
                    button.setBackground(Color.GREEN);
                    publish(button);
                    Thread.sleep(1000);
                    button.setBackground(Color.RED);
                    Thread.sleep(500);
                }
                return null;
            }

            @Override
            protected void process(List<JButton> chunks) {
                for (JButton button : chunks) {
                    button.setBackground(Color.GREEN);
                }
            }

            @Override
            protected void done() {
                ativarBotoes();
            }
        };

        worker.execute();
    }

    public void startGame() {
        currentButton = 0;
        machineOrder.clear();

        for (int i = 0; i < quantidade; i++) {
            JButton randButton = amostra[rand.nextInt(5)];
            machineOrder.add(randButton);
        }

        executeMachineOrder();
    }

    public void ativarBotoes() {
        for (JButton button : amostra) {
            button.setEnabled(true);
        }
    }

    public void desativarBotoes() {
        for (JButton button : amostra) {
            button.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new SequenceGame();
    }
}
