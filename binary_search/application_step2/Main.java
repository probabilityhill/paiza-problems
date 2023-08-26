// 33

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int L = sc.nextInt();
        final int n = sc.nextInt();
        final int k = sc.nextInt();
        final int[] A = new int[k + 1];
        for(int i = 0; i < k; i++) {
            A[i] = sc.nextInt();
        }
        A[k] = L;
        
        final int maxShortestFutomakiLen = binarySearch(L, n, k, A);
        System.out.println(maxShortestFutomakiLen);
    }

    private static int binarySearch(int L, int n, int k, int[] A) {
        int left = 0;
        int right = L + 1;
        int mid;

        while(left + 1 < right) {
            mid = (left + right) / 2;

            int borderLen = mid;
            int cutFutomakiCount = 0;
            for(int i = 0; i < k + 1; i++) {
                int currLen = A[i];
                // 長さがボーダー未満であれば切らない
                if(currLen < borderLen) {
                    continue;
                }
                // ボーダー更新
                borderLen = currLen + mid;
                cutFutomakiCount++;
            }

            // 分割数に応じて探索範囲を狭める
            if(cutFutomakiCount < n) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        return left;
    }
}
