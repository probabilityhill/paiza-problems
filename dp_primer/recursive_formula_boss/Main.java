import java.util.Scanner;

public class Main {
    private static final int MAX_K = 40;
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int Q = sc.nextInt();

            // 数列（1-based）
            final int[] a = new int[MAX_K + 1];
            // 初項
            a[1] = 1;
            a[2] = 1;
            // 数列の末項まで求める
            for (int n = 3; n <= MAX_K; n++) {
                a[n] = a[n - 2] + a[n - 1];
            }

            // 第k項を求める
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < Q; i++) {
                int k = sc.nextInt();
                result.append(a[k] + "\n");
            }
            System.out.println(result);
        }
    }
}
