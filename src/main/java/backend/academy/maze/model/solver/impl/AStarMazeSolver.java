package backend.academy.maze.model.solver.impl;

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
 * Класс {@code AStarPathfinder} реализует алгоритм поиска кратчайшего пути в лабиринте с использованием алгоритма A*
 * (A-star). A* комбинирует фактическую стоимость пути (g-стоимость) с эвристической оценкой (в данном случае
 * Манхэттенское расстояние) расстояния (h-стоимость) для поиска оптимального пути.
 *
 * <p>Последовательность действий:
 * <ol>
 *     <li>Инициализация очереди открытых узлов с приоритетом по f-стоимости (g + h),
 *     которая управляет выбором узлов для обработки.</li>
 *     <li>Извлечение узла с наименьшей f-стоимостью для дальнейшей обработки
 *     и добавление его в множество закрытых узлов.</li>
 *     <li>Рассмотрение каждого соседа текущего узла и обновление его g-стоимости,
 *     если найден более короткий путь к нему.</li>
 *     <li>Если достигнута конечная точка, происходит реконструкция пути от финиша к старту
 *     с помощью родительских узлов.</li>
 *     <li>Если путь не найден, возвращается пустой список.</li>
 * </ol>
 */
public class AStarMazeSolver implements Solver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(Node::getF));
        Set<Coordinate> closedSet = new HashSet<>();

        Map<Coordinate, Double> gScore = new HashMap<>();

        gScore.put(start, 0.0);
        openSet.add(new Node(start, 0.0, heuristic(start, goal), null));

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.coordinate.equals(goal)) {
                return reconstructPath(current);
            }

            closedSet.add(current.coordinate);

            for (Coordinate neighbor : getNeighbors(maze, current.coordinate)) {
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                double tentativeGScore = gScore.get(current.coordinate) + movementCost(maze, neighbor);

                if (tentativeGScore < gScore.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    gScore.put(neighbor, tentativeGScore);
                    double fScoreForNeighbor = tentativeGScore + heuristic(neighbor, goal);
                    openSet.add(new Node(neighbor, tentativeGScore, fScoreForNeighbor, current));
                }
            }
        }

        return Collections.emptyList();
    }

    private List<Coordinate> reconstructPath(Node node) {
        List<Coordinate> path = new ArrayList<>();
        Node current = node;
        while (current != null) {
            path.add(current.coordinate);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    private double heuristic(Coordinate a, Coordinate b) {
        return Math.abs(a.row() - b.row()) + Math.abs(a.col() - b.col());
    }

    private double movementCost(Maze maze, Coordinate coord) {
        return maze.grid()[coord.row()][coord.col()].type().getCost();
    }

    private static class Node {

        Coordinate coordinate;
        double g;
        double f;
        Node parent;

        Node(Coordinate coordinate, double g, double f, Node parent) {
            this.coordinate = coordinate;
            this.g = g;
            this.f = f;
            this.parent = parent;
        }

        public double getF() {
            return f;
        }
    }
}
