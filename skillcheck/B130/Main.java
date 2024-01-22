import java.util.Scanner;

public class Main {
    // ブロックの最大長
    private static final int MAX_BLOCK_LEN = 3;
    // 回転数
    private static final int ROTATION_NUM = 3;
    // 物体(箱の障害物またはブロック）のある部分
    private static final char OBJECT = '#';
    // 箱の盤面の高さと幅
    private static int boxHeight, boxWidth;
    // 箱の盤面
    private static boolean[][] box;
    // ブロックの盤面(0°,90°,180°,270°回転)の配列
    private static boolean[][][] blocks;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 箱の盤面の高さと幅を設定
            boxHeight = sc.nextInt();
            boxWidth = sc.nextInt();

            // 箱の盤面を作成
            box = new boolean[boxHeight][boxWidth];
            inputGrid(sc, boxHeight, boxWidth, box);

            // ブロックの盤面の配列を作成
            blocks = new boolean[ROTATION_NUM + 1][MAX_BLOCK_LEN][MAX_BLOCK_LEN];
            inputGrid(sc, MAX_BLOCK_LEN, MAX_BLOCK_LEN, blocks[0]);
            // ブロックを回転して配列に追加
            for (int i = 0; i < ROTATION_NUM; i++) {
                blocks[i + 1] = rotate(blocks[i]);
            }

            // 箱の盤面上でブロックを動かす回数
            final int rowMoveNum = Math.max(boxHeight, MAX_BLOCK_LEN) - MAX_BLOCK_LEN + 1;
            final int colMoveNum = Math.max(boxWidth, MAX_BLOCK_LEN) - MAX_BLOCK_LEN + 1;

            // ブロックを挿入できるか判定する
            boolean isBlockInsertable = checkBlockInsertion(rowMoveNum, colMoveNum);
            System.out.println(isBlockInsertable ? "Yes" : "No");
        }
    }

    // (n,m)の盤面を入力(物体のある部分をtrueとする)
    private static void inputGrid(Scanner sc, int n, int m, boolean[][] grid) {
        for (int ri = 0; ri < n; ri++) {
            String row = sc.next();
            for (int ci = 0; ci < m; ci++) {
                grid[ri][ci] = row.charAt(ci) == OBJECT;
            }
        }
    }

    // 盤面を時計回りに90°回転する
    private static boolean[][] rotate(boolean[][] grid) {
        boolean[][] newGrid = new boolean[MAX_BLOCK_LEN][MAX_BLOCK_LEN];
        for (int ri = 0; ri < MAX_BLOCK_LEN; ri++) {
            for (int ci = 0; ci < MAX_BLOCK_LEN; ci++) {
                newGrid[ri][ci] = grid[MAX_BLOCK_LEN - ci - 1][ri];
            }
        }
        return newGrid;
    }

    // 障害物のある箱にブロックを挿入できるか判定する
    private static boolean checkBlockInsertion(int rowMoveNum, int colMoveNum) {
        // ブロックの盤面全パターンをループする
        for (boolean[][] block : blocks) {
            // 箱の盤面にブロックを当てはめていく
            for (int ri = 0; ri < rowMoveNum; ri++) {
                for (int ci = 0; ci < colMoveNum; ci++) {
                    if (canInsertBlock(ri, ci, block)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 指定したブロックを箱に挿入できるかどうか
    private static boolean canInsertBlock(int boxRowIdx, int boxColIdx, boolean[][] block) {
        for (int ri = 0; ri < MAX_BLOCK_LEN; ri++) {
            for (int ci = 0; ci < MAX_BLOCK_LEN; ci++) {
                // ブロックのあるマスが箱の障害物または範囲外と重なる場合は挿入不可
                if (block[ri][ci] && (boxRowIdx + ri >= boxHeight || boxColIdx + ci >= boxWidth || box[boxRowIdx + ri][boxColIdx + ci])) {
                    return false;
                }
            }
        }
        return true;
    }
}
