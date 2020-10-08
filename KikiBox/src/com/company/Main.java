package com.company;



import com.view.MyFrame;
import com.view.MyPanel;


public class Main {

    public static void main(String[] args) {
        MyPanel panel = new MyPanel();
        MyFrame frame = new MyFrame(panel);
    }

}