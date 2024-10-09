package backend.academy.maze.model.generation;

import backend.academy.maze.controller.data.Cell.Type;
import static backend.academy.maze.model.ModelUtils.RANDOM;

public final class GeneratorUtils {

    private GeneratorUtils() {
    }

    @SuppressWarnings("all")
    public static Type randomSurface() {
        double chance = RANDOM.nextDouble();
        if (chance < 0.15) {
            return Type.MUD;
        } else if (chance < 0.25) {
            return Type.SAND;
        } else if (chance < 0.35) {
            return Type.COIN;
        } else if (chance < 0.45) {
            return Type.ROAD;
        } else {
            return Type.NORMAL;
        }
    }

    @SuppressWarnings("all")
    public static int[] randomDirection() {
        double chance = RANDOM.nextDouble();
        if (chance < 0.25) {
            return new int[] {0, 1};
        } else if (chance < 0.50) {
            return new int[] {0, -1};
        } else if (chance < 0.75) {
            return new int[] {1, 0};
        } else {
            return new int[] {-1, 0};
        }
    }
}
