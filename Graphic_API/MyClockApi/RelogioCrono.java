package MyClockApi;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.*;


public class RelogioCrono extends JFrame {

    private JComboBox<String> Menu;
    private JPanel ClockPanel;
    private JPanel TimerPanel;
    private JPanel CountPanel;
    private JPanel currentScreen;
    private int T = 60;
    private Timer timing; // Variável para armazenar o Timer
    private boolean isTimerRunning = false;

    private int T2 = 0; // Novo contador T2

    RelogioCrono() {
        setTitle("Relogio");
        setSize(400, 250);
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

        setScreen("Clock");

        setVisible(true);
    }

    public void createClockScreen() {
        ClockPanel = new JPanel(new GridLayout(1, 2));

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar Cal = Calendar.getInstance();
                Date Hoje = Cal.getTime();
                SimpleDateFormat Formata = new SimpleDateFormat("dd/MM/yyyy");

                ClockPanel.removeAll();

                JLabel Data = new JLabel("     " + Formata.format(Hoje));
                JLabel Horario = new JLabel("       " + Cal.get(Calendar.HOUR) + ":" + Cal.get(Calendar.MINUTE) + ":" + Cal.get(Calendar.SECOND));

                Data.setFont(new Font("Arial", Font.PLAIN, 22));
                Horario.setFont(new Font("Arial", Font.PLAIN, 22));

                ClockPanel.add(Data);
                ClockPanel.add(Horario);

                revalidate();
                repaint();
            }
        });

        timer.setRepeats(true);
        timer.start();
    }

    public void createTimerScreen() {
        TimerPanel = new JPanel(new BorderLayout());
        JPanel Display = new JPanel(new BorderLayout());

        JLabel Tempo = new JLabel("" + T + "") {
            {
                setHorizontalAlignment(JLabel.CENTER);
                setFont(new Font("Arial", Font.PLAIN, 22));
            }
        };

        Display.add(Tempo, BorderLayout.CENTER);

        JPanel Control = new JPanel(new FlowLayout());

        JButton back2Button = new JButton("<<");
        Control.add(back2Button);

        JButton backButton = new JButton("<");
        Control.add(backButton);

        JButton startButton = new JButton("Start");
        Control.add(startButton);

        JButton forwardButton = new JButton(">");
        Control.add(forwardButton);

        JButton forward2Button = new JButton(">>");
        Control.add(forward2Button);

        TimerPanel.add(Display, BorderLayout.CENTER);
        TimerPanel.add(Control, BorderLayout.SOUTH);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                T = Math.max(0, T - 1);
                Tempo.setText("" + T);
            }
        });

        back2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                T = Math.max(0, T - 10);
                Tempo.setText("" + T);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isTimerRunning) {
                    timing = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            T = Math.max(0, T - 1);
                            Tempo.setText("" + T);

                            if (T == 0) {
                                timing.stop();
                                isTimerRunning = false;
                            }
                        }
                    });
                    timing.start();
                    isTimerRunning = true;
                } else {
                    // Se o timer estiver em execução, pausa
                    timing.stop();
                    isTimerRunning = false;
                }
            }
        });

        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                T = T + 1;
                Tempo.setText("" + T);
            }
        });

        forward2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                T = T + 10;
                Tempo.setText("" + T);
            }
        });
    }

    public void createCountScreen() {
        CountPanel = new JPanel();
        JPanel Display2 = new JPanel(new BorderLayout());
        JLabel Tempo = new JLabel("" + T2 + "") {
            {
                setHorizontalAlignment(JLabel.CENTER);
                setFont(new Font("Arial", Font.PLAIN, 22));
            }
        };

        Display2.add(Tempo, BorderLayout.CENTER);

        JPanel Control = new JPanel(new FlowLayout());

        JButton start = new JButton("Start");
        Control.add(start);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isTimerRunning) {
                    timing = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            T2++;
                            Tempo.setText("" + T2);
                        }
                    });
                    timing.start();
                    isTimerRunning = true;
                } else {
                    // Se o timer estiver em execução, pausa
                    timing.stop();
                    isTimerRunning = false;
                    T2 = 0; // Reinicia o contador ao pausar
                    Tempo.setText("" + T2);
                }
            }
        });

        CountPanel.add(Display2, BorderLayout.CENTER);
        CountPanel.add(Control, BorderLayout.SOUTH);
    }

    public void setScreen(String escolha) {
        if (currentScreen != null) {
            remove(currentScreen);
        }

        switch (escolha) {
            case "Clock":
                currentScreen = ClockPanel;
                break;

            case "Timer":
                currentScreen = TimerPanel;
                break;

            case "Count":
                currentScreen = CountPanel;
                break;
        }

        add(currentScreen, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new RelogioCrono();
    }
}
