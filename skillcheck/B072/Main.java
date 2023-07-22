import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int patternH = sc.nextInt();
        final int patternW = sc.nextInt();
        boolean[][] board = new boolean[H][W];
        boolean[][] pattern = new boolean[patternH][patternW];

        String[] patterRow;
        for(int i = 0; i < patternH; i++) {
            patterRow = sc.next().split("");
            for(int j = 0; j < patternW; j++) {
                pattern[i][j] = patterRow[j].equals("#");
            }
        }
        
        // スイッチをQ回押す
        final int Q = sc.nextInt();
        for(int i = 0; i < Q; i++) {
            int startColIdx = sc.nextInt() - 1;
            int startRowIdx = sc.nextInt() - 1;

            // boardとpatternの色が違うならtrue、同じならfalse
            for(int j = 0; j < patternH; j++) {
                for(int k = 0; k < patternW; k++) {
                    board[startRowIdx + j][startColIdx + k] = board[startRowIdx + j][startColIdx + k] ^ pattern[j][k];
                }
            }            
        }

        // 出力
        for(boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for(boolean value : row) {
                sb.append(value ? "#" : "_");
            }
            System.out.println(sb);
        }
    }
}
