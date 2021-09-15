package ru.unidubna.vsa.view;

import ru.unidubna.vsa.controllers.CurrentMoveController;
import ru.unidubna.vsa.controllers.MoveController;
import ru.unidubna.vsa.controllers.WinnerController;
import ru.unidubna.vsa.model.Figure;
import ru.unidubna.vsa.model.Game;
import ru.unidubna.vsa.model.Point;
import ru.unidubna.vsa.model.exceptions.AlreadyOccupiedException;
import ru.unidubna.vsa.model.exceptions.InvalidPointException;
import ru.unidubna.vsa.model.exceptions.TicTacToeCriticalException;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GameField extends JPanel {
    private final JButton[][] cells = new JButton[3][3];
    private final HashMap<JButton, Point> _cellsCoordinates = new HashMap<>();
    private final CurrentMoveController cmc = new CurrentMoveController();
    private final WinnerController wc = new WinnerController();
    private final MoveController mc = new MoveController();
    final Game game;
    public GameField(final Game game){
        this.game = game;
        setLayout(new GridLayout(3, 3));
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                cells[i][j] = new JButton();
                _cellsCoordinates.put(cells[i][j], new Point(i, j));
                add(cells[i][j]);
                cells[i][j].setEnabled(false);
                cells[i][j].addActionListener(actionEvent -> {
                    JButton btn = (JButton) actionEvent.getSource();
                    btn.setEnabled(false);

                    try {
                        Figure f = cmc.currentMove(game.getField());
                        mc.applyFigure(game.getField(), _cellsCoordinates.get(btn), f);
                        btn.setText(f.toString());
                    } catch (final InvalidPointException | AlreadyOccupiedException e) {
                        throw new TicTacToeCriticalException(e);
                    }
                    Figure w = wc.getWinner(game.getField());
                    if (w != null) {
                        lockField();
                        EndGameDialog win = new EndGameDialog("Конец игры", String.format("Победитель - %s\n", w));
                        win.setVisible(true);
                        //System.out.format("Winner is: %s\n", w);
                        return;
                    }
                    if (cmc.currentMove(game.getField()) == null) {
                        lockField();
                        EndGameDialog draw = new EndGameDialog("Конец игры", "Нет доступных ходовю\nНичья!");
                        draw.setVisible(true);
                        //System.out.println("No winner and no moves left!");
                    }
                });
            }
        }
    }
    private void lockField(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                cells[i][j].setEnabled(false);
            }
        }
    }
    public void enableField(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                cells[i][j].setText("");
                cells[i][j].setEnabled(true);
            }
        }
    }
}
