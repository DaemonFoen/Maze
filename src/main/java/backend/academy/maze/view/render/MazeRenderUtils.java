package backend.academy.maze.view.render;

public final class MazeRenderUtils {

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_RED_BOLD = "\u001B[1;31m";
    static final String ANSI_BROWN = "\u001B[38;5;94m";
    static final String ANSI_LIGHT_YELLOW = "\u001B[38;5;228m";
    static final String ANSI_GOLD = "\u001B[38;5;220m";
    static final String ANSI_LIGHT_GRAY = "\u001B[38;5;250m";
    static final String MUD = "▒";
    static final String SAND = "░";
    static final String COIN = "$";
    static final String ROAD = ".";
    static final String WALL = "█";
    static final String PATH = "*";

    private MazeRenderUtils() {
    }
}
