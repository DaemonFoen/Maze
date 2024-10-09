package backend.academy.maze.view;

import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
@SuppressWarnings("all")
public class MazeDrawUtils {

    public static final int HEIGHT_MIN = 5;
    public static final int HEIGHT_MAX = 30;
    public static final int WIDTH_MIN = 10;
    public static final int WIDTH_MAX = 200;

    public static final String MENU = """
        #########################################################
        #                                                       #
        #                === Maze solver ===                    #
        #                                                       #
        #              1. Start                                 #
        #             --------------------                      #
        #              2. Select maze generation algorithm      #
        #             --------------------                      #
        #              3. Select maze pathfinding algorithm     #
        #             --------------------                      #
        #              4. Exit                                  #
        #                                                       #
        #                                                       #
        #                                                       #
        #########################################################
        """;

    public static final String GENERATION_ALGORITHMS = """
        #########################################################
        #                                                       #
        #                === Maze generation ===                #
        #                                                       #
        #                 1. Multipath Backtaking               #
        #                -----------------------                #
        #                 2. Prim                               #
        #                -----------------------                #
        #                                                       #
        #                                                       #
        #      Select your algorithm(Multipath by default):     #
        #########################################################
        """;

    public static final String PATHFINDING_ALGORITHMS = """
        #########################################################
        #                                                       #
        #                === Maze pathfinding ===               #
        #                                                       #
        #                 1. A-Star                             #
        #                --------------------                   #
        #                 2. Dijkstra                           #
        #                                                       #
        #                                                       #
        #                                                       #
        #        Select your algorithm(Dijkstra by default):    #
        #########################################################
        """;

    @Deprecated
    private static String drawEnding(boolean isWin) {
        if (isWin) {
            return "#" + " ".repeat(14) + "You win, play again?(y/n)" + " ".repeat(16) + "#\n";
        } else {
            return "#" + " ".repeat(21) + "Retry?(y/n)" + " ".repeat(23) + "#\n";
        }
    }

    @Deprecated
    private static String drawHint(String hint) {
        int totalWidth = 57;
        int paddingSpace = totalWidth - 8;
        StringBuilder result = new StringBuilder();
        int start = 0;
        while (start < hint.length()) {
            int end = Math.min(start + paddingSpace, hint.length());
            String line = hint.substring(start, end);
            int paddingRight = paddingSpace - line.length();
            result.append("#    ").append(line).append(" ".repeat(paddingRight)).append("  #\n");
            start += paddingSpace;
        }

        return result.toString();
    }

    @Deprecated
    public static String drawCategories(List<String> categories) {
        int size = 42;
        StringBuilder template = new StringBuilder();

        for (int i = 0; i < categories.size(); i++) {
            template.append("#").append(" ".repeat(10)).append("%d. %s".formatted(i + 1, categories.get(i)))
                .append(" ".repeat(size - categories.get(i).length())).append("#\n");
        }
        return template.toString();
    }
}
