import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();

        // 時差のマップ
        final Map<String, Integer> timeDiffs = new LinkedHashMap<>();
        for(int i = 0; i < N; i++) {
            timeDiffs.put(sc.next(), sc.nextInt());
        }

        // 基準となる国の情報
        final String baseCountry = sc.next();
        final String[] baseTime = sc.next().split(":");
        final int baseHours = Integer.parseInt(baseTime[0]);
        final int baseMinutes = Integer.parseInt(baseTime[1]);
        
        // ロンドンの時間
        final int londonHours = baseHours - timeDiffs.get(baseCountry);

        // 各地の時刻を計算し出力
        for(int diff : timeDiffs.values()) {
            int hours = londonHours + diff;
            // 24時間制になるように調整
            if(hours < 0 ) {
                hours += 24;
            }
            else if(hours >= 24) {
                hours -= 24;
            }
            // hh:mm
            System.out.println(String.format("%02d:%02d", hours, baseMinutes));
        }
    }
}
