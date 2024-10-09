package maze.model.solver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import backend.academy.maze.model.solver.impl.DijkstraMazeSolver;
import java.util.List;
import maze.testUtils.MazeTestUtils;
import org.junit.jupiter.api.Test;

class DijkstraMazeSolverTest {

    private final DijkstraMazeSolver solver = new DijkstraMazeSolver();

    public Maze predefinedMaze = MazeTestUtils.createExampleMaze();


    @Test
    void solvePredefinedMazeTest() {
        Coordinate start = new Coordinate(1,1);
        Coordinate end = new Coordinate(11,15);

        List<Coordinate> path = solver.solve(predefinedMaze,start,end);

        assertEquals(297, path.size());
    }
}
