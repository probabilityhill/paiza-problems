import java.util.Scanner;

public class Main {
    private static final int MAX_K = 1000;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int x = sc.nextInt();
            final int d = sc.nextInt();
            final int Q = sc.nextInt();

            // 数列（1-based）
            final int[] a = new int[MAX_K + 1];
            a[1] = x;
            // 数列の末項まで求める
            for (int n = 2; n <= MAX_K; n++) {
                a[n] = a[n - 1] + d;
            }

            // 第k項を求める
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < Q; i++) {
                int k = sc.nextInt();
                result.append(a[k] + "\n");
            }
            System.out.println(result.toString());
        }
    }
}
