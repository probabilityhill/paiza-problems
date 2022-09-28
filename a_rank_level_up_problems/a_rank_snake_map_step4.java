import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        String[][] map = new String[H][W];
        for(int i = 0; i < H; i++) {
            map[i] = sc.next().split("");
        }
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                // 上端または上が"#"の場合
                if(i == 0 || map[i-1][j].equals("#")) {
                    // 下端または下が"#"の場合
                    if(i == H-1 || map[i+1][j].equals("#")) {
                       System.out.println(i + " " + j); 
                    }
                }
            }
        }
    }
}
