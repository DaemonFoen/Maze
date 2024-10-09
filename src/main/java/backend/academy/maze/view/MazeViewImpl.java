package backend.academy.maze.view;

import backend.academy.maze.controller.SessionState;
import backend.academy.maze.controller.data.Cell.Type;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import backend.academy.maze.view.render.MazeRenderImpl;
import backend.academy.maze.view.render.MazeRenderer;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;
import org.jline.utils.InfoCmp.Capability;
import static backend.academy.maze.view.MazeDrawUtils.HEIGHT_MAX;
import static backend.academy.maze.view.MazeDrawUtils.HEIGHT_MIN;
import static backend.academy.maze.view.MazeDrawUtils.WIDTH_MAX;
import static backend.academy.maze.view.MazeDrawUtils.WIDTH_MIN;

@Log4j2
public class MazeViewImpl implements View {

    private final Terminal terminal;

    private final LineReader lineReader;

    private final PrintWriter writer;

    private final MazeRenderer mazeRenderer = new MazeRenderImpl();

    public MazeViewImpl(Terminal terminal, LineReader lineReader, PrintWriter writer) {
        this.terminal = terminal;
        this.lineReader = lineReader;
        this.writer = writer;
    }

    private void clearScreen() {
        terminal.puts(Capability.clear_screen);
        terminal.flush();
    }

    @Override
    public int drawMenu(SessionState state) {
        while (true) {
            switch (state) {
                case MAIN_MENU -> writer.println(MazeDrawUtils.MENU);
                case GENERATION_ALGORITHMS -> writer.println(MazeDrawUtils.GENERATION_ALGORITHMS);
                case PATHFINDING_ALGORITHMS -> writer.println(MazeDrawUtils.PATHFINDING_ALGORITHMS);
                default -> throw new IllegalStateException("State SOLVE cannot be in main menu");
            }
            try {
                int ans = Integer.parseInt(lineReader.readLine());
                clearScreen();
                return ans;
            } catch (NumberFormatException e) {
                clearScreen();
                printMessage("Please enter a number");
            }

        }
    }

    @Override
    @SuppressWarnings("all")
    public Coordinate[] drawMazeForPositionSelection(Maze maze) {
        clearScreen();
        while (true) {
            writer.println(mazeRenderer.renderWithPoints(maze, null, null));

            printMessage("Enter starting and ending position (example: 1 1 13 155) ");

            try {
                int[] ans = Arrays.stream(lineReader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

                if (ans[0] < 1 || ans[0] > maze.height() - 2) {
                    throw new NumberFormatException("Height of start must be between 1 and " + (maze.height() - 1));
                } else if (ans[1] < 1 || ans[1] > maze.width() - 2) {
                    throw new NumberFormatException("Width of start must be between 1 and " + (maze.width() - 1));
                } else if (ans[2] < 1 || ans[2] > maze.height() - 2) {
                    throw new NumberFormatException("Width of end must be between 1 and " + (maze.height() - 1));
                } else if (ans[3] < 1 || ans[3] > maze.width() - 2) {
                    throw new NumberFormatException("Width of end must be between 1 and " + (maze.width() - 1));
                }

                if (maze.grid()[ans[0]][ans[1]].type() == Type.WALL
                    || maze.grid()[ans[2]][ans[3]].type() == Type.WALL) {
                    throw new IllegalArgumentException("Path cannot start from the wall position");
                }

                Coordinate[] points = new Coordinate[] {
                    new Coordinate(ans[0], ans[1]),
                    new Coordinate(ans[2], ans[3])
                };

                writer.println(mazeRenderer.renderWithPoints(maze, points[0], points[1]));
                if (question("Start and end in correct positions? (y/n)") == 'Y') {
                    return points;
                }
            } catch (IllegalArgumentException e) {
                clearScreen();
                printMessage(e.getMessage());
            }
        }

    }

    @Override
    public Character drawPath(Maze maze, List<Coordinate> coordinateList) {
        log.debug("path: {}", coordinateList);
        clearScreen();
        if (coordinateList.isEmpty()) {
            writer.println("Oops... search algorithm could not find a path between two points");
        } else {
            writer.println(mazeRenderer.renderPath(maze, coordinateList));
        }
        return question("Retry? (y/n)");
    }

    @Override
    public int[] drawBorders() {
        clearScreen();
        while (true) {
            printMessage("Enter maze size: <Height,Weight> (Example: 15 157)");
            printMessage("Max height 30, Min height 5, Max width 200, Min width 10");

            try {
                int[] ans = Arrays.stream(lineReader.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

                if (ans[0] < HEIGHT_MIN || ans[0] > HEIGHT_MAX) {
                    throw new NumberFormatException("Height must be between 5 and 30");
                } else if (ans[1] < WIDTH_MIN || ans[1] > WIDTH_MAX) {
                    throw new NumberFormatException("Weight must be between 10 and 200");
                }
                writer.println(mazeRenderer.borders(ans[0], ans[1]));
                if (question("Maze size correct? (y/n)") == 'Y') {
                    return ans;
                }
            } catch (NumberFormatException e) {
                clearScreen();
                printMessage(e.getMessage());
            }
        }
    }

    private Character question(String question) {
        printMessage(question);
        while (true) {
            String ans = lineReader.readLine();
            if (ans.length() == 1 && Character.isLetter(
                ans.toCharArray()[0]) && (Character.toUpperCase(ans.toCharArray()[0]) == 'Y'
                || Character.toUpperCase(ans.toCharArray()[0]) == 'N')) {
                return Character.toUpperCase(ans.toCharArray()[0]);
            } else {
                printMessage("Incorrect answer.");
            }
        }
    }

    @Override
    public void printMessage(String error) {
        writer.println(error);
    }
}
