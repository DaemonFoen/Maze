package backend.academy.maze.model.generation;

import backend.academy.maze.controller.data.Maze;

public interface Generator {

    Maze generate(int height, int width);
}
