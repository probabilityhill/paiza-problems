import java.util.*;

public class Main {
    // 移動距離
    private static final int[][] MOVE_DIST = {{-1, 0}, {1, 0}, {0, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int y = sc.nextInt();
        final int x = sc.nextInt();

        // 壁を作る（false）
        boolean[][] grid = new boolean[H + 2][W + 2];

        // 1回の移動で到達可能なマスをtrueにする
        for(int[] dist : MOVE_DIST) {
            grid[y + dist[0] + 1][x + dist[1] + 1] = true;
        }

        // グリッドを出力
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                sb.append(grid[i + 1][j + 1] ? "*" : ".");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
