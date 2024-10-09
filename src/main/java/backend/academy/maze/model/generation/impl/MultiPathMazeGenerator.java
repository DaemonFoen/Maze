package backend.academy.maze.model.generation.impl;

import backend.academy.maze.controller.data.Cell;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import backend.academy.maze.model.generation.Generator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import static backend.academy.maze.model.ModelUtils.RANDOM;
import static backend.academy.maze.model.ModelUtils.isInBounds;
import static backend.academy.maze.model.generation.GeneratorUtils.randomDirection;
import static backend.academy.maze.model.generation.GeneratorUtils.randomSurface;

/**
 * Класс {@code MultiPathMazeGenerator} реализует алгоритм генерации лабиринта с множественными путями. Этот алгоритм
 * основывается на идее случайного поиска с возвратом (backtracking) с добавлением дополнительных путей для увеличения
 * ветвистости лабиринта.
 *
 * <p>Последовательность действий:
 * <ol>
 *     <li>Все клетки изначально задаются как стены.</li>
 *     <li>Стартовая точка лабиринта (1,1) становится проходом, и её соседи добавляются для обработки.</li>
 *     <li>На каждом шаге случайным образом выбирается соседняя клетка, которая может стать частью прохода.</li>
 *     <li>Если такая клетка найдена, между текущей и выбранной клеткой создается проход,
 *     а затем сосед добавляется в стек для дальнейшей обработки.</li>
 *     <li>Если доступных соседей нет, происходит возврат назад по стеку,
 *     пока не будет найдена клетка с доступными соседями.</li>
 *     <li>После завершения основного процесса генерации лабиринта добавляются дополнительные случайные пути
 *     между уже существующими проходами для увеличения ветвистости.</li>
 * </ol>
 */
public class MultiPathMazeGenerator implements Generator {

    private static final int ADDITIONAL_PATH_COEFFICIENT = 7;

    private static final int RANDOM_PATH_LENGTH_MAX_SIZE = 15;

    private final int[][] directions = {{0, 2}, {0, -2}, {2, 0}, {-2, 0}};

    @Override
    public Maze generate(int height, int width) {
        Cell[][] grid = new Cell[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = new Cell(row, col, Cell.Type.WALL);
            }
        }

        Coordinate start = new Coordinate(1, 1);
        grid[1][1] = new Cell(1, 1, randomSurface());

        List<Coordinate> allPassages = new ArrayList<>();
        allPassages.add(start);

        Deque<Coordinate> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Coordinate current = stack.peek();
            List<Coordinate> neighbors = new ArrayList<>();

            for (int[] direction : directions) {
                int newRow = current.row() + direction[0];
                int newCol = current.col() + direction[1];

                if (isInBounds(newRow, newCol, height, width) && grid[newRow][newCol].type() == Cell.Type.WALL) {
                    neighbors.add(new Coordinate(newRow, newCol));
                }
            }

            if (neighbors.isEmpty()) {
                stack.pop();
            } else {
                Coordinate neighbor = neighbors.get(RANDOM.nextInt(neighbors.size()));

                grid[(current.row() + neighbor.row()) / 2][(current.col() + neighbor.col()) / 2] =
                    new Cell((current.row() + neighbor.row()) / 2, (current.col() + neighbor.col()) / 2,
                        randomSurface());

                grid[neighbor.row()][neighbor.col()] =
                    new Cell(neighbor.row(), neighbor.col(), randomSurface());

                allPassages.add(neighbor);
                stack.push(neighbor);
            }
        }

        createAdditionalPaths(grid, allPassages, height, width);

        return new Maze(height, width, grid);
    }

    private void createAdditionalPaths(Cell[][] grid, List<Coordinate> passages, int height, int width) {
        int additionalPathsCount = passages.size() / ADDITIONAL_PATH_COEFFICIENT;

        for (int i = 0; i < additionalPathsCount; i++) {
            createRandomPath(grid, passages.get(RANDOM.nextInt(passages.size())), height, width);
        }
    }

    @SuppressWarnings("all")
    private void createRandomPath(Cell[][] grid, Coordinate start, int height, int width) {
        Coordinate current = new Coordinate(start.row(), start.col());

        int iteration = RANDOM.nextInt(RANDOM_PATH_LENGTH_MAX_SIZE);

        for (int i = 0; (i < iteration); i++) {
            int[] direction = randomDirection();
            if (current.row() + direction[0] > 0 && current.row() + direction[0] < height - 1
                && current.col() + direction[1] > 0 && current.col() + direction[1] < width - 1) {
                current = new Coordinate(current.row() + direction[0], current.col() + direction[1]);
                grid[current.row()][current.col()] =
                    new Cell(current.row(), current.col(), randomSurface());
            }
        }
    }

}

