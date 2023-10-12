import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int numBooks = sc.nextInt();
        final int vacationDays = sc.nextInt();

        final int[] pages = new int[numBooks];
        final int[] daysToRead = new int[numBooks];
        for(int i = 0; i < numBooks; i++) {
            pages[i] = sc.nextInt();
            daysToRead[i] = sc.nextInt();
        }

        // 動的計画法で夏休みに読める最大の合計ページ数を求める
        // dp[i][j]: i番目の本まで選択できるときにj日で読める最大ページ数
        final int[][] dp = new int[numBooks + 1][vacationDays + 1];
        for(int i = 1; i <= numBooks; i++) {
            for(int j = 1; j <= vacationDays; j++) {
                if(j < daysToRead[i - 1]) {
                    // 読破日数に満たない場合は本を選択できないため最大値は更新されない
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    // i番目の本を選択する場合としない場合の合計ページ数を比較し大きい方を採用する
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - daysToRead[i - 1]] + pages[i - 1]);
                }
            }
        }

        // 夏休みに読める最大の合計ページ数
        final int maxTotalPages = dp[numBooks][vacationDays];

        // 出力
        System.out.println(maxTotalPages);
    }
}
