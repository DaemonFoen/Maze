package backend.academy.maze;

import backend.academy.maze.controller.MazeSolverController;
import backend.academy.maze.controller.MazeSolverControllerImpl;
import backend.academy.maze.model.MazeSolverModelImpl;
import backend.academy.maze.view.MazeViewImpl;
import backend.academy.maze.view.View;
import java.io.IOException;
import java.io.PrintWriter;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) throws IOException {
        Terminal terminal = TerminalBuilder.terminal();
        LineReader lineReader = LineReaderBuilder.builder().terminal(terminal).build();
        PrintWriter writer = terminal.writer();
        View view = new MazeViewImpl(terminal, lineReader, writer);
        MazeSolverController controller = new MazeSolverControllerImpl(view, new MazeSolverModelImpl());

        while (
            controller.start()
        ) {
        }
    }
}
