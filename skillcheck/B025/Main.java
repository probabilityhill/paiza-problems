// 44

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        final int K = sc.nextInt();

        // 各うさぎの位置
        List<Integer> rabbitPos = new ArrayList<>();
        for(int ri = 0; ri < M; ri++) {
            rabbitPos.add(sc.nextInt() - 1);
        }

        // Kセットループ
        for(int i = 0; i < K; i++) {
            // うさぎループ
            for(int ri = 0; ri < M; ri++) {
                // 現在地
                int currPos = rabbitPos.get(ri);

                // 空いているしげみを探す
                for(int pi = 1; pi < N; pi++) {
                    int targetPos = (currPos + pi) % N;

                    // しげみが空いていたらジャンプして終了
                    if(!rabbitPos.contains(targetPos)) {
                        rabbitPos.set(ri, targetPos);
                        break;
                    }
                }
            }
        }

        // うさぎの位置を出力
        for(int p : rabbitPos) {
            System.out.println(p + 1);
        }
    }
}
