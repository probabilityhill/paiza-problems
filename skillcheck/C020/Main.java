// 4

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final double m = sc.nextDouble();
        final double p = sc.nextDouble();
        final double q = sc.nextDouble();

        double unsoledKg = m * (1 - p / 100) * (1 - q / 100);

        // 出力
        System.out.println(unsoledKg);
    }
}
