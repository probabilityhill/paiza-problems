import java.util.List;
import java.util.Scanner;

public class Main {
    // 前方向、右方向、後方向、左方向
    private static final List<String> DIRECTIONS = List.of("F", "R", "B", "L");
    // 方向を表すPoint
    private static final Point[] DIR_POINTS = new Point[] {new Point(0, 1), new Point(1, 0), new Point(0, -1), new Point(-1, 0)};
    // 命令「移動」
    private static final String MOVE = "m";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 開始地点
            final int startX = sc.nextInt();
            final int startY = sc.nextInt();

            // 各方向の移動距離
            final int[] dists = new int[DIRECTIONS.size()];
            for (int i = 0; i < dists.length; i++) {
                dists[i] = sc.nextInt();
            }

            // 命令の数
            final int N = sc.nextInt();
            // 現在地
            Point currPoint = new Point(startX, startY);
            // 現在向いている方向のインデックス
            int currDirIdx = 0;
            for (int i = 0; i < N; i++) {
                String command = sc.next();
                String dir = sc.next();

                // 命令された方向のインデックス（相対的な方向）
                int relativeDirIdx = DIRECTIONS.indexOf(dir);
                // 現在向いている方向を考慮した方向のインデックス（絶対的な方向）
                int dirIdx = (currDirIdx + relativeDirIdx) % DIRECTIONS.size();

                if (MOVE.equals(command)) {
                    // 指定された方向に進める距離だけ進む
                    currPoint.move(DIR_POINTS[dirIdx], dists[relativeDirIdx]);
                } else {
                    // 方向転換する
                    currDirIdx = dirIdx;
                }
            }
            // 到達地点を出力
            System.out.println(currPoint.getX() + " " + currPoint.getY());
        }
    }
}

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * dirの方向にdistだけ進む
     */
    public void move(Point dir, int dist) {
        this.x += dir.x * dist;
        this.y += dir.y * dist;
    }
}
