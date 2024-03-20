import java.util.Scanner;

public class Main {
    private static class CELL {
        private static final String BLACK = "B";
        private static final String WHITE = "W";
        private static final String EMPTY = ".";
    }
    private static final Point[] DIRECTIONS = new Point[] {new Point(-1, 0), new Point(-1, 1), new Point(0, 1), new Point(1, 1), new Point(1, 0), new Point(1, -1), new Point(0, -1), new Point(-1, -1)};
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int N = sc.nextInt();
            final String[][] board = new String[N][N];
            for (int y = 0; y < N; y++) {
                board[y] = sc.next().split("");
            }

            int placeableCellCount = 0;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    String cell = board[y][x];
                    if (!CELL.EMPTY.equals(cell)) {
                        continue;
                    }
                    boolean isPlaceable = false;
                    for (Point dir : DIRECTIONS) {
                        if (isPlaceable) {
                            break;
                        }
                        Point currPoint = new Point(y, x);
                        boolean isWhitePlaced = false;
                        while (true) {
                            currPoint.move(dir);
                            if (!inBoard(currPoint, N)) {
                                break;
                            }
                            String currCell = board[currPoint.y][currPoint.x];
                            if (CELL.WHITE.equals(currCell)) {
                                isWhitePlaced = true;
                                continue;
                            }
                            if (isWhitePlaced && CELL.BLACK.equals(currCell)) {
                                isPlaceable = true;
                                placeableCellCount++;
                            }
                            break;
                        }
                    }
                }

            }

            System.out.println(placeableCellCount);
        }
    }

    private static boolean inBoard(Point p, int n) {
        return p.x >= 0 && p.x < n && p.y >= 0 && p.y < n;
    }
}

class Point {
    int y;
    int x;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public void move(Point dir) {
        this.y += dir.y;
        this.x += dir.x;
    }
}
