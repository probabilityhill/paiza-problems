// 26

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int k = sc.nextInt();

        final int[] pipes = new int[n];
        for(int i = 0; i < n; i++) {
            pipes[i] = sc.nextInt();
        }
        Arrays.sort(pipes);

        // 二分探索で切り出せる長さの境界を求める
        double maxLen = binarySearch(n, 0, pipes[n - 1], k, pipes);

        System.out.println(maxLen);
    }

    // 二分探索
    private static double binarySearch(int n, double left, double right, int k, int[] A) {

        double mid = 0;

        while(right - left > Math.pow(10, -6)) {
            mid = (left + right) / 2;

            // 切り出せるパイプの本数を数える
            int pipeCount = 0;
            for(int a : A) {
                pipeCount += a / mid;
            }

            if(pipeCount < k) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        return mid;
    }
}
