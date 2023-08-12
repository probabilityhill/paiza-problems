import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        // 配列をソートする
        Arrays.sort(A);

        // 整数の組の個数
        final int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            final int l = sc.nextInt();
            final int r = sc.nextInt();
            
            int lMinIdx = binarySearch(n, l, A);
            int rMinIdx = binarySearch(n, r + 1, A);

            System.out.println(rMinIdx - lMinIdx);
        }
    }

    // 二分探索する
    private static int binarySearch(int n, int k, int[] A) {

        int left = 0;
        int right = n;
        int mid;

        while(left < right) {
            mid = (left + right) / 2;

            if(A[mid] < k) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return left;
    }
}
