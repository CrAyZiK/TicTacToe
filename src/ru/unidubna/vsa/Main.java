package ru.unidubna.vsa;

import ru.unidubna.vsa.model.Field;
import ru.unidubna.vsa.model.Figure;
import ru.unidubna.vsa.model.Game;
import ru.unidubna.vsa.model.Player;
import ru.unidubna.vsa.model.exceptions.InvalidBoardSizeException;
import ru.unidubna.vsa.view.ConsoleView;
import ru.unidubna.vsa.view.SwingView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int mode = 1;
        Player[] players = new Player[2];
        final int FIELD_SIZE = 3;
        Field field;
        Game gameXO;
        switch (mode) {
            case 0 -> {
                final String name1 = playerNameInput(1);
                final String name2 = playerNameInput(2);
                players[0] = new Player(name1, Figure.X);
                players[1] = new Player(name2, Figure.O);
                field = null;
                try {
                    field = new Field(FIELD_SIZE);
                } catch (InvalidBoardSizeException e) {
                    e.printStackTrace();
                }
                gameXO = new Game(players, field, "XO");
                final ConsoleView consoleView = new ConsoleView();
                consoleView.show(gameXO);
                while (consoleView.move(gameXO)) {
                    consoleView.show(gameXO);
                }
            }
            case 1 -> {
                players = new Player[2];
                players[0] = new Player("Игрок1", Figure.X);
                players[1] = new Player("Игрок2", Figure.O);
                field = null;
                try {
                    field = new Field(FIELD_SIZE);
                } catch (InvalidBoardSizeException e) {
                    e.printStackTrace();
                }
                gameXO = new Game(players, field, "Крестики-нолики");
                SwingView sv = new SwingView(gameXO);
                sv.setVisible(true);
            }
            default -> System.out.println("Неверный мод!");
        }
        
    }
    static String playerNameInput(final int count) {
        Scanner sc = new Scanner(System.in);
        System.out.format("Enter Player %s  name: ", count);
        return sc.nextLine();
    }
}
