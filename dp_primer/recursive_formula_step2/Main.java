import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int x = sc.nextInt();
            final int d1 = sc.nextInt();
            final int d2 = sc.nextInt();
            final int k = sc.nextInt();

            // 数列（1-based）
            final int[] a = new int[k + 1];
            // 初項
            a[1] = x;
            // 数列の末項まで求める
            for (int n = 2; n <= k; n++) {
                a[n] = (n % 2 != 0) ? (a[n - 1] + d1) : (a[n - 1] + d2);
            }

            // 第k項を求める
            System.out.println(a[k]);
        }
    }
}
