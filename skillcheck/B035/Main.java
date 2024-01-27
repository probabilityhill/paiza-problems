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

            // 先月の部員全員のジョギング成績
            final List<Record> lastMonthRecordList = new ArrayList<>();
            for (int i = 0; i < memberNum; i++) {
                final String name = sc.next();
                final int dist = sc.nextInt();
                lastMonthRecordList.add(new Record(name, dist));
            }

            // 今月のジョギング記録（key:名前, value:記録）
            final Map<String, Record> thisMonthRecordMap = new HashMap<>();
            for (int i = 0; i < thisMonthRecordNum; i++) {
                // 日付は読み飛ばす
                sc.next();
                final String name = sc.next();
                final int dist = sc.nextInt();
                // Mapに記録を取得（存在しない場合は記録を作成する）
                Record record = thisMonthRecordMap.getOrDefault(name, new Record(name, 0));
                // 入力された距離を足す
                record.addDist(dist);
                // 記録を更新する
                thisMonthRecordMap.put(name, record);
            }

            // 先月の成績を距離の降順でソート
            final List<Record> sortedLastMonthRecordList = lastMonthRecordList.stream()
                .sorted(Comparator.comparing(Record::getDist).reversed()).collect(Collectors.toList());

            // 先月のTOP（key:名前, value:順位(0-based)）
            final Map<String, Integer> lastMonthTop = new HashMap<>();
            // 先月の成績から先月のTOPのMap作成
            for (int rank = 0; rank < topNum; rank++) {
                final String name = sortedLastMonthRecordList.get(rank).getName();
                lastMonthTop.put(name, rank);
            }

            // 今月のジョギング記録(Map)をListに変換
            final List<Record> thisMonthRecordList = new ArrayList<>(thisMonthRecordMap.values());
            // 先月のジョギング成績から今月走っていない人を探し記録に追加する
            for (Record record : lastMonthRecordList) {
                final String name = record.getName();
                if (!thisMonthRecordMap.containsKey(name)) {
                    thisMonthRecordList.add(new Record(name, 0));
                }
            }

            // 今月のジョギング記録を距離の降順、名前の昇順でソート
            final List<Record> sortedthisMonthRecordList = thisMonthRecordList.stream()
                .sorted(Comparator.comparing(Record::getDist).reversed().thenComparing(Record::getName)).collect(Collectors.toList());

            // 今月のTOP
            StringBuilder thisMonthTop = new StringBuilder();
            // 今月の成績をから今月のTOPを求める
            for (int rank = 0; rank < topNum; rank++) {
                final Record record = sortedthisMonthRecordList.get(rank);
                final String name = record.getName();
                final int dist = record.getDist();
                // 先月のTOPを参照し今月のTOPのラベルを設定する
                String label = "";
                // 先月のTOPに入っていない場合
                if (!lastMonthTop.containsKey(name)) {
                    label = LABEL.NEW;
                } else {
                    // 先月の順位
                    final int lastMonthRank = lastMonthTop.get(name);
                    if (rank < lastMonthRank) {
                        label = LABEL.UP;
                    } else if (rank == lastMonthRank) {
                        label = LABEL.SAME;
                    } else {
                        label = LABEL.DOWN;
                    }
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
    private int dist;

    Record(String name, int dist) {
        this.name = name;
        this.dist = dist;
    }

    public String getName() {
        return name;
    }

    public int getDist() {
        return dist;
    }

    public void addDist(int dist) {
        this.dist += dist;
    }
}
