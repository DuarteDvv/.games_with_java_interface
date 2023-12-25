package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {

    private JTextField txtDisplay;

    public Calculadora() {
        initializeUI();
        setVisible(true);
    }

    private void initializeUI() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] buttons = { "Pow", "Sqr", "Clear", "<<", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };

        JPanel panel = new JPanel(new BorderLayout());

       
        txtDisplay = new JTextField();
        txtDisplay.setEditable(false);
        txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDisplay.setPreferredSize(new Dimension(300, 60));
        panel.add(txtDisplay, BorderLayout.NORTH);

    
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));

        for (String buttonText : buttons) {
            JButton button = new JButton(buttonText);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton ButtonClicked = (JButton) e.getSource();
            String buttonText = ButtonClicked.getText();

            
            
            
        }
    }

    public static void main(String[] args) {
       
            new Calculadora();
            
    }
}
