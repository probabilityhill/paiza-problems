import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int k = sc.nextInt();

            // 数列（1-based）
            final int[] a = new int[k + 1];
            // 初項
            a[1] = 1;
            a[2] = 1;
            // 数列の第k項を求める
            for (int n = 3; n <= k; n++) {
                a[n] = a[n - 2] + a[n - 1];
            }

            System.out.println(a[k]);
        }
    }
}
