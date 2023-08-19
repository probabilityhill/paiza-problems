// 33

import java.util.*;

public class Main {
    private static List<List<Integer>> adjNodesList;
    private static int[] statusArray;
    private static final int UNVISITED = 0;
    private static final int RED = 1;
    private static final int BLUE = -1;
    private static boolean isBipartiteGraph = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 頂点の数
        final int N = sc.nextInt();
        // 辺の本数
        final int M = sc.nextInt();

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
        
        // ステータス配列
        statusArray = new int[N];

        // 全ての頂点を探索する
        for(int i = 0; i < N; i++) {
            if(statusArray[i] == UNVISITED) {
                dfs(i, RED);
            }
        }

        System.out.println(isBipartiteGraph ? "Yes" : "No");
    }

    private static void dfs(int nodeIdx, int status) {
        // ステータスを設定
        statusArray[nodeIdx] = status;

        // 隣接ノードを取得
        List<Integer> adjNodes = adjNodesList.get(nodeIdx);
        for(int adjNodeIdx : adjNodes) {
            // 未訪問であれば現在のノードと異なる色にする
            if(statusArray[adjNodeIdx] == UNVISITED) {
                dfs(adjNodeIdx, -status);
            }
            // ステータスが現在のノードと同じであれば終了
            else if(statusArray[adjNodeIdx] == status) {
                isBipartiteGraph = false;
                break;
            }
        }
    }
}
