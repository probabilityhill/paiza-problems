import java.util.Scanner;

public class Main {
    // 入力
    static final Scanner sc = new Scanner(System.in);
    static final int N = sc.nextInt();
    static final int H = sc.nextInt();
    static final int W = sc.nextInt();
    static int[][] board = new int[H][W];

    public static void main(String[] args) {
        // 色を塗る
        for(int i = 0; i < N; i++) {
            for(int j = 1; j <= 3; j++) {
                paint(j, sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
        }

        int[] countColor = new int[4]; 
        // 各プレイヤーのマスの数を数える
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                countColor[board[i][j]]++;
            }
        }

        // 出力
        System.out.printf("%d %d %d", countColor[1], countColor[2], countColor[3]);
    }

    public static void paint(int player, int x, int y, int len) {
        for(int i = y; i < Math.min(y + len, H); i++) {
            for(int j = x; j < Math.min(x + len, W); j++) {
                int currVal = board[i][j];
                board[i][j] = currVal == 0 || currVal == player ? player : -(currVal + player) + 6;
            }
        }
    }
}
