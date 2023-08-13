// 44

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        final int K = sc.nextInt();

        // 各うさぎの位置
        final int[] rabbitPos = new int[M];
        // 各しげみのうさぎ番号
        final int[] places = new int[N];
             
        int pos;
        for(int ri = 0; ri < M; ri++) {
            pos = sc.nextInt();
            rabbitPos[ri] = pos;
            places[pos - 1] = ri + 1;
        }

        // Kセットジャンプする
        for(int i = 0; i < K; i++) {
            // うさぎループ
            for(int ri = 0; ri < M; ri++) {
                // 現在地
                int currPosIdx = rabbitPos[ri] - 1;

                // 空いているしげみを探す
                int targetPosIdx = 0;
                for(int pi = 1; pi < N; pi++) {
                    targetPosIdx = (currPosIdx + pi) % N;

                    // しげみが空いていたら探索終了
                    if(places[targetPosIdx] == 0) {
                        break;
                    }
                }

                // ジャンプする
                places[currPosIdx] = 0;
                places[targetPosIdx] = ri + 1;
                rabbitPos[ri] = targetPosIdx + 1;
            }
        }

        // うさぎの位置を出力
        for(int p : rabbitPos) {
            System.out.println(p);
        }
    }
}
