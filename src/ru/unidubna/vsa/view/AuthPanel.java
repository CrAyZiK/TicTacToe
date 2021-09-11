package ru.unidubna.vsa.view;

import ru.unidubna.vsa.model.Figure;
import ru.unidubna.vsa.model.Game;
import ru.unidubna.vsa.model.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthPanel extends JPanel {
    final Game game;
    public AuthPanel(final GameField gf, final Game game){
        this.game = game;
        JLabel nameXLabel = new JLabel("X:");
        add(nameXLabel);
        JTextField nameXTextField = new JTextField("Игрок1", 10);
        add(nameXTextField);
        JLabel nameOLabel = new JLabel("O:");
        add(nameOLabel);
        JTextField nameOTextField = new JTextField("Игрок2", 10);
        add(nameOTextField);
        JButton loginButton = new JButton("Старт");
        add(loginButton);
        loginButton.addActionListener(actionEvent -> {
            game.setPlayers(new Player[] {
                    new Player(nameXTextField.getText(), Figure.X),
                    new Player(nameOTextField.getText(), Figure.O)}
            );
            nameXTextField.setEnabled(false);
            nameOTextField.setEnabled(false);
            loginButton.setEnabled(false);
            gf.enableField();
        });
    }
}
