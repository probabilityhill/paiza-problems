import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int stampHeight = sc.nextInt();
            final int stampWidth = sc.nextInt();
            final int stampCount = sc.nextInt();

            // スタンプ配列
            final String[][] stamps = new String[stampCount][stampHeight];
            for (int stampIdx = 0; stampIdx < stampCount; stampIdx++) {
                for (int stampRow = 0; stampRow < stampHeight; stampRow++) {
                    stamps[stampIdx][stampRow] = sc.next();
                }
            }

            final int planHeight = sc.nextInt();
            final int planWidth = sc.nextInt();

            // 計画
            final int[][] plan = new int[planHeight][planWidth];
            for (int planRow = 0; planRow < planHeight; planRow++) {
                for (int planCol = 0; planCol < planWidth; planCol++) {
                    // スタンプのインデックスを保存（0-based）
                    plan[planRow][planCol] = sc.nextInt() - 1;
                }
            }

            // 計画に従ってスタンプを出力する
            StringBuilder output = new StringBuilder();
            // 計画縦ループ
            for (int planRow = 0; planRow < planHeight; planRow++) {
                // スタンプ縦ループ
                for (int stampRow = 0; stampRow < stampHeight; stampRow++) {
                    // 計画横ループ
                    for (int planCol = 0; planCol < planWidth; planCol++) {
                        final int stampIdx = plan[planRow][planCol];
                        // <stampIdx>番目のスタンプの<stampRow>行目
                        output.append(stamps[stampIdx][stampRow]);
                    }
                    // 改行
                    output.append("\n");
                }
            }
            System.out.println(output);
        }
    }
}
