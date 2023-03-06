import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        for(int y = 0; y < H; y++) {
            int x = sc.next().indexOf("#");
            // #が行に含まれていたら座標を出力
            if(x > -1) {
                System.out.println(y + " " + x);
                break;
            }
        }
    }
}
