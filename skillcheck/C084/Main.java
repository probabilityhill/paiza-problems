import java.util.*;

public class Main {
    private static final String PLUS = "+";
    
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final String S = sc.next();

        // 線作成
        StringBuilder line  = new StringBuilder();
        for(int i = 0; i < S.length() + 2; i++) {
            line.append(PLUS);
        }

        // 出力
        System.out.println(line + "\n" + PLUS + S + PLUS + "\n" + line);
    }
}
