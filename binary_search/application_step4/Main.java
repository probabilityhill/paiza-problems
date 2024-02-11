import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int L = sc.nextInt();
            final int n = sc.nextInt();
            final int k = sc.nextInt();
            final int[] A = new int[k + 2];
            for (int i = 1; i <= k; i++) {
                A[i] = sc.nextInt();
            }
            A[k + 1] = L;

            // 二分探索で最長の太巻きが最小となるときのボーダーを求める
            final int minLongestFutomakiLen = binarySearch(L, n, k, A);
            System.out.println(minLongestFutomakiLen);
        }
    }

    private static int binarySearch(int L, int n, int k, int[] A) {
        // ボーダーの最小値は最大の切れ目の長さ
        int left = 1;
        for (int i = 1; i <= k + 1; i++) {
            left = Math.max(A[i] - A[i - 1], left);
        }
        left--;
        // ボーダーの最大値は太巻き全体の長さ
        int right = L;
        int border;

        while (right - left > 1) {
            border = (left + right) / 2;

            int cutLeft = 0;
            int cutCount = 1;
            int i = 0;
            while (i <= k) {
                // ボーダーを超える場合は分割する
                if (A[i + 1] - cutLeft > border) {
                    cutLeft = A[i];
                    cutCount++;
                } else {
                    i++;
                }
            }

            // 分割数に応じて探索範囲を狭める
            if (cutCount > n) {
                left = border;
            }
            else {
                right = border;
            }
        }
        return right;
    }
}
