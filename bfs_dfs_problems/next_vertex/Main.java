// 10

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int X = sc.nextInt();

        // 隣接ノード
        List<List<Integer>> adjNodes = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjNodes.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            adjNodes.get(n1 - 1).add(n2 - 1);
            adjNodes.get(n2 - 1).add(n1 - 1);
        }
        List<Integer> answerNodes = adjNodes.get(X - 1);
        Collections.sort(answerNodes);
        for(int n : answerNodes) {
            System.out.println(n + 1);
        }
    }
}
