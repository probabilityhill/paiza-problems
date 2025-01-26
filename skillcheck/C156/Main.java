import java.util.Scanner;

public class Main {
    private static final String TIME_DELIMITER = ":";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 研究室に通った日数
            final int N = sc.nextInt();

            // 合計滞在時間（分）
            int totalTime = 0;

            for (int i = 0; i < N; i++) {
                final int entryTime = timeToMinutes(sc.next());
                final int leavingTime = timeToMinutes(sc.next());
                // 滞在時間を加算
                totalTime += leavingTime - entryTime;
            }

            final int totalHours = totalTime / 60;
            final int totalMinutes = totalTime % 60;

            System.out.println(totalHours + " " + totalMinutes);
        }
    }

    /**
     * 時刻形式の文字列を分に変換する
     *
     * @param time 時刻"HH:mm"形式の文字列
     * @return 総分数（例: "01:30" -> 90）
     */
    private static int timeToMinutes(String time) {
        final String[] parts = time.split(TIME_DELIMITER);
        final int hours = Integer.parseInt(parts[0]);
        final int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
