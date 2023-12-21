package Reflex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Swing_Reflex extends JFrame {

    private JPanel startPanel;
    private JPanel gamePanel;
    private Timer timer;
    private long ultimoClique;
    private int x, y;
    private final int alvoSize = 50; // Tamanho do alvo
    private int dificuldade; // 1 - Fácil, 2 - Médio, 3 - Difícil

    public Swing_Reflex() {
        setTitle("Reflex Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString("Escolha a dificuldade: 1 - Fácil, 2 - Médio, 3 - Difícil", 100, 200);
            }
        };

        startPanel.setFocusable(true);
        startPanel.requestFocusInWindow();
        startPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '1' || e.getKeyChar() == '2' || e.getKeyChar() == '3') {
                    dificuldade = Integer.parseInt(String.valueOf(e.getKeyChar()));
                    iniciarJogo();
                }
            }
        });

        add(startPanel);

        setVisible(true);
    }

    private void iniciarJogo() {
        remove(startPanel);

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Desenha o alvo na posição atual
                g.setColor(Color.RED);
                g.fillOval(x, y, alvoSize, alvoSize);
            }
        };

        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double distancia = calcularDistancia(e.getX(), e.getY(), x + alvoSize / 2, y + alvoSize / 2);

                mostrarComentario(distancia);

                long tempoDecorrido = System.currentTimeMillis() - ultimoClique;
                JOptionPane.showMessageDialog(Swing_Reflex.this, "Tempo decorrido: " + tempoDecorrido + "ms");

                // Registra o tempo do último clique
                ultimoClique = System.currentTimeMillis();

                // Verifica se o timer está em execução antes de reiniciá-lo
                if (timer == null || !timer.isRunning()) {
                    iniciarTimer();
                }
            }
        });

        add(gamePanel);

        // Inicia o timer para exibir o primeiro alvo
        iniciarTimer();

        setVisible(true);
    }

    private void iniciarTimer() {
        ultimoClique = System.currentTimeMillis();

        // Define a dificuldade com base na velocidade de variação da posição do alvo
        int delay;
        switch (dificuldade) {
            case 1:
                delay = getRandomDelay(1000, 1500); // Fácil (entre 1.0 s e 1.5 s)
                break;
            case 2:
                delay = getRandomDelay(700, 1100); // Médio (entre 0.7 s e 1.1 s)
                break;
            case 3:
                delay = getRandomDelay(500, 900); // Difícil (entre 0.5 s e 1.2 s)
                break;
            default:
                delay = getRandomDelay(1000, 1500); // Valor padrão (entre 1.0 s e 1.5 s)
        }

        // Configura um timer apenas se não estiver em execução
        if (timer == null || !timer.isRunning()) {
            // Configura um timer para atualizar a posição do alvo
            timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Atualiza a posição do alvo aleatoriamente
                    x = new Random().nextInt(gamePanel.getWidth() - alvoSize);
                    y = new Random().nextInt(gamePanel.getHeight() - alvoSize);

                    // Redesenha o painel para exibir o alvo na nova posição
                    gamePanel.repaint();
                }
            });
            timer.setRepeats(true); // Repetição automática
            timer.start();
        }
    }

    private void mostrarComentario(double distancia) {
        String comentario;

        if (distancia < alvoSize / 4) {
            comentario = "Sensacional!";
        } else if (distancia < alvoSize / 2) {
            comentario = "Ótimo!";
        } else if (distancia < alvoSize) {
            comentario = "Bom!";
        } else {
            comentario = "Você errou!";
        }

        JOptionPane.showMessageDialog(Swing_Reflex.this, comentario);
    }

    private double calcularDistancia(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private int getRandomDelay(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Swing_Reflex();
        });
    }
}
