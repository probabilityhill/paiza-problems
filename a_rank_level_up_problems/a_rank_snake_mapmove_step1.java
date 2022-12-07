import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        int sy = sc.nextInt();
        int sx = sc.nextInt();
        final String M = sc.next();  // 進む方角
        String[][] map = new String[H][W];
        for (int i = 0; i < H; i++) {
            map[i] = sc.next().split("");
        }

        if (M.equals("E")) {
            sx += 1;
        }
        else if (M.equals("S")) {
            sy += 1;
        }
        else if (M.equals("W")) {
            sx -= 1;
        }
        else {
            sy -= 1;
        }
        
        // 範囲外または#であるときは移動不可
        if (sy < 0 || sy >= H || sx < 0 || sx >= W || map[sy][sx].equals("#")) {
            System.out.println("No");
        }
        else {
            System.out.println("Yes");
        }
    }
}
