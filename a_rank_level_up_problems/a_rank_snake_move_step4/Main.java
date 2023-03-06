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
        int d = 1;             // 方向転換の回数
        int now = 1;           // 同じ方向での移動マス数
        int length = 1;        // 同じ方向での残りの移動マス数
        boolean first = true;  // 同じ方向での移動が1回目かどうか
        
        for(int i = 0; i < N; i++) {
            // 指定した方向に移動する
            move(DIRECTIONS[d%4]);
            length--;
            // 同じ方向での残りの移動マス数が0の場合
            if(length == 0) {
                if(!first) {        // 同じ方向での移動が2回目である場合
                    first = true;   // 次は1回目
                    now++;          // 次の移動マス数を1増やす
                    length = now;   // 次の移動回数をセット
                    d++;            // 方向転換
                } else {            // 同じ方向での移動が1回目である場合
                    first = false;  // 次は2回目
                    length = now;   // 次の移動回数（現在と同じ）をセット
                    d++;            // 方向転換
                }
            }
        }
        System.out.println((X+dx) + " " + (Y+dy));
    }
}
