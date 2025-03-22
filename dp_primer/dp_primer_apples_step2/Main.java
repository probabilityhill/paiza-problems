import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int n = sc.nextInt();
            final int x = sc.nextInt();
            final int a = sc.nextInt();
            final int y = sc.nextInt();
            final int b = sc.nextInt();

            // dp[n]: ちょうど n 個のりんごを買うのに必要な金額の最小値
            // dp[k] = min(dp[k-x] + a, dp[k-y] + b)
            // 買ったりんごがn+1個以上になってもよい場合
            // dp[n] = min(dp[n], dp[n+1], ...)

            int[] dp = new int[n + y];
            Arrays.fill(dp, 10000000);
            dp[0] = 0;
            for (int i = 1; i < dp.length; i++) {
                if (i >= x) {
                    dp[i] = Math.min(dp[i], dp[i - x] + a);
                }
                if (i >= y) {
                    dp[i] = Math.min(dp[i], dp[i - y] + b);
                }
            }

            int minValue = Arrays.stream(dp, n, dp.length).min().getAsInt();
            System.out.println(minValue);
        }
    }
}
