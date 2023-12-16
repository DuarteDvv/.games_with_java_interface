package Graphic_API.Reflex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Swing_Reflex extends JFrame {

    private JPanel painel;
    private Timer timer;
    private long tempoInicial;
    private int x, y; // Adicionando variáveis x e y

    public Swing_Reflex() {
        setTitle("Medidor de Reflexos");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Desenha um alvo (círculo) em uma posição aleatória
                x = new Random().nextInt(getWidth() - 50);
                y = new Random().nextInt(getHeight() - 50);

                g.setColor(Color.RED);
                g.fillOval(x, y, 50, 50);

                // Registra o tempo de exibição do alvo
                tempoInicial = System.currentTimeMillis();
            }
        };

        // Adiciona um ouvinte de clique do mouse
        painel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Calcula o tempo decorrido ao clicar
                double tempoDecorrido = System.currentTimeMillis() - tempoInicial;

                // Mostra o tempo decorrido ou uma mensagem de erro
                if (e.getX() >= x && e.getX() <= x + 50 && e.getY() >= y && e.getY() <= y + 50) {
                    JOptionPane.showMessageDialog(Swing_Reflex.this, "Você acertou! Tempo decorrido: " + tempoDecorrido/1000 + "s");
                } else {
                    JOptionPane.showMessageDialog(Swing_Reflex.this, "Você errou! Tente novamente.");
                }

                // Reinicia o timer para exibir o próximo alvo
                iniciarTimer();
            }
        });

        add(painel);

        // Inicia o timer para exibir o primeiro alvo
        iniciarTimer();

        setVisible(true);
    }

    private void iniciarTimer() {
        // Configura um timer para exibir um novo alvo após um intervalo de tempo aleatório
        int intervalo = 1000 + new Random().nextInt(2000); // Intervalo entre 1 e 3 segundos
        timer = new Timer(intervalo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painel.repaint(); // Redesenha o painel para exibir um novo alvo
            }
        });
        timer.setRepeats(false); // Apenas um disparo único
        timer.start();
    }

    public static void main(String[] args) {
        new Swing_Reflex();
    }
}
