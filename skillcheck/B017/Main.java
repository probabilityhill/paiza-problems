// 55

import java.util.*;

public class Main {
    private static final int TOTAL_ALPHABET = 26;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final char[] cards = sc.next().toCharArray();
        // アルファベットごとのカード数の記録
        final int[] cardCount = new int[TOTAL_ALPHABET];
        // ワイルドカードの数
        int wildCardCount = 0;

        // カードの枚数を記録
        for(char card : cards) {
            if(card == '*') {
                wildCardCount++;
            }
            else {
                cardCount[card - 'A']++;
            }
        }

        // カード数のソート
        Arrays.sort(cardCount);

        final int maxCardCount = cardCount[TOTAL_ALPHABET - 1];
        final int secondMaxCardCount = cardCount[TOTAL_ALPHABET - 2];
        final int pairNum = wildCardCount + maxCardCount;

        String hand = null;
        if(pairNum == 4) {
            hand = "FourCard";
        }
        else if(pairNum == 3) {
            hand = "ThreeCard";
        }
        else if(secondMaxCardCount == 2) {
            hand = "TwoPair";
        }
        else if(pairNum == 2) {
            hand = "OnePair";
        }
        else {
            hand = "NoPair";
        }

        System.out.println(hand);
    }
}
