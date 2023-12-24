package Conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Converter extends JFrame {

    private boolean PadrãoDeCalc = true;
    private JPanel PainelInicial;
    private JTextField Entrada, Saida;
    private JButton inverte, calcular;
    private JLabel tipoConversaoLabel;

    public Converter() {
        setTitle("Conversor Int <-> Dec");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Entrada = new JTextField();
        Entrada.setPreferredSize(new Dimension(150, 30));
        Saida = new JTextField() {
            {
                setText("Resultado");
                setEditable(false);
            }
        };
        Saida.setPreferredSize(new Dimension(150, 30));

        tipoConversaoLabel = new JLabel("Decimal >>> Binário");

        inverte = new JButton("INVERTER") {
            {
                setPreferredSize(new Dimension(150, 50));
            }
        };
        calcular = new JButton("CALCULAR") {
            {
                setPreferredSize(new Dimension(150, 50));
            }
        };

        // Ação ao botão "calcular"
        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarConversao();
            }
        });

        // Ação ao botão "inverte"
        inverte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Saida.setText("Resultado");
                Entrada.setText("");
                PadrãoDeCalc = !PadrãoDeCalc;
                tipoConversaoLabel.setText(PadrãoDeCalc ? "Decimal >>> Binário" : "Binário >>> Decimal");
            }
        });

        // Deixa já "Clicada"
        Entrada.requestFocus();
        Entrada.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    realizarConversao();
                }
            }

           
        });

        PainelInicial = new JPanel(new FlowLayout(FlowLayout.LEFT,20,20));
        PainelInicial.add(Entrada);
        PainelInicial.add(Saida);
        PainelInicial.add(inverte);
        PainelInicial.add(calcular);
        PainelInicial.add(tipoConversaoLabel);

        add(PainelInicial);
        setVisible(true);
    }

    private void realizarConversao() {
        if (PadrãoDeCalc) {
            String entrada = Entrada.getText();
            try {
                int valorDecimal = Integer.parseInt(entrada);
                String valorBinario = Integer.toBinaryString(valorDecimal);
                Saida.setText(valorBinario);
                tipoConversaoLabel.setText("Decimal >>> Binário");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Converter.this, "Entrada inválida. Digite um número decimal válido.");
            }
        } else {
            String entrada = Entrada.getText();
            try {
                int valorDecimal = Integer.parseInt(entrada, 2);
                Saida.setText(String.valueOf(valorDecimal));
                tipoConversaoLabel.setText("Binário >>> Decimal");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Converter.this, "Entrada inválida. Digite um número binário válido.");
            }
        }
    }

    public static void main(String[] args) {
        new Converter();
    }
}
