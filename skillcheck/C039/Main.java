// 6

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final List<String> symbols = Arrays.asList(sc.next().split(""));

        // <の数の10倍と/の数の和を計算
        final int answer = Collections.frequency(symbols, "<") * 10 + Collections.frequency(symbols, "/");

        // 出力
        System.out.println(answer);
    }
}
