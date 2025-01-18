import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 参加者数
            final int N = sc.nextInt();
            // 参加者の得点の配列
            final Integer[] scoreArray = new Integer[N];
            for (int i = 0; i < N; i++) {
                scoreArray[i] = sc.nextInt();
            }

            // 得点の配列を降順にソート
            final Integer[] sortedScoreArray = Arrays.stream(scoreArray)
                    .sorted(Comparator.reverseOrder())
                    .toArray(Integer[]::new);

            // 得点と順位のマップを作成
            Map<Integer, Integer> scoreToRankMap = new HashMap<>();
            int currRank = 1;
            scoreToRankMap.put(sortedScoreArray[0], currRank);
            // sortedScoreArrayの2番目以降をループ
            int currScore, prevScore;
            for (int i = 1; i < N; i++) {
                currScore = sortedScoreArray[i];
                prevScore = sortedScoreArray[i - 1];
                // 前の得点よりも低い場合は順位を更新
                if (currScore < prevScore) {
                    currRank = i + 1;
                    scoreToRankMap.put(currScore, currRank);
                }
            }

            // 各参加者の点数から順位を取得し、StringBuilderで結合
            StringBuilder rankStringBuilder = new StringBuilder();
            for (int score : scoreArray) {
                int rank = scoreToRankMap.get(score);
                rankStringBuilder.append(rank + "\n");
            }
            // 順位を出力
            System.out.println(rankStringBuilder.toString());
        }
    }
}
