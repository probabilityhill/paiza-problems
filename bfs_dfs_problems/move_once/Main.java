import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int Y = sc.nextInt();
        final int X = sc.nextInt();
        final boolean[][] GRID = new boolean[H + 2][W + 2];
        
        // 到達可能なマスを記録
        GRID[Y + 1][X + 1] = true;  // 現在いるマス
        GRID[Y][X + 1] = true;
        GRID[Y + 1][X] = true;
        GRID[Y + 2][X + 1] = true;
        GRID[Y + 1][X + 2] = true;

        // グリッドを出力
        String output;
        for(int i = 1; i < H + 1; i++) {
            for(int j = 1; j < W + 1; j++) {
                if(GRID[i][j]) {
                    output = "*";
                }
                else {
                    output = ".";
                }
                System.out.print(output);
            }
            System.out.println();
        }
    }
}
