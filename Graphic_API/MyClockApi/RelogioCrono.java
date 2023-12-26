package MyClockApi;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.*;

public class RelogioCrono extends JFrame{

    private JComboBox<String> Menu;
    private JPanel ClockPanel;
    private JPanel TimerPanel;
    private JPanel CountPanel;
    private JPanel currentScreen = ClockPanel;
    

    RelogioCrono(){
        setTitle("Relogio");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] Options = {"Clock", "Timer", "Count"};
        Menu = new JComboBox<>(Options);
        Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String escolha = (String) Menu.getSelectedItem();
                setScreen(escolha);
            }
        });

        add(Menu, BorderLayout.NORTH);

        createClockScreen();
        createTimerScreen();
        createCountScreen();


        setVisible(true);
    }

    public void createClockScreen(){
        ClockPanel = new JPanel();
        SimpleDateFormat Formata = new SimpleDateFormat("dd/MM/yyyy");
        // Locale

        JLabel Data,Horario;

        

    }

    public void createTimerScreen(){
        TimerPanel = new JPanel();
    }

    public void createCountScreen(){
        CountPanel = new JPanel();
    }

    public void setScreen(String escolha){

        switch(escolha){
            case "Clock":
                currentScreen = ClockPanel;
                

            case "Timer":
                currentScreen = TimerPanel;
                

            case "Count":
                currentScreen = CountPanel;
                
        }

        add(currentScreen,BorderLayout.CENTER); //trocar

    }



    public static void main(String[] args){
        new RelogioCrono();

    }
}