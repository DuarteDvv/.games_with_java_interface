package Graphic_API.Conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Converter extends JFrame {

    private boolean PadrãoDeCalc = true;

    private JPanel PainelInicial;
    private JTextField Decimal, Binario;
    private JButton inverte, calcular;

    public Converter() {
        setTitle("Conversor Int <-> Dec");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação e configuração do JTextField Decimal
        Decimal = new JTextField("Decimal");
        Decimal.setPreferredSize(new Dimension(150, 30));
        Decimal.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Decimal.getText().equals("Decimal")) {
                    Decimal.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Decimal.getText().isEmpty()) {
                    Decimal.setText("Decimal");
                }
            }
        });

        // Criação e configuração do JTextField Binario
        Binario = new JTextField("Binário");
        Binario.setPreferredSize(new Dimension(150, 30));
        Binario.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Binario.getText().equals("Binário")) {
                    Binario.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Binario.getText().isEmpty()) {
                    Binario.setText("Binário");
                }
            }
        });

        // Criação de botões com ícones de seta para a direita e para a esquerda
        Icon calc = new ImageIcon("Graphic_API\\Conversor\\play.jpg");
        Icon setas = new ImageIcon("Graphic_API\\Conversor\\inverte.jpg");

        inverte = new JButton(setas);
        calcular = new JButton(calc);
        
        // Adicionando ação ao botão "calcular"
        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PadrãoDeCalc == true){

                }
                else{
                    
                }
            }
        });

        inverte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PadrãoDeCalc = !PadrãoDeCalc;
            }
        });






        // Criação do JPanel e configuração do layout FlowLayout
        PainelInicial = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));

        PainelInicial.add(Decimal);
        PainelInicial.add(Binario);
        PainelInicial.add(inverte);
        PainelInicial.add(calcular);

        add(PainelInicial);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Converter());
    }
}
