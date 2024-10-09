package maze.contoller;

import backend.academy.maze.controller.MazeSolverControllerImpl;
import backend.academy.maze.controller.SessionState;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.model.MazeSolverModel;
import backend.academy.maze.view.View;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static maze.testUtils.MazeTestUtils.createExampleMaze;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameControllerImplTest {

    @Mock
    private MazeSolverModel mazeModel;

    @Mock
    private View view;

    @InjectMocks
    private MazeSolverControllerImpl controller;

    @Test
    void testStartMazeSolving() {
        when(mazeModel.sessionState()).thenReturn(SessionState.SOLVE);
        when(view.drawBorders()).thenReturn(new int[] {30, 60});
        when(mazeModel.maze()).thenReturn(createExampleMaze());
        when(view.drawMazeForPositionSelection(any())).thenReturn(
            new Coordinate[] {new Coordinate(1, 1), new Coordinate(11, 15)});
        when(view.drawPath(any(), any())).thenReturn('Y');

        boolean result = controller.start();

        assertTrue(result);
        verify(mazeModel, times(2)).maze();
        verify(view, times(1)).drawMazeForPositionSelection(any());
    }

}
