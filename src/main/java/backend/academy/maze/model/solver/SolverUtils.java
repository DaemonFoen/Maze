package backend.academy.maze.model.solver;

import backend.academy.maze.controller.data.Cell.Type;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import java.util.ArrayList;
import java.util.List;
import static backend.academy.maze.model.ModelUtils.isInBounds;

public class SolverUtils {

    private SolverUtils() {
    }

    public static List<Coordinate> getNeighbors(Maze maze, Coordinate current) {
        List<Coordinate> neighbors = new ArrayList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int newRow = current.row() + dir[0];
            int newCol = current.col() + dir[1];
            if (isInBounds(newRow, newCol, maze.height(), maze.width())
                && maze.grid()[newRow][newCol].type() != Type.WALL) {
                neighbors.add(new Coordinate(newRow, newCol));
            }
        }
        return neighbors;
    }

}
