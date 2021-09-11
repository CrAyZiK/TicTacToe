package ru.unidubna.vsa.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGameDialog extends JDialog {
    public EndGameDialog(final String caption, final String outcome){
        setTitle(caption);
        setSize(100, 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        p.add(new JLabel(outcome));
        JButton close = new JButton("Выход");
        close.addActionListener(actionEvent -> dispose());
        p.add(close);
        add(p);
    }
    @Override
    public void dispose(){
        System.exit(0);
    }
}
