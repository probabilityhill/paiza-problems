import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        final int K = sc.nextInt();
        final int[] H = new int[K];
        for(int i = 0; i < K; i++) {
            H[i] = sc.nextInt();
        }
        shellSort(A, N, H);
    }

    // シェルソート（昇順）
    // データ列において一定の間隔 h だけ離れた要素たちからなる部分列を対象とした
    // 挿入ソートを、h を小さくしながら (間隔を狭めながら) 繰り返してソートを行う   
    public static void shellSort(int[] A, int N, int[] H) {
        for(int h : H) {
            insertionSort(A, N, h);
        }
    }

    // 挿入ソート
    public static void insertionSort(int[] A, int N, int h) {
        // アルゴリズムが正しく実装されていることを確認するために導入するカウンタ変数
        // ソート処理には関係がない
        int numOfMove = 0;

        for(int i = h; i < N; i++) {
            // A[i] を、整列済みの A[i-ah], ..., A[i-2h], A[i-h] の適切な位置に挿入する

            // 実装の都合上、A[i] の値が上書きされてしまうことがあるので、予め A[i] の値をコピーしておく
            int x = A[i];

            // A[i] の適切な挿入位置を表す変数 j を用意
            int j = i - h;

            // A[i] の適切な挿入位置が見つかるまで、A[i] より大きい要素を後ろにずらしていく
            while(j >= 0 && A[j] > x) {
                A[j+h] = A[j];
                j -= h;
                numOfMove++;
            }
            
            // A[i] を挿入
            A[j+h] = x;
        }
        System.out.println(numOfMove);
    }
}
