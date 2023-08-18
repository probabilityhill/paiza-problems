// 22

import java.util.*;

public class Main {
    private static boolean[] isVisited;
    private static List<List<Integer>> adjNodesList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 頂点の数
        final int N = sc.nextInt();
        // 辺の本数
        final int M = sc.nextInt();
        // 頂点番号
        final int X = sc.nextInt();

        // 隣接ノードリスト
        adjNodesList = new ArrayList<>();
        // 初期化
        for(int i = 0; i < N; i++) {
            adjNodesList.add(new ArrayList<>());
        }
        // 隣接ノードを追加
        int n1, n2;
        for(int i = 0; i < M; i++) {
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            adjNodesList.get(n1 - 1).add(n2 - 1);
            adjNodesList.get(n2 - 1).add(n1 - 1);
        }

        // 訪問リスト
        isVisited = new boolean[N];
        
        dfs(X - 1);
    }

    private static void dfs(int nodeIdx) {
        // 現在の頂点番号を出力
        System.out.println(nodeIdx + 1);

        // 訪問済みにする
        isVisited[nodeIdx] = true;

        // 隣接ノードを取得
        List<Integer> adjNodes = adjNodesList.get(nodeIdx);
        // 昇順にソート
        Collections.sort(adjNodes);

        for(int adjNodeIdx : adjNodes) {
            // 未訪問であれば探索
            if(!isVisited[adjNodeIdx]) {
                dfs(adjNodeIdx);
            }
        }
    }
}
