import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        int sy = sc.nextInt();            // 現在のx座標
        int sx = sc.nextInt();            // 現在のy座標
        final String D_NOW = sc.next();   // 現在向いている方角（N, S, E, W）
        final String D_NEXT = sc.next();  // 移動する方向（L, R）
        
        // マップを作製
        final String MAP[][] = new String[H][W];
        for (int i = 0; i < H; i++) {
            MAP[i] = sc.next().split("");
        }

        int LR = 1;
        if (D_NEXT.equals("L")) {
            LR = -1;
        }
        
        // 移動する
        switch (D_NOW) {
            case "N":
                sx += LR;
                break;
            case "S":
                sx -= LR;
                break;
            case "E":
                sy += LR;
                break;
            case "W":
                sy -= LR;
                break;                  
        }
        
        // 移動先がマップの範囲内かつ障害物でない場合は移動可能
        if (sx >= 0 && sx < W && sy >= 0 && sy < H && MAP[sy][sx].equals(".")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }  
    }
}
