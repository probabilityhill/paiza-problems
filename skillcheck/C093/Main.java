import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = {sc.nextInt(), sc.nextInt()};

        // それぞれの点数を更新する
        for(int i = 0; i < 2; i++) {
            int score = scores[i];

            // 各位の和を計算
            int sum = 0;
            while(score > 0) {
                sum += score % 10;
                score /= 10;
            }

            // 点数を各位の和の一の位に更新
            scores[i] = sum % 10;
        }

        // 結果を判定する
        String result;
        if(scores[0] > scores[1]) {
            result = "Bob";
        }
        else if(scores[0] < scores[1]) {
            result = "Alice";
        }
        else {
            result = "Draw";
        }

        System.out.println(result);
    }
}
