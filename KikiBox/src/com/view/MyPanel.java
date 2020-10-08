package com.view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.model.MyList;
import com.model.MyQueue;
import com.model.MyStack;

public class MyPanel extends JPanel{

    MyList<String> list = new MyList<String>();

    JTextField field;
    JButton pushJ;
    JButton bStack;
    JButton bQueue;
    JButton popJ;
    JList jList;
    ListModel listModel;

    public MyPanel() {

        listModel = new ListModel();
        listModel.setList(list);
        field = new JTextField("                 ");
        field.requestFocus(true);
        pushJ = new JButton("push");
        pushJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                list.push(field.getText().trim());
                listModel.fireIntervalAdded();
                field.setText("");
                popJ.setEnabled(true);
                popJ.setBackground(Color.MAGENTA);
                field.requestFocus(true);
                } catch (Exception e1){ JOptionPane.showMessageDialog(MyPanel.this, "Error!");}
            }
        });
        bStack = new JButton("Stack model");
        bQueue = new JButton("Queue model");

        bStack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.setSq(new MyStack<>());
                listModel.setList(list);
                listModel.fireIntervalAdded();
                field.setText("");
                bQueue.setBackground(Color.ORANGE);
                bStack.setBackground(Color.PINK);
                bQueue.setEnabled(true);
                bStack.setEnabled(false);
                field.requestFocus(true);
            }
        });
        bQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.setSq(new MyQueue<>());
                listModel.setList(list);
                listModel.fireIntervalAdded();
                field.setText("");
                bQueue.setBackground(Color.PINK);
                bStack.setBackground(Color.ORANGE);
                bStack.setEnabled(true);
                bQueue.setEnabled(false);
                field.requestFocus(true);
            }
        });

        popJ = new JButton("pop");
        popJ.setEnabled(false);
        popJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s =(String)list.pop();
                listModel.fireIntervalAdded();
                field.setText(s);
                field.requestFocus(true);
                if (list.size==0) {popJ.setEnabled(false);popJ.setBackground(Color.RED);}
            }
        });
        pushJ.setBackground(Color.GREEN);
        popJ.setBackground(Color.RED);
        field.setBackground(Color.GRAY);
        bQueue.setBackground(Color.ORANGE);
        bStack.setBackground(Color.ORANGE);

        jList = new JList();
        jList.setModel(listModel);
        jList.setPrototypeCellValue("много букв             ");
        JComponent [][] component = new JComponent[3][2];
        component[0][0] = field;
        component[0][1] = pushJ;
        component[1][0] = new JScrollPane(jList);
        component[1][1] = popJ;
        component[2][0] = bStack;
        component[2][1]= bQueue;
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        for(int i=0;i<3;i++)
        {
            constraints.gridy   = i  ;
            for(int j=0;j<2;j++)
            {
                constraints.gridx = j;
                add(component[i][j],constraints);
            }

        }
    }

    public void setList(MyList list) {
        this.list = list;
    }

}