import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        String[] map = new String[H];
        for(int i = 0; i < H; i++) {
            map[i] = sc.next();
        }
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                // 上端または上が"#"の場合
                if(i == 0 || map[i-1].charAt(j) == '#') {
                    // 下端または下が"#"の場合
                    if(i == H-1 || map[i+1].charAt(j) == '#') {
                       System.out.println(i + " " + j); 
                    }
                }
            }
        }
    }
}
