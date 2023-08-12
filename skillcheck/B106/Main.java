// 28

import java.util.*;

public class Main {
    private static final int TOTAL_ALPHABET = 26;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int N = sc.nextInt();

        final int[][] seat = new int[H][W];

        // 各列の次に座る行のインデックス
        final int[] nextRowIdxs = new int[W];

        // 座席に生徒番号を記録
        for(int stuNo = 1; stuNo <= N; stuNo++) {
            int seatNo = sc.nextInt();
            int rowIdx = (seatNo - 1) / W;
            int colIdx = (seatNo - 1) % W;
            seat[rowIdx][colIdx] = stuNo;
        }

        // 各列ごとに前に席を詰める
        for(int ci = 0; ci < W; ci++) {
            // 次に詰めるべき座席の行
            int nextRowIdx = 0;

            for(int ri = 0; ri < H; ri++) {
                int stuNo = seat[ri][ci];
                if(stuNo == 0) {
                    continue;
                }
                
                // 前の席が空席であれば前に詰める
                if(nextRowIdx < ri) {
                    seat[ri][ci] = 0;
                    seat[nextRowIdx][ci] = stuNo;
                }
                nextRowIdx++;
            }
        }

        // 座席を出力
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                System.out.print(seat[i][j]);

                if(j != W - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
