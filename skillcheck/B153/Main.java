import java.util.Scanner;

public class Main {
    // 渦巻きの方向（右、下、左、上）
    private static final Point[] DIRECTIONS = new Point[] { new Point(0, 1), new Point(1, 0), new Point(0, -1),
            new Point(-1, 0) };
    // 蚊取り線香の区切りの数
    private static final int DIVISIONS = 4;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 蚊取線香の一辺のブロック数
            final int N = sc.nextInt();

            // ブロックが燃えるまでにかかる時間
            final int[][] burnTimes = new int[N][N];
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    burnTimes[y][x] = sc.nextInt();
                }
            }

            // 蚊取線香の合計の長さ
            final int totalLen = N * N;
            // 蚊取線香の区切りの長さ
            final int divLen = totalLen / DIVISIONS;

            // 燃えた長さ
            int burnedLen = 0;
            // 現在地
            Point currPoint = new Point(0, 0);
            // 方向転換の回数
            int turnCounter = 0;
            // ブロックが訪問済みかどうか
            boolean[][] isVisited = new boolean[N][N];

            // 燃えるのにかかった合計時間
            int sumTime = 0;
            // 各区切りの地点まで燃え切るのにかかる時間
            int[] sumTimes = new int[DIVISIONS];

            while (burnedLen < totalLen) {
                // 燃えた長さを更新する
                burnedLen++;
                // 燃えるのにかかった時間を更新する
                sumTime += burnTimes[currPoint.getY()][currPoint.getX()];
                // 現在地を訪問済みとする
                isVisited[currPoint.getY()][currPoint.getX()] = true;

                // 現在地が区切りの地点の場合は合計時間を記録する
                if (burnedLen % divLen == 0) {
                    sumTimes[burnedLen / divLen - 1] = sumTime;
                }

                // 現在の方向に進めない場合は方向転換
                Point nextPoint = Point.add(currPoint, getDirPoint(turnCounter));
                if (!canMove(nextPoint, isVisited, N)) {
                    turnCounter++;
                    nextPoint = Point.add(currPoint, getDirPoint(turnCounter));
                }

                // 次のブロックに進む
                currPoint = nextPoint;
            }

            // 各区切りの地点まで燃え切るのにかかる時間を改行区切りで出力
            StringBuilder sb = new StringBuilder();
            for (int time : sumTimes) {
                sb.append(time + "\n");
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * 指定した地点に進めるかどうか
     */
    private static boolean canMove(Point point, boolean[][] isVisited, int N) {
        // グリッドの範囲外
        if (point.getY() < 0 || point.getY() >= N || point.getX() < 0 || point.getX() >= N) {
            return false;
        }
        // 訪問済み
        if (isVisited[point.getY()][point.getX()]) {
            return false;
        }
        return true;
    }

    /**
     * 方向転換の回数からPoint型の方向を取得
     */
    private static Point getDirPoint(int turnCount) {
        return DIRECTIONS[turnCount % DIRECTIONS.length];
    }

}

class Point {
    private int y;
    private int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    /**
     * 2つのPointの合計を返す
     */
    public static Point add(Point p1, Point p2) {
        return new Point(p1.y + p2.y, p1.x + p2.x);
    }

    /**
     * 指定したPointの分だけ進む
     */
    public void move(Point p) {
        this.y += p.y;
        this.x += p.x;
    }
}
