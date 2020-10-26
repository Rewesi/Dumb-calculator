package com.rewesi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyWindow extends JFrame {

    JTextField display1, display2;
    JButton make_zero1, make_zero2;

    JButton[] buttons;

    class ResetHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == make_zero1)
            {
                display1.setText("0");
            } else
            {
                display2.setText("0");
            }
        }
    }

    class NumberPad implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().compareTo("+") == 0)
            {
                display1.setText("" + (Integer.parseInt(display1.getText()) + Integer.parseInt(display2.getText())));
            }
            else if(e.getActionCommand().compareTo("-") == 0)
            {
                display1.setText("" + (Integer.parseInt(display1.getText()) - Integer.parseInt(display2.getText())));
            }
            else
            {
                if(Integer.parseInt(display2.getText()) == 0)
                {
                    display2.setText("");
                }
                display2.setText(display2.getText() + e.getActionCommand());
            }
        }
    }

    public MyWindow(String title) {
        super(title);
        this.setLayout(new GridLayout(6,3));

        this.add(new JLabel("Sum:", SwingConstants.CENTER));
        display1 = new JTextField("0", SwingConstants.EAST);
        display1.setHorizontalAlignment(SwingConstants.RIGHT);
        display1.setEditable(false);
        this.add(display1);
        make_zero1 = new JButton("Clear");
        make_zero1.addActionListener(new ResetHandler());
        this.add(make_zero1);

        this.add(new JLabel("+ or -", SwingConstants.CENTER));
        display2 = new JTextField("0", SwingConstants.EAST);
        display2.setHorizontalAlignment(SwingConstants.RIGHT);
        display2.setEditable(false);
        this.add(display2);
        make_zero2 = new JButton("Clear");
        make_zero2.addActionListener(new ResetHandler());
        this.add(make_zero2);


        // buttons

        buttons = new JButton[12];
        char[] symbols = {'7', '8', '9', '4', '5', '6', '1', '2', '3','0', '+', '-'};

        for(int i = 0; i < 12 ; i++)
        {
            buttons[i] = new JButton("" + symbols[i]);
            buttons[i].addActionListener(new NumberPad());

            this.add(buttons[i]);
        }

        this.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 300, 300);
        this.setLocationRelativeTo(null);
    }
}