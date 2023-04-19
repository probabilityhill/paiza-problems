import java.util.*;

public class Main {
    static final int INF = 1000000001;
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        mergeSort(A, 0, N);
        for(int k = 0; k < N; k++) {
            System.out.print(A[k]);
            if(k != N - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println(count);
    }

    // マージソート（昇順）
    // データ列を二分し、それぞれをマージソートした後それらを「マージ (統合) 」することを繰り返す 
    // A[left] ~ A[right-1] をマージソートする
    // 配列 A をマージソートするには mergeSort(A, 0, n) を呼び出す 
    public static void mergeSort(int[] A, int left, int right) {
        if(left + 1 < right) {
            int mid = (left + right) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid, right);
            merge(A, left, mid, right);
        }
    }

    // 部分データ列 A[left] ~ A[mid-1], A[mid] ~ A[right-1] はそれぞれ整列済み
    // 2つの部分データ列をマージし、A[left] ~ A[right-1] を整列済みにする
    public static void merge(int[] A, int left, int mid, int right) {
        // 2つの部分データ列のサイズ
        int nl = mid - left;
        int nr = right - mid;
        
        // 部分データ列をコピー
        int[] L = new int[nl+1];
        int[] R = new int[nr+1];
        for(int i = 0; i < nl; i++) {
            L[i] = A[left+i];
        }
        for(int i = 0; i < nr; i++) {
            R[i] = A[mid+i];
        }
        
        // 番兵
        L[nl] = INF;
        R[nr] = INF;
        
        // 2つの部分データ列をマージして A[left] ~ A[right-1] に書き込む
        int lindex = 0;
        int rindex = 0;
    
        for(int i = left; i < right; i++) {
            if(L[lindex] < R[rindex]) {
                A[i] = L[lindex];
                lindex++;
            }
            else {
                A[i] = R[rindex];
                rindex++;
                count++;
            }
        }
    }
}
