package backend.academy.maze.view;

import backend.academy.maze.controller.SessionState;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import java.util.List;

public interface View {

    int drawMenu(SessionState state);

    Coordinate[] drawMazeForPositionSelection(Maze maze);

    Character drawPath(Maze maze, List<Coordinate> coordinateList);

    int[] drawBorders();

    void printMessage(String message);
}
