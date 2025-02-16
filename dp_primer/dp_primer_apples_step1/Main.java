import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int n = sc.nextInt();
            // りんご2個の値段
            final int a = sc.nextInt();
            // りんご5個の値段
            final int b = sc.nextInt();

            // dp[n]: ちょうどn個のりんごを手に入れるために必要な金額の最小値
            // dp[n] = min(dp[n-2] + a, dp[n-5] + b)
            // dp[n+1] = min(dp[n-1] + a, dp[n-4] + b)
            // dp[n+2] = min(dp[n] + a, dp[n-3] + b)
            // 買ったりんごがn+1個以上になってもよい場合
            // dp[n] = min(dp[n], dp[n+1], dp[n+2])

            int[] dp = new int[n + 3];
            dp[0] = 0;
            dp[1] = a;
            for (int i = 2; i <= n + 2; i++) {
                dp[i] = dp[i - 2] + a;
                if (i >= 5) {
                    dp[i] = Math.min(dp[i], dp[i - 5] + b);
                }
            }

            System.out.println(Math.min(Math.min(dp[n], dp[n + 1]), dp[n + 2]));
        }
    }
}
