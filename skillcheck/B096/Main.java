// 18

import java.util.*;

public class Main {
    private static char BOMB = '#';
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();

        final Set<Integer> bombRowIdxs = new HashSet<>();
        final Set<Integer> bombColIdxs = new HashSet<>();

        // 爆弾が存在する行と列を記録する
        for(int ri = 0; ri < H; ri++) {
            char[] row = sc.next().toCharArray();
            for(int ci = 0; ci < W; ci++) {
                if(row[ci] == BOMB) {
                    bombRowIdxs.add(ri);
                    bombColIdxs.add(ci);
                }
            }
        }

        // 被弾したマスの数 = 全体のマス数 - 被弾していないマスの数
        final int totalBombedCells = H * W - (H - bombRowIdxs.size()) * (W - bombColIdxs.size());
        
        // 出力
        System.out.println(totalBombedCells);
    }
}
