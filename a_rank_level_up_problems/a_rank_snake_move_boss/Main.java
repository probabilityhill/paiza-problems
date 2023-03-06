import java.util.Scanner;

public class Main {
    public static int dx, dy = 0;
    
    // d方向に1マス移動する
    public static void move(char d) {
        if(d == 'N') {
            dy--;
        } else if(d == 'S') {
            dy++;
        } else if(d == 'E') {
            dx++;
        } else {
            dx--;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int X = sc.nextInt();
        final int Y = sc.nextInt();
        final int N = sc.nextInt();
        final char[] DIRECTIONS = {'N','E','S','W'};
        int idx_d = 100;
        String lr;  // L or R
        
        for(int i = 0; i < N; i++) {
            lr = sc.next();
            if(lr.equals("L")) {
                idx_d--;
            }
            else {
                idx_d++;
            }
            // 指定した方向に移動する
            move(DIRECTIONS[idx_d%4]);
            // 座標を出力
            System.out.println((X+dx) + " " + (Y+dy));
        }
        
    }
}
