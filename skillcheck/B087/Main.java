// 24

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int h = sc.nextInt();
        final int w = sc.nextInt();
        final int k = sc.nextInt();

        final int[][] grid = new int[h][w];
        for(int ri = 0; ri < h; ri++) {
            String[] input = sc.next().split("");
            for(int ci = 0; ci < w; ci++) {
                grid[ri][ci] = Integer.parseInt(input[ci]);
            }
        }

        int max = 0;

        // 横に並ぶ数字を調べる
        for(int ri = 0; ri < h; ri++) {
            for(int ci = 0; ci < w - k + 1; ci++) {
                // 各位の和を計算する
                int sum = 0;
                for(int i = 0; i < k; i++) {
                    sum += Math.pow(10, k - i - 1) * grid[ri][ci + i];
                }
                max = Math.max(sum, max);
            }
        }

        // 縦に並ぶ数字を調べる
        for(int ri = 0; ri < h - k + 1; ri++) {
            for(int ci = 0; ci < w; ci++) {
                // 各位の和を計算する
                int sum = 0;
                for(int i = 0; i < k; i++) {
                    sum += Math.pow(10, k - i - 1) * grid[ri + i][ci];
                }
                max = Math.max(sum, max);
            }
        }

        System.out.println(max);
    }
}
