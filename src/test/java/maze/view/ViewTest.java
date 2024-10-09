package maze.view;

import backend.academy.maze.controller.SessionState;
import backend.academy.maze.view.MazeDrawUtils;
import backend.academy.maze.view.MazeViewImpl;
import java.io.PrintWriter;
import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ViewTest {

    @SuppressWarnings("all")
    @Mock
    Terminal terminal;

    @Mock
    private LineReader lineReader;

    @Mock
    private PrintWriter writer;

    @InjectMocks
    private MazeViewImpl mazeView;

    @Test
    void drawMenuTest() {
        when(lineReader.readLine()).thenReturn("1");

        mazeView.drawMenu(SessionState.MAIN_MENU);

        verify(writer).println(MazeDrawUtils.MENU);
    }

    @Test
    void drawGenerationAlgorithmsTest() {
        when(lineReader.readLine()).thenReturn("2");

        mazeView.drawMenu(SessionState.GENERATION_ALGORITHMS);

        verify(writer).println(MazeDrawUtils.GENERATION_ALGORITHMS);
    }

    @Test
    void drawSolvingAlgorithmsTest() {
        when(lineReader.readLine()).thenReturn("3");

        mazeView.drawMenu(SessionState.PATHFINDING_ALGORITHMS);

        verify(writer).println(MazeDrawUtils.PATHFINDING_ALGORITHMS);
    }

    @Test
    void printMessageTest() {
        mazeView.printMessage("Printed Message");

        verify(writer).println("Printed Message");
    }
}
