import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final String[] input = sc.next().split("");
        // 入力値の数
        final int numCount = input.length;
        // 入力値をint型配列に変換
        final int[] nums = new int[numCount];
        for(int i = 0; i < numCount; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        // 二次元バーコード作成
        boolean[][] barcode = new boolean[numCount][9];
        for(int i = 0; i < numCount; i++) {
            int num = nums[i];
            // 開始位置（左上）
            int startRowIdx = (i / 3) * 3;
            int startColIdx = (i % 3) * 3;
            // numの値分だけtrueにする
            for(int j = 0; j < num; j++) {
                int diffRow = j / 3;
                int diffCol = j % 3;
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
