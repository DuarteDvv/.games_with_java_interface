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
    private boolean eraser = false;
    private Color[] paleta = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

    private static final float[] DASHED_PATTERN = {5f, 5f};
    private static final float[] DOTTED_PATTERN = {2f, 2f};

    private enum LineType {
        SOLID,
        DASHED,
        DOTTED
    }

    private LineType currentLineType = LineType.SOLID;

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

        areaDesenho.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = e.getX();
                int newY = e.getY();

                Graphics g = getGraphics();
                Graphics2D pencil = (Graphics2D) g;

                if (eraser) {
                    pencil.setColor(areaDesenho.getBackground());
                    pencil.setStroke(new BasicStroke(espessuraFonteAtual, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                } else {
                    pencil.setColor(currentColorFont);
                    float[] pattern = currentLineType == LineType.DASHED ? DASHED_PATTERN :
                            currentLineType == LineType.DOTTED ? DOTTED_PATTERN :
                                    null;
                    pencil.setStroke(new BasicStroke(espessuraFonteAtual, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, pattern, 0f));
                }

                pencil.drawLine(lastX, lastY, newX, newY);

                lastX = newX;
                lastY = newY;

                revalidate();
            }
        });

        add(areaDesenho, BorderLayout.CENTER);
    }

    private void criarBarraDeOpcoes() {
        JMenuBar barraDeOpcoes = new JMenuBar();


        JMenu LineTypeMenu = new JMenu("LineType") {
            {
                JMenuItem solidLine = new JMenuItem("Solid Line");
                JMenuItem dashedLine = new JMenuItem("Dashed Line");
                JMenuItem dottedLine = new JMenuItem("Dotted Line");

                solidLine.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setLineType(LineType.SOLID);
                    }
                });

                dashedLine.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setLineType(LineType.DASHED);
                    }
                });

                dottedLine.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setLineType(LineType.DOTTED);
                    }
                });

                add(solidLine);
                add(dashedLine);
                add(dottedLine);
            }
        };

        JMenu borrachaMenu = new JMenu("Erase") {
            {
                add(new JMenuItem("Erase All") {
                    {
                        addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                areaDesenho.repaint();
                            }
                        });
                    }
                });

                add(new JMenuItem("Erase Pencil") {
                    {
                        addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!eraser) {
                                    eraser = true;
                                    setBackground(Color.GREEN);
                                } else {
                                    setBackground(null);
                                    eraser = false;
                                }
                            }
                        });
                    }
                });
            }
        };

        JMenu fontColorMenu = new JMenu("FontColor") {
            {
                for (Color c : paleta) {
                    add(new JMenuItem() {
                        {
                            setBackground(c);
                            addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    currentColorFont = c;
                                }
                            });
                        }
                    });
                }
            }
        };

        JMenu backColorMenu = new JMenu("BackgroundColor") {
            {
                for (Color c : paleta) {
                    add(new JMenuItem() {
                        {
                            setBackground(c);
                            addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
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
        barraDeOpcoes.add(LineTypeMenu);

        setJMenuBar(barraDeOpcoes);
    }

    private void setLineType(LineType lineType) {
        currentLineType = lineType;
    }

    public static void main(String[] args) {
        new Paint();
    }
}
