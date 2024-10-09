package backend.academy.maze.controller.data;

public record Cell(int row, int col, Type type) {

    public enum Type {
        WALL(10000),
        NORMAL(3),
        MUD(7),
        SAND(5),
        COIN(0.1),
        ROAD(0.5);

        private final double cost;

        Type(double cost) {
            this.cost = cost;
        }

        public double getCost() {
            return cost;
        }
    }
}
