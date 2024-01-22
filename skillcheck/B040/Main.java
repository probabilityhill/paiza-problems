import java.util.*;

public class Main {
    private static final int TOTAL_ALPHABETS = 26;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 置換回数
            final int n = sc.nextInt();
            // 暗号化を表す文字配列
            final char[] encryptRule = sc.next().toCharArray();
            // 改行を読み飛ばす
            sc.nextLine();
            // 暗号文字配列
            final char[] encryptedChars = sc.nextLine().toCharArray();

            // 復号を表すマップを作成
            final Map<Character, Character> decryptMap = new HashMap<>();
            for(int i = 0; i < TOTAL_ALPHABETS; i++) {
                decryptMap.put(encryptRule[i], (char)('a' + i));
            }
            // 半角スペースはそのまま
            decryptMap.put(' ', ' ');

            final int totalChars = encryptedChars.length;
            char[] decryptedChars = encryptedChars;
            // n回復号する
            for(int i = 0; i < n; i++){
                // 1文字ずつ復号する
                for(int j = 0; j < totalChars; j++){
                    decryptedChars[j] = decryptMap.get(decryptedChars[j]);
                }
            }

            // 復号文を出力
            System.out.println(String.valueOf(decryptedChars));
        }
    }
}
