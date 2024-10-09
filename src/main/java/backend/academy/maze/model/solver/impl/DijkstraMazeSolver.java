package backend.academy.maze.model.solver.impl;

import backend.academy.maze.controller.data.Cell;
import backend.academy.maze.controller.data.Coordinate;
import backend.academy.maze.controller.data.Maze;
import backend.academy.maze.model.solver.Solver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import static backend.academy.maze.model.solver.SolverUtils.getNeighbors;

/**
 * Класс {@code DijkstraMazeSolver} реализует алгоритм поиска кратчайшего пути в лабиринте с использованием алгоритма
 * Дейкстры. Алгоритм находит кратчайший путь от начальной клетки до конечной, основываясь на стоимости клеток в
 * лабиринте.
 *
 * <p>Последовательность действий:
 * <ol>
 *     <li>Инициализация очереди с приоритетом, в которой выбирается клетка
 *     с наименьшей стоимостью для дальнейшей обработки.</li>
 *     <li>Из каждой текущей клетки алгоритм рассматривает соседние клетки,
 *     вычисляет стоимость перемещения и обновляет их стоимость в случае, если найден более оптимальный путь.</li>
 *     <li>Если конечная клетка достигнута, восстанавливается путь от начала
 *     до конца с помощью таблицы предыдущих клеток (cameFrom).</li>
 *     <li>Если пути до конечной клетки не существует, возвращается пустой список.</li>
 * </ol>
 */
public class DijkstraMazeSolver implements Solver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        if (start == null || end == null) {
            throw new IllegalStateException("Start and end coordinates must be non-null");
        }

        final Map<Coordinate, Double> costSoFar = new HashMap<>();
        final Map<Coordinate, Coordinate> cameFrom = new HashMap<>();
        final Set<Coordinate> visited = new HashSet<>();
        final PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(Node::getCost));

        queue.add(new Node(start, 0));
        costSoFar.put(start, 0.0);
        cameFrom.put(start, null);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            Coordinate current = currentNode.coordinate;

            if (current.equals(end)) {
                return reconstructPath(cameFrom, end);
            }

            visited.add(current);

            for (Coordinate neighbor : getNeighbors(maze, current)) {
                if (visited.contains(neighbor)) {
                    continue;
                }

                Cell neighborCell = maze.grid()[neighbor.row()][neighbor.col()];
                double newCost = costSoFar.get(current) + neighborCell.type().getCost();

                if (!costSoFar.containsKey(neighbor) || newCost < costSoFar.get(neighbor)) {
                    costSoFar.put(neighbor, newCost);
                    queue.add(new Node(neighbor, newCost));
                    cameFrom.put(neighbor, current);
                }
            }
        }
        return Collections.emptyList();
    }

    private List<Coordinate> reconstructPath(Map<Coordinate, Coordinate> cameFrom, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate current = end;
        while (current != null) {
            path.add(current);
            current = cameFrom.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    private static class Node {

        Coordinate coordinate;
        double cost;

        Node(Coordinate coordinate, double cost) {
            this.coordinate = coordinate;
            this.cost = cost;
        }

        double getCost() {
            return cost;
        }
    }
}
