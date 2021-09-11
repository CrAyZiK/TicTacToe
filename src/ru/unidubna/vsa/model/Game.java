package ru.unidubna.vsa.model;

public class Game {

    private Player[] players;

    private final Field field;

    private final String name;

    public Game(final Player[] players,
                final Field field,
                final String name) {
        this.players = players;
        this.field = field;
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }
    public void setPlayers(Player[] players){
        this.players = players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

}
