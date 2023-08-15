// 42

import java.util.Scanner;

public class Main {
    private static final char SPACE = '.';
    private static final char WALL = '#';
    private static final int[][] MOVE_DIST = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static char[][] grid;
    private static int H, W;
    private static boolean canEscape = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();

        int y = 0;
        int x = 0;

        // グリッドを入力
        grid = new char[H][W];
        for(int i = 0; i < H; i++) {
            char[] row = sc.next().toCharArray();
            grid[i] = row;
            for(int j = 0; j < W; j++) {
                // 開始位置を記録
                if(row[j] == 'S') {
                    y = i;
                    x = j;
                }
            }
        }

        // 深さ優先探索
        dfs(y, x);

        // 結果を出力
        System.out.println(canEscape ? "YES" : "NO");
    }

    private static void dfs(int y, int x) {

        // 訪問した場所は壁にする
        grid[y][x] = WALL;

        // 範囲内かつ壁でなければ探索する
        int nextY, nextX;
        for(int[] d : MOVE_DIST) {
            nextY = y + d[0];
            nextX = x + d[1];

            // 範囲外であれば脱出可能
            if(!isInRange(nextY, nextX)) {
                canEscape = true;
                return;
            }

            if(grid[nextY][nextX] == SPACE) {
                dfs(nextY, nextX);
            }
        }
    }

    // グリッドの範囲内であるかどうか
    private static boolean isInRange(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }
}
