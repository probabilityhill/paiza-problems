// 6

import java.util.*;

public class Main {
    public static void main(String[] args) {
    	// 入力
        Scanner sc = new Scanner(System.in);
        int[] cards = new int[4];
        for(int i = 0; i < 4; i++) {
            cards[i] = sc.nextInt();
        }

        // カードを昇順にソート
        Arrays.sort(cards);

        // 和が最大となるのは小さい数2つが一の位、大きい数2つが十の位の場合
        int maxScore = cards[0] + cards[1] + cards[2] * 10 + cards[3] * 10;

    	// 出力
        System.out.println(maxScore);
    }
}
