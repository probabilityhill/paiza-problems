import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int n = sc.nextInt();
            // りんご1個の値段
            final int a = sc.nextInt();
            // りんご2個の値段
            final int b = sc.nextInt();

            // dp[n]: n個のりんごを手に入れるために必要な金額の最小値
            // dp[n] = min(dp[n-1] + a, dp[n-2] + b)

            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = a;
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.min(dp[i - 1] + a, dp[i - 2] + b);
            }

            System.out.println(dp[n]);
        }
    }
}
