import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NUM_HOLIDAY = sc.nextInt();             // 連休の日数
        final int DAYS_TRAVEL = sc.nextInt();             // 旅行の日数
        final int[][] WEATHER = new int[NUM_HOLIDAY][2];  // 天気予報
        for (int i = 0; i < NUM_HOLIDAY; i++) {
            WEATHER[i][0] = sc.nextInt();
            WEATHER[i][1] = sc.nextInt();
        }
        int s = 0;                                        // 旅行開始日
        int sum;                                          // 降水確率の合計
        int minSum = 10000;                               // 降水確率の合計の最小値
        for (int i = 0; i < NUM_HOLIDAY - DAYS_TRAVEL + 1; i++) {
            sum = 0;
            // 旅行期間の降水確率の合計を求める
            for (int j = 0; j < DAYS_TRAVEL; j++) {
                sum += WEATHER[i + j][1];
            }
            // 降水確率の合計が最も小さいとき最小値と開始日を更新
            if (sum < minSum) {
                minSum = sum;
                s = WEATHER[i][0];
            }
        }
        System.out.println(s + " " + (s + DAYS_TRAVEL - 1));
    }
}
