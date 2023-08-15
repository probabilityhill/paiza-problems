// 7

import java.util.*;

public class Main {
    private static final String INCORRECT = "n";
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();

        final List<Integer> answer = new ArrayList<>();

        // 1度でも間違えていたらリストに追加
        String A, B;
        for(int i = 0; i < N; i++) {
            A = sc.next();
            B = sc.next();
            if(INCORRECT.equals(A) || INCORRECT.equals(B)) {
                answer.add(i + 1);
            }
        }

        // 問題番号を昇順にソート
        Collections.sort(answer);

        // 問題数と番号を出力
        System.out.println(answer.size());
        for(int n : answer) {
            System.out.println(n);
        }
    }
}
