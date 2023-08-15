// 11

import java.util.*;

public class Main {
    private static final String[][] RULES = {{"A", "4"}, {"E", "3"}, {"G", "6"}, {"I", "1"}, {"O", "0"}, {"S", "5"}, {"Z", "2"}};
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        // Leetに変換
        for(String[] rule : RULES) {
            word = word.replaceAll(rule[0], rule[1]);
        }

        // 出力
        System.out.println(word);
    }
}
