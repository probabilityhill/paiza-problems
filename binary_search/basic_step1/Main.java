import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 生徒の人数
        final int N = sc.nextInt();

        // 採点結果
        final int[] scores = new int[N];
        for(int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }
        // 点数をソートする
        Arrays.sort(scores);

        // 合格点の候補数
        final int Q = sc.nextInt();

        for(int i = 0; i < Q; i++) {
            // 合格点の候補
            int k = sc.nextInt();
            // 合格最低点のインデックス
            int minIdx = binarySearch(N, k, scores);
            // 合格の生徒数
            int passCount = N - minIdx;

            System.out.println(passCount);
        }
    }

    // 二分探索する
    private static int binarySearch(int n, int k, int[] scores) {

        int left = 0;
        int right = n;
        int mid;

        while(left < right) {
            mid = (left + right) / 2;
            
            if(scores[mid] < k) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return right;
    }
}
