import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final int NUM_BUY = sc.nextInt();
        final int LOWER_LIMIT = sc.nextInt();
        final int NUM_FREE = sc.nextInt();
        int[] prices = new int[NUM_BUY];
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < NUM_BUY; i++) {
            prices[i] = sc.nextInt();
        }
        Arrays.sort(prices);  // 昇順にソート
        // 安くなる場合は金額を足す範囲を変更する
        if (NUM_BUY >= LOWER_LIMIT) {
            idx = NUM_FREE;
        }
        // 合計金額を計算する
        for (int i = idx; i < NUM_BUY; i++) {
            sum += prices[i];
        }
        System.out.println(sum);
    }
}
