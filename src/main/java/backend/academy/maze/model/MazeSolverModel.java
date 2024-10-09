package backend.academy.maze.model;

import backend.academy.maze.controller.SessionState;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import java.io.IOException;
import java.util.List;

public interface MazeSolverModel {

    void updateState(int input) throws IOException;

    SessionState sessionState();

    Coordinate getStart();

    void setStart(Coordinate start);

    Coordinate getEnd();

    void setEnd(Coordinate end);

    Maze maze();

    void generateMaze(int height, int width);

    List<Coordinate> path();
}
