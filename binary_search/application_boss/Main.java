import java.util.Arrays;
import java.util.Scanner;

// 二分探索で探したい値 x = (|A_i - B_j|を小さい順に並べた数列の第k項)
// mid = (数列のx以下の項数がk以上となる最小のx) となればよい
// left = -1, right = 10^8 * 2
// mid以下の項数 = |A_i - B_j| <= mid <=> A_i - mid <= B_j <= A_i + mid を満たす (A_i, B_j) の数
// => lowerBound = (A_i - mid <= B_j を満たす B_j が最小値をとるときの j), upperBound = (B_j <= A_i + mid を満たす B_j が最大値をとるときの j)
// mid以下の項数がk以上 => 項数がk以上となる、より小さいxが存在するか調べるため上限を小さくする => right = mid
// mid以下の項数がk未満 => 項数がk以上となるように下限を大きくする => left = mid
// left = right - 1 となったら終了 => x = right

public class Main {
    // Min |A_i-B_j| = 0
    private static final int MIN = 0;
    // Max |A_i-B_j| = 10^8 * 2
    private static final int MAX = 200000000;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int n = sc.nextInt();

            final int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }

            final int m = sc.nextInt();

            final int[] B = new int[m];
            for (int i = 0; i < m; i++) {
                B[i] = sc.nextInt();
            }
            Arrays.sort(B);

            final int k = sc.nextInt();

            int left = MIN - 1;
            int right = MAX;
            int mid;
            while (right - left > 1) {
                mid = (left + right) / 2;

                // mid以下の項数を求める
                int count = 0;
                for (int i = 0; i < n; i++) {
                    int lowerBound = binarySearch(A[i] - mid, m, B);
                    int upperBound = binarySearch(A[i] + mid + 1, m, B);
                    count += upperBound - lowerBound;
                }

                if (count < k) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            System.out.println(right);
        }
    }

    private static int binarySearch(int k, int n, int[] array) {
        int left = 0;
        int right = n;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;

            if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
