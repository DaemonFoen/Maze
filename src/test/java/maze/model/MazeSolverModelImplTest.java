package maze.model;

import backend.academy.maze.controller.SessionState;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.model.MazeSolverModelImpl;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MazeSolverModelImplTest {

    private MazeSolverModelImpl mazeSolverModel;

    @BeforeEach
    void setUp() {
        mazeSolverModel = new MazeSolverModelImpl();
    }

    @Test
    void updateStateTest() throws IOException {
        mazeSolverModel.updateState(2);
        mazeSolverModel.updateState(1);
        mazeSolverModel.updateState(3);
        mazeSolverModel.updateState(1);
        mazeSolverModel.updateState(1);

        assertEquals(SessionState.SOLVE, mazeSolverModel.sessionState());
    }

    @Test
    void generateMazeTest() {
        mazeSolverModel.generateMaze(30, 60);

        assertEquals(30, mazeSolverModel.maze().width());
        assertEquals(60, mazeSolverModel.maze().height());
    }

    @Test
    void generatePathTest() throws IOException {
        mazeSolverModel.updateState(1);
        mazeSolverModel.setStart(new Coordinate(1, 1));
        mazeSolverModel.setEnd(new Coordinate(15, 15));

        mazeSolverModel.generateMaze(30, 60);

        assertFalse(mazeSolverModel.path().isEmpty());
    }

}
