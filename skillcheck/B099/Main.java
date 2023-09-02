import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 地図のサイズ
        final int N = sc.nextInt();
        // 通ることのできない降水量
        final int M = sc.nextInt();

        final boolean[] passable  = new boolean[N];
        Arrays.fill(passable, true);

        int precipitation;
        for(int pi = 0; pi < N; pi++) {
            for(int ri = 0; ri < N; ri++) {
                precipitation = sc.nextInt();
                // 降水量がM以上の場合は通行不可能
                if(precipitation >= M) {
                    passable[ri] = false;
                }
            }
        }

        // 通行可能なルートが存在するかどうか
        boolean existsPassableRoute = false;
        for(boolean p : passable) {
            if(p) {
                existsPassableRoute = true;
                break;
            }
        }

        String answer = "";
        if(existsPassableRoute) {
            for(int ri = 0; ri < N; ri++) {
                if(passable[ri]) {
                    answer += (ri + 1) + " ";
                }
            }
            answer = answer.trim();
        }
        else {
            answer = "wait";
        }

        System.out.println(answer);
    }
}
