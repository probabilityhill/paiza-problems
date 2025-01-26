import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 研究室に通った日数
            final int N = sc.nextInt();

            // 合計滞在時間
            Duration totalTime = Duration.ZERO;

            for (int i = 0; i < N; i++) {
                final LocalTime entryTime = LocalTime.parse(sc.next());
                final LocalTime leavingTime = LocalTime.parse(sc.next());
                // 滞在時間を加算
                totalTime = totalTime.plus(Duration.between(entryTime, leavingTime));
            }

            // 合計滞在時間を"HH mm"形式で出力
            System.out.println(totalTime.toHours() + " " + totalTime.toMinutesPart());
        }
    }
}
