import java.util.*;

public class Main {
    // 上下左右の移動距離
    private static final int[][] MOVE_DIST = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int N = sc.nextInt();
        final int y = sc.nextInt();
        final int x = sc.nextInt();

        // 壁以外trueにする
        boolean[][] grid = new boolean[H + 2][W + 2];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                grid[i + 1][j + 1] = true;
            }
        }        
        
        // キュー作成
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(y, x, 0));
        grid[y + 1][x + 1] = false;

        // 幅優先探索
        while(!queue.isEmpty()) {
            Point currPoint = queue.poll();

            // 深さの上限に達したらはスキップ
            if(currPoint.depth >= N) {
                continue;
            }            

            // 1回の移動で到達可能なマスをキューに追加
            for(int[] dist : MOVE_DIST) {
                int nextPointY = currPoint.y + dist[0];
                int nextPointX = currPoint.x + dist[1];
                // 未到達の場合キューに追加し到達済みにする
                if(grid[nextPointY + 1][nextPointX + 1]) {
                    queue.add(new Point(nextPointY, nextPointX, currPoint.depth + 1));
                    grid[nextPointY + 1][nextPointX + 1] = false;
                }
            }
        }

        // グリッドを出力（到達済みはfalse）
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                sb.append(grid[i + 1][j + 1] ? "." : "*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

// 座標クラス
class Point {
    int y;
    int x;
    int depth;

    Point(int y, int x, int d) {
        this.y = y;
        this.x = x;
        this.depth = d;
    }
}
