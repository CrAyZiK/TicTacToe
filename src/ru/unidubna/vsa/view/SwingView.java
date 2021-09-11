package ru.unidubna.vsa.view;


import ru.unidubna.vsa.model.Game;
import ru.unidubna.vsa.view.GameField;
import javax.swing.*;
import java.awt.*;

public class SwingView extends JFrame {
    final Game game;
    final GameField gf;
    public SwingView(final Game game){
        this.game = game;
        setTitle(game.getName());
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gf = new GameField(game);
        Container container = getContentPane();
        container.add(new AuthPanel(gf, game), BorderLayout.NORTH);
        container.add(gf, BorderLayout.CENTER);
    }
}
