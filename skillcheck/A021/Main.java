// 61

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final char SEA = '.';
    private static final char LAND = '#';
    private static final char VISITED = '*';
    private static final int[][] MOVE_DIST = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static char[][] map;
    private static int H, W;
    private static int coastline, area;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        H = sc.nextInt();
        W = sc.nextInt();

        // 俯瞰図を入力
        map = new char[H][W];
        for(int i = 0; i < H; i++) {
            map[i] = sc.next().toCharArray();
        }

        // 島の情報を格納するリスト
        List<Island> islands = new ArrayList<>();

        // 陸が無くなるまで探索を繰り返す
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                // 陸があればその地点から探索開始
                if(map[i][j] == LAND) {
                    coastline = 0;
                    area = 0;
                    dfs(i, j);
                    // 島の情報を記録
                    islands.add(new Island(coastline, area));
                }
            }
        }

        // 面積->海岸線で降順にソート
        islands = islands.stream()
            .sorted(Comparator.comparing(Island::getArea)
            .thenComparing(Island::getCoastline)
            .reversed())
            .collect(Collectors.toList());
        
        // 出力
        for(Island island : islands) {
            System.out.println(island.getArea() + " " + island.getCoastline());
        }
    }

    // 上下左右を探索する（DFS）
    private static void dfs(int y, int x) {

        // 訪問済みにする
        map[y][x] = VISITED;

        // 面積をカウント
        area++;

        // 俯瞰図の範囲内かつ陸である場合探索を進める
        int nextY, nextX;
        for(int[] d : MOVE_DIST) {
            nextY = y + d[0];
            nextX = x + d[1];

            // 上下左右が海または範囲外であれば海岸線をカウント
            if(!isInRange(nextY, nextX) || map[nextY][nextX] == SEA) {
                coastline++;
                continue;
            }

            if(isInRange(nextY, nextX) && map[nextY][nextX] == LAND) {
                dfs(nextY, nextX);
            }
        }
    }

    // 俯瞰図の範囲内であるかどうか
    private static boolean isInRange(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }
}

class Island {
    private int coastline, area;

    Island(int coastline, int area) {
        this.coastline = coastline;
        this.area = area;
    }

    public int getCoastline() {
        return this.coastline;
    }

    public int getArea() {
        return this.area;
    }
}
