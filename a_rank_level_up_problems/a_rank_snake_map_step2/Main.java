import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int N = sc.nextInt();
        // 盤面を作成
        String[] map = new String[H];
        for (int h = 0; h < H; h++) {
            map[h] = sc.next();
        }
        // #に置換
        for (int n = 0; n < N; n++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            map[y] = map[y].substring(0, x) + "#" + map[y].substring(x + 1);
        }
        // 盤面を出力
        for (int h = 0; h < H; h++) {
            System.out.println(map[h]);
        }
    }
}
