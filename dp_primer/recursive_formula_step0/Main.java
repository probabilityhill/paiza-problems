import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int x = sc.nextInt();
        final int d = sc.nextInt();
        final int k = sc.nextInt();

        // 数列
        final int[] a = new int[k + 1];
        // 初項
        a[1] = x;
        // 漸化式により順に次項を求める
        for(int i = 2; i <= k; i++) {
            a[i] = a[i - 1] + d;
        }
        // 第k項を出力
        System.out.println(a[k]);
    }
}
