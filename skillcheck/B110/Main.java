import java.util.Scanner;

public class Main {
    // 数字を表すグリッドの1辺の長さ
    private static final int GRID_LEN = 3;
    // 横に並ぶグリッドの個数
    private static final int HORIZON_GRID_COUNT = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 入力
        final String[] input = sc.next().split("");
        // 入力値の数
        final int numCount = input.length;

        // 二次元バーコード作成
        boolean[][] barcode = new boolean[numCount][9];
        for(int i = 0; i < numCount; i++) {
            // 入力値
            int num = Integer.parseInt(input[i]);
            // 開始位置（左上）
            int startRowIdx = (i / HORIZON_GRID_COUNT) * GRID_LEN;
            int startColIdx = (i % HORIZON_GRID_COUNT) * GRID_LEN;
            // numの値分だけtrueにする
            for(int j = 0; j < num; j++) {
                int diffRow = j / GRID_LEN;
                int diffCol = j % GRID_LEN;
                barcode[startRowIdx + diffRow][startColIdx + diffCol] = true;
            }
        }

        // 出力
        for(boolean[] row : barcode) {
            for(boolean val : row) {
                System.out.print(val ? "#" : ".");
            }
            System.out.println();
        }
    }
}
