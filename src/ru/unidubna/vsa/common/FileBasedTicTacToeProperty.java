package ru.unidubna.vsa.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public record FileBasedTicTacToeProperty(Properties properties) implements ITicTacToeProperty {
    private static final String PROPERTY_FILE = "tictactoe.property";

    private static final String SEPARATOR_KEY = "separator";

    public static ITicTacToeProperty generateInstance() throws IOException {
        final Properties properties = new Properties();
        try (final InputStream is = FileBasedTicTacToeProperty.class.getResourceAsStream(PROPERTY_FILE)) {
            properties.load(is);
        } catch (IOException ex) {
            System.out.printf("Something wrong with file: %s! Please, check!%n", PROPERTY_FILE);
        }
        return new FileBasedTicTacToeProperty(properties);
    }

    @Override
    public Character getSeparatorCharacter() {
        return this.properties.getProperty(SEPARATOR_KEY).charAt(0);
    }
}
