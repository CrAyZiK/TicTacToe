package ru.unidubna.vsa.controllers;

import ru.unidubna.vsa.model.Field;
import ru.unidubna.vsa.model.Figure;
import ru.unidubna.vsa.model.Point;
import ru.unidubna.vsa.model.exceptions.AlreadyOccupiedException;
import ru.unidubna.vsa.model.exceptions.InvalidPointException;

public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws InvalidPointException,
            AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
