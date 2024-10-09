package maze.model.solver;

import static backend.academy.maze.model.solver.SolverUtils.getNeighbors;
import static org.junit.jupiter.api.Assertions.assertEquals;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import java.util.List;
import maze.testUtils.MazeTestUtils;
import org.junit.jupiter.api.Test;

class SolverUtilsTest {


    @Test
    void getNeighborsForPredefinedMazeTest() {
        Maze maze = MazeTestUtils.createExampleMaze();
        Coordinate position = new Coordinate(11, 15);

         List<Coordinate> neighbors = getNeighbors(maze,position);

         assertEquals(2, neighbors.size());
         assertEquals(new Coordinate(11, 16), neighbors.get(0));
         assertEquals(new Coordinate(11, 14), neighbors.get(1));
    }
}
