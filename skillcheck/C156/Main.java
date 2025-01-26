import java.util.Scanner;

public class Main {
    private static final String TIME_SPLITTER = ":";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 研究室に通った日数
            final int N = sc.nextInt();

            // 合計滞在時間（分）
            int totalTime = 0;

            for (int i = 0; i < N; i++) {
                final String[] entryTime = sc.next().split(TIME_SPLITTER);
                final int entryHours = Integer.parseInt(entryTime[0]);
                final int entryMinutes = Integer.parseInt(entryTime[1]);
                final String[] leavingTime = sc.next().split(TIME_SPLITTER);
                final int leavingHours = Integer.parseInt(leavingTime[0]);
                final int leavingMinutes = Integer.parseInt(leavingTime[1]);
                // 滞在時間を加算
                totalTime += (leavingHours - entryHours) * 60 + (leavingMinutes - entryMinutes);
            }

            final int totalHours = totalTime / 60;
            final int totalMinutes = totalTime % 60;

            System.out.println(totalHours + " " + totalMinutes);
        }

    }
}
