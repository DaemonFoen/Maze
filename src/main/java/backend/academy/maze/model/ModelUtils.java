package backend.academy.maze.model;

import java.security.SecureRandom;

public final class ModelUtils {

    public static final SecureRandom RANDOM = new SecureRandom();

    private ModelUtils() {
    }

    public static boolean isInBounds(int row, int col, int height, int width) {
        return row > 0 && row < height - 1 && col > 0 && col < width - 1;
    }
}
