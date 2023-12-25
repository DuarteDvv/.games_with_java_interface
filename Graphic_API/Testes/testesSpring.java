package Testes;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testesSpring extends JFrame {

    private JTextField Display;

    public testesSpring() {
        initializeUI();
        setVisible(true);
    }

    private void initializeUI() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Botoes de 0 a 9, . e =
        String[] buttons = { "Pow", "Sqr", "Clear", "<<", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };

        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        Display = new JTextField();

        Display.setEditable(false);
        Display.setHorizontalAlignment(SwingConstants.RIGHT);
        Display.setPreferredSize(new Dimension(300, 60));
        panel.add(Display);

       
        Constraints displayCons = layout.getConstraints(Display);
        displayCons.setX(Spring.constant(10));
        displayCons.setY(Spring.constant(10));
        displayCons.setWidth(Spring.sum(Spring.constant(0), Spring.constant(260)));
        displayCons.setHeight(Spring.constant(40));

        int row = 0;
        int col = 0;
       

        for (String buttonText : buttons) {
            JButton button = new JButton(buttonText);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);

            Constraints buttonCons = layout.getConstraints(button);
            buttonCons.setX(Spring.sum(Spring.constant(col * (70)), Spring.constant(col)));
            buttonCons.setY(Spring.sum(displayCons.getConstraint(SpringLayout.SOUTH), Spring.constant(10 + row * (60))));
            buttonCons.setWidth(Spring.constant(70));
            buttonCons.setHeight(Spring.constant(60)); 

            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        
        add(panel);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // JButton source = (JButton) e.getSource();
            // String buttonText = source.getText();
            
            
        }
    }

    public static void main(String[] args) {
      
        new testesSpring();
    }
}
