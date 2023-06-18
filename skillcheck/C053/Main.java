import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalPlayer = sc.nextInt();

        List<Integer> cards = new ArrayList<>();

        boolean hasX10 = false;

        for(int i = 0; i < totalPlayer; i++) {
          String card = sc.next();
          
          if(card.equals("x10")) {
            hasX10 = true;
            continue;
          }

          int cardNum = Integer.parseInt(card);
          cards.add(cardNum);
        }

        // 0を持っていたら最大値を0にする
        if(cards.contains(0)) {
            int maxNum = Collections.max(cards);
            cards.set(cards.indexOf(maxNum), 0);
        }

        // 合計点の計算
        int score = 0;
        for(int c : cards) {
            score += c;
        }

        // x10を持っていたら得点を10倍にする
        if(hasX10) {
            score *= 10;
        }

        // 得点の出力
        System.out.println(score);
    }
}
