package backend.academy.maze.view.render;

import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import java.util.List;

public interface MazeRenderer {

    String renderWithPoints(Maze maze, Coordinate start, Coordinate end);

    String renderPath(Maze maze, List<Coordinate> path);

    String borders(int height, int width);
}
