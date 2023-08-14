import java.util.*;

public class Main {
    private static int H, W;
    private static final int MAX_DIST = 3;
    // 移動距離（上右下左）
    private static final int[][] MOVE_DIST = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        final int y = sc.nextInt();
        final int x = sc.nextInt();

        // 再帰処理
        dfs(y, x, 0);
    }

    private static void dfs(int y, int x, int dist) {

        // 最大距離に達したら位置を出力し終了
        if(dist == MAX_DIST) {
            System.out.println(y + " " + x);
            return;
        }

        for(int[] d : MOVE_DIST) {
            int nextY = y + d[0];
            int nextX = x + d[1];
            if(canMove(nextY, nextX)) {
                dfs(nextY, nextX, dist + 1);
            }
        }
    }

    private static boolean canMove(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }
}
