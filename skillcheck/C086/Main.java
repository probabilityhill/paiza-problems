// 5

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final String name = sc.next();

        // 母音を削除
        final String handleName = name.replaceAll("[aeiouAEIOU]", "");

        // 出力
        System.out.println(handleName);
    }
}
