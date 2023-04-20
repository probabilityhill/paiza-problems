import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    static class Point {
        int level, y, x;
        Point(int level, int y, int x) {
            this.level = level;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int N = sc.nextInt();
        final int Y_START = sc.nextInt();
        final int X_START = sc.nextInt();
        // グリッドを入力
        final String[][] GRID = new String[H][W];
        for (int i = 0; i < H; i++) {
            GRID[i] = sc.next().split("");
        }
        GRID[Y_START][X_START] = "*";
        // 到達可能なマスを管理するキュー
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, Y_START, X_START));
        // キューが空になるまで繰り返し
        while (!queue.isEmpty()) {
            Point p = queue.poll();  // 先頭の点を取得＆削除
            // 深さNであれば移動しない
            if (p.level >= N) {
                continue;
            }
            // 移動先がグリッドの範囲内かつ未到達かつ壁でない場合はキューに追加し到達済みにする
            for (int i = -1; i <= 1; i += 2) {
                // 上下の移動
                if (0 <= p.y + i && p.y + i <= H - 1 && GRID[p.y + i][p.x].equals(".")) {
                    queue.add(new Point(p.level + 1, p.y + i, p.x));
                    GRID[p.y + i][p.x] = "*";
                }
                // 左右の移動
                if (0 <= p.x + i && p.x + i <= W - 1 && GRID[p.y][p.x + i].equals(".")) {
                    queue.add(new Point(p.level + 1, p.y, p.x + i));
                    GRID[p.y][p.x + i] = "*";
                }
            }
        }

        for (int i = 0; i < H; i++) {
            System.out.println(String.join("", GRID[i]));
        }
    }
}
