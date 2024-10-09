package backend.academy.maze.model.generation.impl;

import backend.academy.maze.controller.data.Cell;
import backend.academy.maze.controller.data.Cell.Type;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import backend.academy.maze.model.generation.Generator;
import java.util.ArrayList;
import java.util.List;
import static backend.academy.maze.model.ModelUtils.RANDOM;
import static backend.academy.maze.model.generation.GeneratorUtils.randomSurface;

/**
 * Класс {@code PrimMazeGenerator} реализует алгоритм генерации лабиринта с использованием модифицированного алгоритма
 * Прима. Алгоритм Прима строит лабиринт, начиная с одной стартовой точки, последовательно добавляя стены, которые
 * соединяются с уже существующими проходами.
 *
 * <p>Последовательность действий:
 * <ol>
 *     <li>Инициализация сетки лабиринта: все клетки изначально являются стенами.</li>
 *     <li>Старт с начальной клетки (1,1) которая становится проходом, и добавление её соседних стен в список.</li>
 *     <li>На каждом шаге случайным образом выбирается стена из списка.</li>
 *     <li>Если у этой стены есть ровно один сосед-проход, она становится частью прохода.</li>
 *     <li>Новые соседние стены добавляются в список, если они ещё не были включены.</li>
 *     <li>Процесс продолжается до тех пор, пока список стен не будет пуст.</li>
 * </ol>
 */
public class PrimMazeGenerator implements Generator {

    private final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    @Override public Maze generate(int height, int width) {
        Cell[][] grid = new Cell[height][width];
        List<Coordinate> walls = new ArrayList<>();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = new Cell(row, col, Type.WALL);
            }
        }

        Coordinate start = new Coordinate(1, 1);
        grid[1][1] = new Cell(1, 1, randomSurface());
        addWallsAround(start, walls, height, width);

        while (!walls.isEmpty()) {
            int index = RANDOM.nextInt(walls.size());
            Coordinate wall = walls.get(index);

            List<Coordinate> neighbors = getPassageNeighbors(wall, grid, height, width);

            if (neighbors.size() == 1) {
                grid[wall.row()][wall.col()] = new Cell(wall.row(), wall.col(), randomSurface());
                addWallsAround(wall, walls, height, width);
            }

            walls.remove(index);
        }

        return new Maze(height, width, grid);
    }

    /**
     * Добавляет соседние клетки стены в список стен, если они находятся в пределах лабиринта.
     *
     * @param coordinate координата текущей клетки
     * @param walls      список стен, в который будут добавлены новые стены
     * @param height     высота лабиринта
     * @param width      ширина лабиринта
     */
    private void addWallsAround(Coordinate coordinate, List<Coordinate> walls, int height, int width) {
        for (int[] direction : directions) {
            int newRow = coordinate.row() + direction[0];
            int newCol = coordinate.col() + direction[1];
            if (newRow > 0 && newRow < height - 1 && newCol > 0 && newCol < width - 1) {
                if (walls.stream().noneMatch(w -> w.row() == newRow && w.col() == newCol)) {
                    walls.add(new Coordinate(newRow, newCol));
                }
            }
        }
    }

    /**
     * Возвращает список клеток, которые могут стать проходами, из соседей текущей клетки.
     *
     * @param wall   координата текущей стены
     * @param grid   сетка клеток лабиринта
     * @param height высота лабиринта
     * @param width  ширина лабиринта
     * @return список соседних клеток, которые являются проходами
     */
    private List<Coordinate> getPassageNeighbors(Coordinate wall, Cell[][] grid, int height, int width) {
        List<Coordinate> neighbors = new ArrayList<>();
        for (int[] direction : directions) {
            int newRow = wall.row() + direction[0];
            int newCol = wall.col() + direction[1];
            if (newRow > 0 && newRow < height && newCol > 0 && newCol < width) {
                if (grid[newRow][newCol].type() != Type.WALL) {
                    neighbors.add(new Coordinate(newRow, newCol));
                }
            }
        }
        return neighbors;
    }
}
