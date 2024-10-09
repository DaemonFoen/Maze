package maze.model;

import backend.academy.maze.controller.data.Maze;
import backend.academy.maze.model.ModelUtils;
import maze.testUtils.MazeTestUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModelUtilsTest {

    @Test
    void inBoundCheckTest() {
        Maze maze = MazeTestUtils.createExampleMaze();

        assertTrue(ModelUtils.isInBounds(10, 10, maze.height(), maze.width()));
    }

    @Test
    void outOfBoundCheckTest() {
        Maze maze = MazeTestUtils.createExampleMaze();

        assertFalse(ModelUtils.isInBounds(maze.height() - 1, maze.width() - 1, maze.height(), maze.width()));
    }
}
