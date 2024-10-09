package backend.academy.maze.controller;

import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.model.MazeSolverModel;
import backend.academy.maze.view.View;
import java.io.IOException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MazeSolverControllerImpl implements MazeSolverController {

    private final View view;
    private final MazeSolverModel model;

    public MazeSolverControllerImpl(View view, MazeSolverModel model) {
        this.view = view;
        this.model = model;
    }

    private void menu() {
        while (model.sessionState() != SessionState.SOLVE) {
            int input = view.drawMenu(model.sessionState());
            try {
                model.updateState(input);
            } catch (IOException e) {
                view.printMessage(e.getMessage());
            }
        }
    }

    @Override
    public boolean start() {
        menu();

        int[] size = view.drawBorders();
        model.generateMaze(size[0], size[1]);

        Coordinate[] points = view.drawMazeForPositionSelection(model.maze());
        model.setStart(points[0]);
        model.setEnd(points[1]);

        Character ans = view.drawPath(model.maze(), model.path());

        return ans == 'Y';
    }
}
