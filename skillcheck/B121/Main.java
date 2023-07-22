import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        String[][] tile = new String[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                tile[i][j] = sc.next();
            }
        }
        final int rowIdx = sc.nextInt() - 1;
        final int colIdx = sc.nextInt() - 1;
        final int len = sc.nextInt();
        final int degree = sc.nextInt();

        if(degree != 0 || degree != 360) {
            final int count = degree / 90;

            // 90°ずつタイルを回転する
            for(int c = 0; c < count; c++) {
                tile = rotate(tile, rowIdx, colIdx, len);
            }
        }

        // 出力
        for(String[] row : tile) {
            System.out.println(String.join(" ", row));
        }
    }

    // 時計回りに90°回転する
    private static String[][] rotate(String[][] tile, int startRowIdx, int endRowIdx, int len) {

        final String[][] rotatedTile = new String[len][len];

        // 回転対象のタイルを抜き出す
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                rotatedTile[i][j] = tile[startRowIdx + i][endRowIdx + j];
            }
        }

        // 回転対象のタイルを回転してもとのタイルに戻す
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                tile[startRowIdx + i][endRowIdx + j] = rotatedTile[len - 1 - j][i];
            }
        }

        return tile;
    }
}
