package maze.view;

import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import backend.academy.maze.model.solver.impl.AStarMazeSolver;
import backend.academy.maze.view.render.MazeRenderImpl;
import backend.academy.maze.view.render.MazeRenderer;
import java.util.List;
import maze.testUtils.MazeTestUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MazeRendererTest {

    MazeRenderer mazeRenderer = new MazeRenderImpl();

    @Test
    void renderWithPoints() {
        Maze maze = MazeTestUtils.createExampleMaze();
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(11, 15);

        String actual = mazeRenderer.renderWithPoints(maze, start, end);

        String expected =
            "\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[32mS\u001B[0m \u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m  \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m  \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m  \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m  \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m  \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m \u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m  \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m       \u001B[33mF\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m  \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m";
        assertEquals(expected, actual);
    }

    @Test
    void renderPath() {
        Maze maze = MazeTestUtils.createExampleMaze();
        AStarMazeSolver mazeSolver = new AStarMazeSolver();
        List<Coordinate> path = mazeSolver.solve(maze, new Coordinate(1, 1), new Coordinate(11, 15));

        String actual = mazeRenderer.renderPath(maze, path);

        String expected = """
            \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[32mS\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[1;31m*\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[1;31m*\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m \u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[1;31m*\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[1;31m*\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[1;31m*\u001B[0m\u001B[33mF\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m \u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m\u001B[38;5;220m$\u001B[0m  \u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m\u001B[33m█\u001B[0m
             path cost = 66.1
            """;
        assertEquals(expected, actual);
    }

    @Test
    void borders() {
        String actual = mazeRenderer.borders(30, 60);

        String expected = """
            ############################################################
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            #                                                          #
            ############################################################
            """;
        assertEquals(expected, actual);
    }
}