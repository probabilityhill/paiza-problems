// 9

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 旅程の日数
        final int N = sc.nextInt();

        int s, f, t, totalHours;
        int max = 0;
        int min = 24 * 2;
        for(int i = 0; i < N; i++) {
            s = sc.nextInt();
            f = sc.nextInt();
            t = sc.nextInt();
            
            // 一日の時間を計算
            totalHours = s + f + (24 - t);

            max = Math.max(totalHours, max);
            min = Math.min(totalHours, min);
        }

        // 出力
        System.out.println(min);
        System.out.println(max);
    }
}
