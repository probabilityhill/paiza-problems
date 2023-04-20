import java.util.*;

public class Main {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        quickSort(A, 0, N);
        for(int k = 0; k < N; k++) {
            System.out.print(A[k]);
            if(k != N - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println(count);
    }

    // クイックソート（昇順）
    // ピボットと呼ばれる値を1つ選び、それを基準としてデータ列を「ピボット未満の要素からなるデータ列」
    // と「ピボット以上の要素からなるデータ列」に二分することを再帰的に行うアルゴリズム
    // A[left] ~ A[right-1] をクイックソートする
    // 配列 A をクイックソートするには quickSort(A, 0, n) を呼び出す
    public static void quickSort(int[] A, int left, int right) {
        // ソートする範囲の長さが1以下の場合は何もしない
        if(left + 1 >= right) {
            return;
        }

        // データ列の末尾 A[right-1] をピボットとする
        int pivot = A[right-1];

        // ピボット未満のデータを挿入する位置を保持する変数を用意
        int curIndex = left;

        for(int i = left; i < right - 1; i++) {
            if(A[i] < pivot) {
                int tmp = A[curIndex];
                A[curIndex] = A[i];
                A[i] = tmp;
                curIndex++;
                count++;
            }
        }

        // ピボットを A[curIndex] へ移動し、データ列を分割する
        int tmp = A[curIndex];
        A[curIndex] = A[right-1];
        A[right-1] = tmp;

        // 分割されたデータ列に対して再帰的にクイックソートを行う
        quickSort(A, left, curIndex);
        quickSort(A, curIndex + 1, right);
    }
}
