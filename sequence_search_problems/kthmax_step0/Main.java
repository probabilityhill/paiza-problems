import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int[] ARRAY = new int[N];
        for(int i = 0; i < N; i++) {
            ARRAY[i] = sc.nextInt();
        }
        int max = 1000000001;
        for(int i = 0; i < 2; i++) {
            // 2周目：maxが最大値
            int max2 = -1000000001;
            for(int j = 0; j < N; j++) {
                int n = ARRAY[j];
                // 2周目：nが最大値でなければ2番目の最大値を更新
                if(n < max) {
                    max2 = Math.max(max2, n);
                }
            }
            // 1周目：max2が最大値
            // 2周目：max2が2番目の最大値
            max = max2;
        }
        System.out.println(max);
    }
}
