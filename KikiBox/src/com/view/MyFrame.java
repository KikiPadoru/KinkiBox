package com.view;

import javax.swing.JFrame;
import java.awt.*;


public class MyFrame extends JFrame{
    MyPanel panel;



    public MyFrame(MyPanel panel) {
        panel.setBackground(Color.RED);
        this.panel = panel;

        add(panel);
        // setSize(500, 500);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}