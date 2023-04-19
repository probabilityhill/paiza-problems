import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // 挿入ソート（昇順）
        for(int i = 1; i < N; i++) {
            // A[i] を、整列済みの A[0] ~ A[i-1] の適切な位置に挿入する
            // 実装の都合上、A[i] の値が上書きされてしまうことがあるので、予め A[i] の値をコピーしておく 
            int x = A[i];
            // A[i] の適切な挿入位置を表す変数 j を用意
            int j = i - 1;
            // A[i] の適切な挿入位置が見つかるまで、A[i] より大きい要素を1つずつ後ろにずらしていく
            while(j >= 0 && A[j] > x) {
                A[j + 1] = A[j];
                j--;
            }
            // A[i] を挿入
            A[j + 1] = x;
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
