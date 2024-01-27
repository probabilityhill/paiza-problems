import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static class LABEL {
        private static final String NEW  = "new";
        private static final String UP  = "up";
        private static final String DOWN  = "down";
        private static final String SAME  = "same";
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 部員の人数
            final int memberNum = sc.nextInt();
            // 今月のジョギング記録の数
            final int thisMonthRecordNum = sc.nextInt();
            // 成績表に表示される上位の人数
            final int topNum = sc.nextInt();

            // 記録マップ（key:名前, value:記録）
            final Map<String, Record> recordMap = new HashMap<>();

            // 先月の部員全員のジョギング成績を記録
            for (int i = 0; i < memberNum; i++) {
                final String name = sc.next();
                final int dist = sc.nextInt();
                recordMap.put(name, new Record(name, dist));
            }

            // 今月のジョギング記録を記録マップに追加
            for (int i = 0; i < thisMonthRecordNum; i++) {
                // 日付は読み飛ばす
                sc.next();
                final String name = sc.next();
                final int dist = sc.nextInt();
                // Mapから記録を取得
                Record record = recordMap.get(name);
                // 入力された距離を足す
                record.addThisMonthDist(dist);
                // 記録を更新する
                recordMap.put(name, record);
            }

            // 記録を先月の距離の降順でソート
            final List<Record> sortedLastMonthRecordList = new ArrayList<>(recordMap.values()).stream()
                .sorted(Comparator.comparing(Record::getLastMonthDist).reversed()).collect(Collectors.toList());

            // 先月の順位を記録
            for (int rank = 1; rank <= topNum; rank++) {
                final String name = sortedLastMonthRecordList.get(rank - 1).getName();
                // Mapから記録を取得
                Record record = recordMap.get(name);
                // 先月の順位を記録
                record.setLastMonthRank(rank);
                // 記録を更新する
                recordMap.put(name, record);
            }

            // 記録を今月の距離の降順、名前の昇順でソート
            final List<Record> sortedthisMonthRecordList = new ArrayList<>(recordMap.values()).stream()
                .sorted(Comparator.comparing(Record::getThisMonthDist).reversed().thenComparing(Record::getName)).collect(Collectors.toList());

            // 今月のTOP
            StringBuilder thisMonthTop = new StringBuilder();
            // 今月の成績から今月のTOPを求める
            for (int rank = 1; rank <= topNum; rank++) {
                final Record record = sortedthisMonthRecordList.get(rank - 1);
                final String name = record.getName();
                final int dist = record.getThisMonthDist();
                final int lastMonthRank = record.getLastMonthRank();
                // 先月のTOPを参照し今月のTOPのラベルを設定する
                String label = "";
                // 先月のTOPに入っていない場合
                if (lastMonthRank == 0) {
                    label = LABEL.NEW;
                } else if (rank < lastMonthRank) {
                    label = LABEL.UP;
                } else if (rank == lastMonthRank) {
                    label = LABEL.SAME;
                } else {
                    label = LABEL.DOWN;
                }
                thisMonthTop.append(name + " " + dist + " " + label + "\n");
            }

            // 出力
            System.out.println(thisMonthTop);
        }
    }
}

// 記録クラス
class Record {
    private String name;
    private int lastMonthDist;
    private int lastMonthRank;
    private int thisMonthDist;

    Record(String name, int lastMonthDist) {
        this.name = name;
        this.lastMonthDist = lastMonthDist;
    }

    public String getName() {
        return name;
    }

    public int getLastMonthDist() {
        return lastMonthDist;
    }

    public int getLastMonthRank() {
        return lastMonthRank;
    }

    public int getThisMonthDist() {
        return thisMonthDist;
    }

    public void addThisMonthDist(int dist) {
        this.thisMonthDist += dist;
    }

    public void setLastMonthRank(int rank) {
        this.lastMonthRank = rank;
    }
}
