import java.util.*;

/*
    簡単な計算式に変形
    (v_1 + v_2 + ... + v_k) / (w_1 + w_2 + ... + w_k) ≧ x
    (v_1 + v_2 + ... + v_k) - x * (w_1 + w_2 + ... + w_k) ≧ 0
    (v_1 - x*w_1) + (v_2 - x*w_2) + ... + (v_k - x*w_k) ≧ 0
 */

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int k = sc.nextInt();

        final int[][] treasures = new int[n][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                treasures[j][i] = sc.nextInt();
            }
        }

        // 二分探索で到達可能な平均価値の境界を求める
        double maxAvgValue = binarySearch(n, k, treasures);

        // 出力
        System.out.println(maxAvgValue);
    }

    // 二分探索
    private static double binarySearch(int n, int k, int[][] A) {

        double left = 0;
        double right = 5001;
        double mid;

        while(right - left > Math.pow(10, -6)) {
            mid = (left + right) / 2;

            // v-x*wの値を計算
            double[] target = new double[n];
            for(int i = 0; i < n; i++) {
                target[i] = A[i][1] - mid * A[i][0];
            }
            // v-x*wの値で昇順にソート
            Arrays.sort(target);
            
            // 降順でv-x*wのk個の和を計算
            double sum = 0;
            for(int i = 0; i < k; i++) {
                sum += target[n - 1 - i];
            }
            
            if(sum < 0) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        return left;
    }
}
