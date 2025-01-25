import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int n = sc.nextInt();

            int[] dp = new int[n + 1];

            // 0段の階段を上る方法は1通り
            dp[0] = 1;

            // n段の階段を上る方法の数 = (n-1)段の階段を上る方法の数 + (n-2)段の階段を上る方法の数
            for (int i = 1; i <= n; i++) {
                // 初期化
                dp[i] = 0;

                // (i-1)段の階段を上る方法の数を加える
                if (i >= 1) {
                    dp[i] += dp[i - 1];
                }

                // (i-2)段の階段を上る方法の数を加える
                if (i >= 2) {
                    dp[i] += dp[i - 2];
                }
            }

            System.out.println(dp[n]);
        }
    }
}
