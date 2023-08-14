// 28

import java.util.*;

public class Main {
    private static final int MAX_DIST = 3;
    // 移動距離（左下右上）
    private static final int[][] MOVE_DIST = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int y = sc.nextInt();
        final int x = sc.nextInt();

        // 壁を作る
        boolean[][] grid = new boolean[H + 2][W + 2];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                grid[i + 1][j + 1] = true;
            }
        }

        // 到達点記録用
        List<Point> ansPoints = new ArrayList<>();

        // キュー
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(y, x, 0));

        while(!queue.isEmpty()) {
            Point currPoint = queue.poll();

            // 上限に達したら場所を記録しスキップ
            if(currPoint.dist == MAX_DIST) {
                ansPoints.add(currPoint);
                continue;
            }

            // 壁でない場合はキューに追加
            for(int[] dist : MOVE_DIST) {
                int targetY = currPoint.y + dist[0];
                int targetX = currPoint.x + dist[1];

                if(grid[targetY + 1][targetX + 1]) {
                    queue.addFirst(new Point(targetY, targetX, currPoint.dist + 1));
                }
            }
        }

        // 出力
        for(Point p : ansPoints) {
            System.out.println(p.y + " " + p.x);
        }
    }
}

class Point {
    int y, x, dist;

    Point(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}
