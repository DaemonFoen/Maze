package maze.testUtils;

import backend.academy.maze.controller.data.Cell;
import backend.academy.maze.controller.data.Cell.Type;
import backend.academy.maze.controller.data.Maze;

public final class MazeTestUtils {

    private MazeTestUtils() {
    }

    /**
     * Создаёт заранее определённый лабиринт, который всегда имеет одно и то же решение (уникальное для каждого) для
     * алгоритма Дейкстры и A*
     */
    public static Maze createExampleMaze() {
        int height = 14;
        int width = 60;

        Cell[][] grid = new Cell[height][width];

        String[] layout = {
            "############################################################",
            "#S.GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG##",
            "##..#####################################################G##",
            "###..####GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG##",
            "####..###G##################################################",
            "#####..##GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG###",
            "######..################################################.###",
            "#######.####GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG.GGGGGGG###",
            "#######..###.###############################################",
            "########.###GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG.##",
            "########.################################################.##",
            "########.......GGGGGGGGGGG.######GGGGGGGGGGGGG###########.##",
            "##########################GGGGGGGG###########.GGGGGGGGGGG..#",
            "############################################################"
        };

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                char ch = layout[row].charAt(col);
                if (ch == '#') {
                    grid[row][col] = new Cell(row, col, Cell.Type.WALL);
                } else if (ch == 'G') {
                    grid[row][col] = new Cell(row, col, Type.COIN);
                } else {
                    grid[row][col] = new Cell(row, col, Type.NORMAL);
                }
            }
        }

        return new Maze(height, width, grid);
    }
}
