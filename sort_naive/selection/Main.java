import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // 選択ソート（昇順）
        for(int i = 0; i < N-1; i++) {
            // A[i] ~ A[n-1] の最小値を見つけ、A[i]と交換する
            // つまり、整列済みとなっている A[0] ~ A[i-1] の末尾に、A[i] ~ A[n-1] の最小値を付け加える 

            // A[i] ~ A[n-1] の最小値の位置を保存する変数 minIndex を用意
            // 暫定的に A[i] を最小値とする
            int minIndex = i;

            // 最小値を探す
            for(int j = i + 1; j < N; j++) {
                if(A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }

            // A[i] と A[minIndex]を交換
            int tmp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = tmp;
            
            // A[0] ~ A[i] が整列済みになった
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
