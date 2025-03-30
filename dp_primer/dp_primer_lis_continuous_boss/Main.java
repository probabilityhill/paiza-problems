import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // dp[n]: 人 n が右端となっているような逆背の順区間のうち、最長であるような区間の長さ
            // dp[i] = (a[i] <= a[i-1]) ? (dp[i-1] + 1) : 1
            // 背の順であるような区間のうち、最長の長さ：max({dp[1], ... ,dp[n]})
            // ※実装は0-based

            final int n = sc.nextInt();
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < dp.length; i++) {
                if (a[i] <= a[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
            }

            final int maxLength = Arrays.stream(dp).max().getAsInt();
            System.out.print(maxLength);
        }
    }
}
