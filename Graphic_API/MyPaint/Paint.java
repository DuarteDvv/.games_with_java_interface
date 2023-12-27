package MyPaint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Paint extends JFrame {
    private int lastX, lastY;
    private JPanel areaDesenho;
    private int espessuraFonteAtual = 4;
    private Color currentColorFont = Color.BLACK;
    private Color[] paleta = {Color.BLACK,Color.BLUE,Color.CYAN,Color.DARK_GRAY,Color.GRAY,Color.GREEN,Color.LIGHT_GRAY, Color.MAGENTA,Color.ORANGE, Color.PINK,Color.RED,Color.WHITE,Color.YELLOW};

    Paint() {
        setTitle("MyPaint");
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        criarBarraDeOpcoes();
        criarAreaDesenho();
        setVisible(true);
    }

    
    private void criarAreaDesenho() {
        areaDesenho = new JPanel();

        areaDesenho.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY();
            }
        });

        areaDesenho.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = e.getX();
                int newY = e.getY();

                Graphics l = getGraphics();
                Graphics2D lapis = (Graphics2D) l;
                lapis.setColor(currentColorFont);
                lapis.setStroke(new BasicStroke(espessuraFonteAtual, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

                lapis.drawLine(lastX, lastY, newX, newY);

                lastX = newX;
                lastY = newY;

                revalidate();
            }
        });

        add(areaDesenho, BorderLayout.CENTER);
    }

    private void criarBarraDeOpcoes() {
        JMenuBar barraDeOpcoes = new JMenuBar();

        JMenu borrachaMenu = new JMenu("Erase"){

        };

        JMenu fontColorMenu = new JMenu("FontColor"){
            {
                for(Color c : paleta){
                    add(new JMenuItem(){
                        {   
                            setBackground(c);
                            addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e){
                                    currentColorFont = c;
                                    
                                }
                            });
                            
                        }
                    });
                }
            }
        };
            
        JMenu backColorMenu = new JMenu("BackgroundColor"){
            {
                for(Color c : paleta){
                    add(new JMenuItem(){
                        {   
                            setBackground(c);
                            addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e){
                                    areaDesenho.setBackground(c);
                                }
                            });
                            
                        }
                    });
                }
            }
        };


        JMenu fontSizeMenu = new JMenu("FontSize") {
            JLabel espc = new JLabel("" + espessuraFonteAtual);
            {
                add(new JButton("+") {
                    {
                        addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                espessuraFonteAtual += 1;
                                espc.setText("" + espessuraFonteAtual);
                            }
                        });
                    }
                });

                
                add(espc);
        
                add(new JButton("_") {
                    {
                        addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                espessuraFonteAtual = Math.max(2, espessuraFonteAtual - 1); 
                                espc.setText("" + espessuraFonteAtual);
                            }
                        });
                    }
                });
            }
        };
        
        
       

        barraDeOpcoes.add(borrachaMenu);
        barraDeOpcoes.add(fontColorMenu);
        barraDeOpcoes.add(backColorMenu);
        barraDeOpcoes.add(fontSizeMenu);

        setJMenuBar(barraDeOpcoes); 
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Paint());
    }
}