import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int n = sc.nextInt();
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            final int c = sc.nextInt();

            int[] dp = new int[n + 1];

            // 0段の階段を上る方法は1通り
            dp[0] = 1;

            // 開始位置
            final int start = Math.min(Math.min(a, b), c);

            // n段の階段を上る方法の数 = (n-a)段の階段を上る方法の数 + (n-b)段の階段を上る方法の数 + (n-c)段の階段を上る方法の数
            for (int i = start; i <= n; i++) {
                // (i-a)段の階段を上る方法の数を加える
                if (i >= a) {
                    dp[i] += dp[i - a];
                }

                // (i-b)段の階段を上る方法の数を加える
                if (i >= b) {
                    dp[i] += dp[i - b];
                }

                // (i-c)段の階段を上る方法の数を加える
                if (i >= c) {
                    dp[i] += dp[i - c];
                }
            }

            System.out.println(dp[n]);
        }
    }
}
