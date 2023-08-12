// 80

import java.util.*;

public class Main {
    static final int[][] KING_MOVE_AMOUNT = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int[][] BISHOP_MOVE_AMOUNT = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    // 入力（定数）
    static final Scanner sc = new Scanner(System.in);
    static final int N = sc.nextInt();
    static final int START_ROW_IDX = sc.nextInt() - 1;
    static final int START_COL_IDX = sc.nextInt() - 1;
    static final int K = sc.nextInt();

    static int[][] board = new int[N][N];
    static boolean[][] checked = new boolean[N][N];

    public static void main(String[] args) {

        int reachableCellCount = 0;

        // Bishopの動きに注目すると試行回数2回で盤面の半分のマスに到達可能（市松模様）
        // Kingの動きも加味すると試行回数3回で全てのマスに到達可能
        if(K >= 3) {
            reachableCellCount = N * N;
        }
        else {
            // 到達可能な場所を1にする
            board[START_ROW_IDX][START_COL_IDX] = 1;
            move(START_ROW_IDX, START_COL_IDX, 1);

            for(int[] row : board) {
                for(int cell : row) {
                    reachableCellCount += cell;
                }
            }
        }

        // 出力
        System.out.println(reachableCellCount);
    }

    
    private static void move(int currRowIdx, int currColIdx, int moveCount) {
        if(moveCount > K) {
            return;
        }

        checked[currRowIdx][currColIdx] = true;

        // キングの動きをする
        for(int[] moveAmount : KING_MOVE_AMOUNT) {
            int nextRowIdx = currRowIdx + moveAmount[0];
            int nextColIdx = currColIdx + moveAmount[1];
            if(canPut(nextRowIdx, nextColIdx)) {
                board[nextRowIdx][nextColIdx] = 1;
                move(nextRowIdx, nextColIdx, moveCount + 1);
            }
        }

        // ビショップの動きをする
        for(int[] moveAmount : BISHOP_MOVE_AMOUNT) {
            int nextRowIdx = currRowIdx + moveAmount[0];
            int nextColIdx = currColIdx + moveAmount[1];
            while(canPut(nextRowIdx, nextColIdx)) {
                board[nextRowIdx][nextColIdx] = 1;
                move(nextRowIdx, nextColIdx, moveCount + 1);
                nextRowIdx += moveAmount[0];
                nextColIdx += moveAmount[1];
            }
        }
    }

    // boardの範囲内かつ未到達かどうか
    private static boolean canPut(int rowIdx, int colIdx) {
        return rowIdx >= 0 && rowIdx < N && colIdx >= 0 && colIdx < N && !checked[rowIdx][colIdx];
    }
}
