// 17

import java.util.*;

public class Main {
    private static int H, W;
    private static char[][] grid;

    private static final char WALL = '#';
    private static final char SPACE = '.';
    // 移動距離（上右下左）
    private static final int[][] MOVE_DIST = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();

        grid = new char[H][W];
        for(int i = 0; i < H; i++) {
            grid[i] = sc.next().toCharArray();
        }

        // 区画数
        int count = 0;

        // スペースがなくなるまでループ
        for(int y = 0; y < H; y++) {
            for(int x = 0; x < W; x++) {
                // スペースがあればその区画内をすべて壁にする
                if(grid[y][x] == SPACE) {
                    fillWithWall(y, x);
                    count++;
                }
            }
        }

        // 区画数を出力
        System.out.println(count);
    }

    //区画内をすべて壁にする（DFS）
    private static void fillWithWall(int y, int x) {

        grid[y][x] = WALL;

        for(int[] d : MOVE_DIST) {
            int nextY = y + d[0];
            int nextX = x + d[1];
            // グリッド内かつ壁でない場合
            if(canMove(nextY, nextX) && grid[nextY][nextX] == SPACE) {
                fillWithWall(nextY, nextX);
            }
        }
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }
}
