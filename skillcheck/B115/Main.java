// 40分

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int totalWords = sc.nextInt();
        // 単語リスト
        final List<String> words = new ArrayList<>();
        for(int i = 0; i < totalWords; i++) {
            words.add(sortWord(sc.next()));
        }
        // 単語の組み合わせのリスト
        final List<String> combinedWords = new ArrayList<>();
        for(int i = 0; i < totalWords; i++) {
            for(int j = i; j < totalWords; j++) {
                combinedWords.add(sortWord(words.get(i) + words.get(j)));
            }
        }

        // 成立する組み合わせの数
        int countCombo = 0;

        for(String s : combinedWords) {
            countCombo += Collections.frequency(words, s);
        }

        // 出力
        System.out.println(countCombo);
    }

    // 文字列を辞書順にソート
    public static String sortWord(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
