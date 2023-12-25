package Testes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testesMenuSuspenso extends JFrame {

    private JComboBox<String> menuSuspenso;
    private JPanel telaAtual;

    public testesMenuSuspenso() {
        setTitle("Exemplo de Menu Suspenso");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        criarMenuSuspenso();
        criarTelaInicial();

        setVisible(true);
    }

    private void criarMenuSuspenso() {
        String[] opcoes = {"Tela Inicial", "Tela 1", "Tela 2"};
        menuSuspenso = new JComboBox<>(opcoes);
        menuSuspenso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String escolha = (String) menuSuspenso.getSelectedItem();
                trocarTela(escolha);
            }
        });

        JPanel menuPanel = new JPanel();
        menuPanel.add(menuSuspenso);

        add(menuPanel, BorderLayout.NORTH);
    }

    private void criarTelaInicial() {
        telaAtual = new JPanel();
        telaAtual.add(new JLabel("Bem-vindo à Tela Inicial"));

        add(telaAtual, BorderLayout.CENTER);
    }

    private void trocarTela(String escolha) {
        remove(telaAtual);

        
        if (escolha.equals("Tela Inicial")) {
            telaAtual = new JPanel();
            telaAtual.add(new JLabel("Bem-vindo à Tela Inicial"));
        } else if (escolha.equals("Tela 1")) {
            telaAtual = new JPanel();
            telaAtual.add(new JLabel("Você está na Tela 1"));
        } else if (escolha.equals("Tela 2")) {
            telaAtual = new JPanel();
            telaAtual.add(new JLabel("Você está na Tela 2"));
        }

       
        add(telaAtual, BorderLayout.CENTER);

        
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new testesMenuSuspenso();
            }
        });
    }
}
