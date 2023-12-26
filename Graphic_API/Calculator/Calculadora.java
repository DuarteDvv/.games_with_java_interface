package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {

    private JTextField txtDisplay;
    private String currentInput = "";
    JPanel buttonPanel = new JPanel(new GridLayout(5, 4));

    public Calculadora() {
        initializeUI();
        setVisible(true);
    }

    private void initializeUI() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] buttons = { "Pow", "Sqr", "Clear", "<<", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };

        JPanel panel = new JPanel(new BorderLayout());

        txtDisplay = new JTextField();
        txtDisplay.setEditable(false);
        txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDisplay.setPreferredSize(new Dimension(300, 60));
        panel.add(txtDisplay, BorderLayout.NORTH);

        

        for (String buttonText : buttons) {
            JButton button = new JButton(buttonText);
            button.setEnabled(!estaContido(buttonText, new String[]{"/", "+", "-", "*", ".", "Pow", "Sqr"}));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
    }

    private class ButtonClickListener implements ActionListener {
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String[] operators = {"/", "+", "-", "*", ".", "Pow", "Sqr"};
        boolean lastClickedOperator = false;
    
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            String buttonText = buttonClicked.getText();
    
            
            if (currentInput.isEmpty() && estaContido(buttonText, operators)) {
                return;
            }
    
           
            if (estaContido(buttonText, numbers)) {
                currentInput += buttonText;
                lastClickedOperator = false;
                txtDisplay.setText(currentInput);
                atualizarStatusBotoesOperadores();
            } else {
                
                if (estaContido(buttonText, operators)) {
                  
                    switch (buttonText) {
                        case "Pow":
                            currentInput = currentInput + "^";
                            break;

                        case "Sqr":
                            currentInput = currentInput + "@";
                            break;

                        default:
                            if(temOperador(currentInput) != "n")
                                currentInput = resolution(currentInput);
                            currentInput += buttonText;
                            break;
                    }
                    lastClickedOperator = true;
                    txtDisplay.setText(currentInput);
                    atualizarStatusBotoesOperadores();
            
                } 
                else {
                    
                    switch (buttonText) {
                        case "Clear":
                            currentInput = "";
                            lastClickedOperator = false;
                            txtDisplay.setText("");
                            break;
    
                        case "<<":
                            if (!currentInput.isEmpty()) {
                                currentInput = currentInput.substring(0, currentInput.length() - 1);
                                txtDisplay.setText(currentInput);
                                lastClickedOperator = false;
                                atualizarStatusBotoesOperadores();
                            }
                            break;
    
                        case "=":
                            currentInput = resolution(currentInput);
                            txtDisplay.setText(currentInput);
                            lastClickedOperator = false;
                            break;
                    }
                }
            }
        }
    
        private void atualizarStatusBotoesOperadores() {
            for (Component component : buttonPanel.getComponents()) {
                if (component instanceof JButton) {
                    JButton button = (JButton) component;
                    if (estaContido(button.getText(), operators)) {
                        button.setEnabled(!lastClickedOperator);
                    }
                }
            }
        }
    }
    
    
    
    
    

    private String resolution(String Operation) {
        String op = temOperador(Operation);
        String[] strNum = Operation.split("\\" + op);
    
        double Resultado = 0;
    
        if (op.equals("+"))
            Resultado = Double.parseDouble(strNum[0]) + Double.parseDouble(strNum[1]);
        else if (op.equals("/"))
            Resultado = Double.parseDouble(strNum[0]) / Double.parseDouble(strNum[1]);
        else if (op.equals("*"))
            Resultado = Double.parseDouble(strNum[0]) * Double.parseDouble(strNum[1]);
        else if (op.equals("-"))
            Resultado = Double.parseDouble(strNum[0]) - Double.parseDouble(strNum[1]);
        else if (op.equals("^")) //pow
            Resultado = Math.pow(Double.parseDouble(strNum[0]), Double.parseDouble(strNum[1]));
        else if (op.equals("@")) //sqr
            Resultado = calcularRaiz(strNum[0], strNum[1]);
        else {
            txtDisplay.setText("Erro");
        }
    
        return String.valueOf(Resultado);
    }
    
    private double calcularRaiz(String base, String indice) {
        double baseNum = Double.parseDouble(base);
        double indiceNum = Double.parseDouble(indice);
    
        if (indiceNum == 2) {
            return Math.sqrt(baseNum); // Raiz quadrada
        } else if (indiceNum == 3) {
            return Math.cbrt(baseNum); // Raiz cúbica
        } else {
            return Math.pow(baseNum, 1 / indiceNum); // Outras raízes
        }
    }
    

    private String temOperador(String a) {
        char[] b = a.toCharArray();
        for (char i : b) {
            if (i == '+')
                return "+";
            else if (i == '/')
                return "/";
            else if (i == '*')
                return "*";
            else if (i == '-')
                return "-";
            else if (i == '^') //pow
                return "^";
            else if (i == '@') //sqr
                return "@";
        }

        return "n";
    }

    public boolean estaContido(String a, String[] array) {
        for (String u : array) {
            if (a.equals(u))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}