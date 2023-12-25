package Testes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class testesUmaEscolhaCheckbox {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Single Selection CheckBox Example");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            ButtonGroup buttonGroup = new ButtonGroup();

            JRadioButton checkBox1 = new JRadioButton("Opção 1");
            JRadioButton checkBox2 = new JRadioButton("Opção 2");
            JRadioButton checkBox3 = new JRadioButton("Opção 3");

            buttonGroup.add(checkBox1);
            buttonGroup.add(checkBox2);
            buttonGroup.add(checkBox3);

            panel.add(checkBox1);
            panel.add(checkBox2);
            panel.add(checkBox3);

            JButton showSelectedButton = new JButton("Mostrar Selecionado");
            showSelectedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedOption = getSelectedOption(buttonGroup);
                    JOptionPane.showMessageDialog(frame, "Opção selecionada: " + selectedOption);
                }
            });

            panel.add(showSelectedButton);

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    private static String getSelectedOption(ButtonGroup buttonGroup) {
        for (Enumeration <AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "Nenhuma opção selecionada";
    }
}
