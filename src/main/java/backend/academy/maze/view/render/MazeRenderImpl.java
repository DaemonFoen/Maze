package backend.academy.maze.view.render;

import backend.academy.maze.controller.data.Cell;
import backend.academy.maze.controller.data.Cell.Type;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import java.util.List;
import static backend.academy.maze.view.render.MazeRenderUtils.ANSI_BROWN;
import static backend.academy.maze.view.render.MazeRenderUtils.ANSI_GOLD;
import static backend.academy.maze.view.render.MazeRenderUtils.ANSI_GREEN;
import static backend.academy.maze.view.render.MazeRenderUtils.ANSI_LIGHT_GRAY;
import static backend.academy.maze.view.render.MazeRenderUtils.ANSI_LIGHT_YELLOW;
import static backend.academy.maze.view.render.MazeRenderUtils.ANSI_RED_BOLD;
import static backend.academy.maze.view.render.MazeRenderUtils.ANSI_RESET;
import static backend.academy.maze.view.render.MazeRenderUtils.ANSI_YELLOW;
import static backend.academy.maze.view.render.MazeRenderUtils.COIN;
import static backend.academy.maze.view.render.MazeRenderUtils.MUD;
import static backend.academy.maze.view.render.MazeRenderUtils.PATH;
import static backend.academy.maze.view.render.MazeRenderUtils.ROAD;
import static backend.academy.maze.view.render.MazeRenderUtils.SAND;
import static backend.academy.maze.view.render.MazeRenderUtils.WALL;

public class MazeRenderImpl implements MazeRenderer {

    @Override
    public String renderWithPoints(Maze maze, Coordinate start, Coordinate end) {
        return renderMaze(maze, null, start, end);
    }

    @Override
    public String renderPath(Maze maze, List<Coordinate> path) {
        return renderMaze(maze, path, path.getFirst(), path.getLast());
    }

    @Override
    public String borders(int height, int width) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    private String renderMaze(Maze maze, List<Coordinate> path, Coordinate start, Coordinate end) {
        double cost = 0;

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < maze.height(); row++) {
            for (int col = 0; col < maze.width(); col++) {
                Coordinate current = new Coordinate(row, col);

                if (current.equals(start)) {
                    sb.append(ANSI_GREEN).append("S").append(ANSI_RESET);
                } else if (current.equals(end)) {
                    sb.append(ANSI_YELLOW).append("F").append(ANSI_RESET);
                } else if (maze.grid()[row][col].type() == Cell.Type.WALL) {
                    sb.append(ANSI_YELLOW).append(WALL).append(ANSI_RESET);
                } else if (path != null && path.contains(current)) {
                    cost += maze.grid()[current.row()][current.col()].type().getCost();
                    sb.append(ANSI_RED_BOLD).append(PATH).append(ANSI_RESET);
                } else {
                    // Отображаем тип поверхности клетки, если это проход
                    sb.append(renderSurface(maze.grid()[row][col].type()));
                }
            }
        }

        if (path != null) {
            sb.append("\n path cost = ").append(cost).append("\n");
        }
        return sb.toString();
    }

    private String renderSurface(Type type) {
        return switch (type) {
            case MUD -> ANSI_BROWN + MUD + ANSI_RESET;
            case SAND -> ANSI_LIGHT_YELLOW + SAND + ANSI_RESET;
            case COIN -> ANSI_GOLD + COIN + ANSI_RESET;
            case ROAD -> ANSI_LIGHT_GRAY + ROAD + ANSI_RESET;
            default -> " ";
        };
    }

}
