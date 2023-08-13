import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int scoreBob = sc.nextInt();
        final int scoreAlice = sc.nextInt();

        // 比較用の点数を計算
        final int newScoreBob = calcScore(scoreBob);
        final int newScoreAlice = calcScore(scoreAlice);

        // 勝敗の判定
        String winner = null;
        if(newScoreBob > newScoreAlice) {
            winner = "Bob";
        }
        else if(newScoreBob < newScoreAlice) {
            winner = "Alice";
        }
        else {
            winner = "Draw";
        }
        
        // 出力
        System.out.println(winner);
    }

    private static int calcScore(int score) {
        // 各位の和を計算
        int sum = 0;
        while(score > 0) {
            sum += score % 10;
            score /= 10;
        }
        // 和の一の位を返す
        return sum % 10;
    }
}
