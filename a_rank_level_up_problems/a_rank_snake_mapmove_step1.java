import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        int sy = sc.nextInt();
        int sx = sc.nextInt();
        final String M = sc.next();  // 進む方角
        
        // マップ（#で囲む）
        String[][] map = new String[H+2][W+2];
        for (int i = 0; i < H+2; i++) {
            if (i == 0 || i == H+1) {
                for (int j = 0; j < W+2; j++) {
                    map[i][j] = "#";
                }
            }
            else {
                String[] tmp = sc.next().split("");
                map[i][0] = "#";
                for (int j = 1; j <= W; j++) {
                    map[i][j] = tmp[j-1];
                }
                map[i][W+1] = "#";
            }
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
        
        if (map[sy+1][sx+1].equals(".")) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
        
    }
}
