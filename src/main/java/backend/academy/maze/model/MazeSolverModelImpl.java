package backend.academy.maze.model;

import backend.academy.maze.controller.SessionState;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import backend.academy.maze.model.generation.Generator;
import backend.academy.maze.model.generation.impl.MultiPathMazeGenerator;
import backend.academy.maze.model.generation.impl.PrimMazeGenerator;
import backend.academy.maze.model.solver.Solver;
import backend.academy.maze.model.solver.impl.AStarMazeSolver;
import backend.academy.maze.model.solver.impl.DijkstraMazeSolver;
import java.io.IOException;
import java.util.List;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MazeSolverModelImpl implements MazeSolverModel {

    private Solver solver = new DijkstraMazeSolver();
    private Generator generator = new MultiPathMazeGenerator();
    @Getter
    private Maze maze;
    private Coordinate start;
    private Coordinate end;
    @Getter
    private SessionState sessionState = SessionState.MAIN_MENU;

    @Override
    public Coordinate getStart() {
        return this.start;
    }

    @Override
    public void setStart(Coordinate start) {
        this.start = start;
    }

    @Override
    public Coordinate getEnd() {
        return this.end;
    }

    @Override
    public void setEnd(Coordinate end) {
        this.end = end;
    }

    @Override
    public void updateState(int input) throws IOException {
        sessionState = switch (sessionState) {
            case MAIN_MENU -> processMainMenuState(input);
            case GENERATION_ALGORITHMS -> processGenerationState(input);
            case PATHFINDING_ALGORITHMS -> processPathfindingState(input);
            case null, default -> throw new IllegalStateException("Unexpected value: " + sessionState);
        };
        if (sessionState == SessionState.CLOSE) {
            System.exit(0);
        }
    }

    @Override
    public void generateMaze(int height, int width) {
        maze = generator.generate(height, width);
    }

    @Override
    public List<Coordinate> path() {
        if (sessionState != SessionState.SOLVE) {
            throw new IllegalStateException("Unexpected state: " + sessionState);
        }
        log.debug("starting position: {}, end position: {}Solver: {}Generator: {}", start, end,
            solver.getClass().getName(), generator.getClass().getName());
        return solver.solve(maze, start, end);
    }

    @SuppressWarnings("all")
    private SessionState processPathfindingState(int input) throws IOException {
        solver = switch (input) {
            case 1 -> new AStarMazeSolver();
            case 2 -> new DijkstraMazeSolver();
            default -> throw new IOException("Invalid command");
        };
        log.debug("solver: {}", solver.getClass().getName());
        return SessionState.MAIN_MENU;
    }

    private SessionState processGenerationState(int input) throws IOException {
        generator = switch (input) {
            case 1 -> new MultiPathMazeGenerator();
            case 2 -> new PrimMazeGenerator();
            default -> throw new IOException("Invalid command");
        };
        log.debug("generator: {}", generator.getClass().getName());
        return SessionState.MAIN_MENU;
    }

    @SuppressWarnings("all")
    private SessionState processMainMenuState(int input) throws IOException {
        return switch (input) {
            case 1 -> SessionState.SOLVE;
            case 2 -> SessionState.GENERATION_ALGORITHMS;
            case 3 -> SessionState.PATHFINDING_ALGORITHMS;
            case 4 -> SessionState.CLOSE;
            default -> throw new IOException("Invalid command");
        };
    }

}
