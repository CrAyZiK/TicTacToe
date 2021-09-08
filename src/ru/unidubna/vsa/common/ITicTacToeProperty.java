package ru.unidubna.vsa.common;

import ru.unidubna.vsa.model.exceptions.TicTacToeCriticalException;

import java.io.IOException;

public interface ITicTacToeProperty {
    public Character getSeparatorCharacter();

    static ITicTacToeProperty getDefaultProperties() {
        try {
            return FileBasedTicTacToeProperty.generateInstance();
        } catch (final IOException e) {
            e.printStackTrace();
            throw new TicTacToeCriticalException(e);
        }
    }
}
