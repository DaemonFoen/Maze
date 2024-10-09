package maze.model.generator;

import backend.academy.maze.controller.data.Maze;
import backend.academy.maze.model.generation.impl.MultiPathMazeGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiPathMazeGeneratorTest {

    private final MultiPathMazeGenerator mazeGenerator = new MultiPathMazeGenerator();

    @Test
    void testGeneratedMazeSizes() {
        Maze maze = mazeGenerator.generate(30, 60);

        assertEquals(30, maze.height());
        assertEquals(60, maze.width());
    }
}