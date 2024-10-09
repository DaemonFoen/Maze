package backend.academy.maze.model.solver;

import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import java.util.List;


public interface Solver {

    List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);
}
