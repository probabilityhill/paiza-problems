import java.util.Scanner;

public class Main {
    private static char ROAD = '.';
    // 各方向（上右下左）の移動量
    private static int[][] MOVE_AMOUNT = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int H = sc.nextInt();
        final int W = sc.nextInt();

        // 迷路の外側に壁を作る
        final boolean[][] maze = new boolean[H + 2][W + 2];
        for(int ri = 0; ri < H; ri++) {
            String row = sc.next();
            for(int ci = 0; ci < W; ci++) {
                // 通れるマスをtrueにする
                if(row.charAt(ci) == ROAD) {
                    maze[ri + 1][ci + 1] = true;
                }
            }
        }

        int currRowIdx = 1;
        int currColIdx = 1;
        int dirIdx = 1;
        while(true) {
            // 通ったマスはfalseにする
            maze[currRowIdx][currColIdx] = false;

            if(maze[currRowIdx + MOVE_AMOUNT[dirIdx][0]][currColIdx + MOVE_AMOUNT[dirIdx][1]]) {
                // 進行方向のまま
            }
            else if(maze[currRowIdx + MOVE_AMOUNT[(dirIdx + 1) % 4][0]][currColIdx + MOVE_AMOUNT[(dirIdx + 1) % 4][1]]) {
                // 右回りに方向を更新
                dirIdx = (dirIdx + 1) % 4;
            }
            else if(maze[currRowIdx + MOVE_AMOUNT[(dirIdx - 1) % 4][0]][currColIdx + MOVE_AMOUNT[(dirIdx - 1) % 4][1]]) {
                // 左回りに方向を更新
                dirIdx = (dirIdx - 1) % 4;
            }
            else {
                // 進めるところがなければ終了
                break;
            }

            // 次のマスに進む
            currRowIdx += MOVE_AMOUNT[dirIdx][0];
            currColIdx += MOVE_AMOUNT[dirIdx][1];
        }

        // 止まった場所を出力
        System.out.println((currColIdx - 1) + " " + (currRowIdx - 1));
    }
}
