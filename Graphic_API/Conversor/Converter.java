package Conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Converter extends JFrame {

    private boolean padraoDeCalc = true;
    private JPanel painelInicial;
    private JTextField entrada, saida;
    private JButton inverte, calcular;
    private JLabel tipoConversaoLabel;

    public Converter() {
        setTitle("Conversor Int <-> Dec");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        entrada = new JTextField();
        entrada.setPreferredSize(new Dimension(150, 30));
        saida = new JTextField() {
            {
                setText("Resultado");
                setEditable(false);
            }
        };
        saida.setPreferredSize(new Dimension(150, 30));

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
                saida.setText("Resultado");
                entrada.setText("");
                padraoDeCalc = !padraoDeCalc;
                tipoConversaoLabel.setText(padraoDeCalc ? "Decimal >>> Binário" : "Binário >>> Decimal");
            }
        });

        // Deixa já "Clicada"
        entrada.requestFocus();
        entrada.addKeyListener(new KeyListener() {
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

        painelInicial = new JPanel(new FlowLayout(FlowLayout.LEFT,20,20));
        painelInicial.add(entrada);
        painelInicial.add(saida);
        painelInicial.add(inverte);
        painelInicial.add(calcular);
        painelInicial.add(tipoConversaoLabel);

        add(painelInicial);
        setVisible(true);
    }

    private void realizarConversao() {
        if (padraoDeCalc) {
            String in = entrada.getText();
            try {
                int valorDecimal = Integer.parseInt(in);
                String valorBinario = Integer.toBinaryString(valorDecimal);
                saida.setText(valorBinario);
                tipoConversaoLabel.setText("Decimal >>> Binário");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Converter.this, "entrada inválida. Digite um número decimal válido.");
            }
        } else {
            String in = entrada.getText();
            try {
                int valorDecimal = Integer.parseInt(in, 2);
                saida.setText(String.valueOf(valorDecimal));
                tipoConversaoLabel.setText("Binário >>> Decimal");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Converter.this, "entrada inválida. Digite um número binário válido.");
            }
        }
    }

    public static void main(String[] args) {
        new Converter();
    }
}
