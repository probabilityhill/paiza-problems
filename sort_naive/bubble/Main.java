import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // バブルソート（昇順）
        // データ列の隣り合う要素を比較し交換することを繰り返す
        for(int i = 0; i < N-1; i++) {
            for(int j = N-1; j > i; j--) {
                if(A[j-1] > A[j]) {
                    int tmp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = tmp;
                }
            }
            for(int k = 0; k < N; k++) {
                System.out.print(A[k]);
                if(k != N - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
