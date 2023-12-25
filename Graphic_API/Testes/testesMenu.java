package Testes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testesMenu extends JFrame {

    public testesMenu() {
        setTitle("Menu Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JMenuBar menuBar = new JMenuBar();

       
        JMenu fileMenu = new JMenu("File");

        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

      
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(testesMenu.this, "Open selected");
            }
        });

        
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        
        fileMenu.add(openMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

      
        JMenu editMenu = new JMenu("Edit");

       
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem copyMenuItem = new JMenuItem("Copy");

        
        cutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(testesMenu.this, "Cut selected");
            }
        });

       
        copyMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(testesMenu.this, "Copy selected");
            }
        });

        
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);

        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

       
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new testesMenu().setVisible(true);
            }
        });
    }
}
