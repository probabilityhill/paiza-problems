import java.util.*;

public class Main {
    private static List<List<Integer>> adjNodesList;
    private static boolean[] isVisited;

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
        
        // 訪問を記録する配列
        isVisited = new boolean[N];
        // 連結成分の個数 
        int count = 0;

        // 全ての頂点を探索する
        for(int i = 0; i < N; i++) {
            if(!isVisited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int nodeIdx) {
        // 訪問を記録
        isVisited[nodeIdx] = true;

        // 隣接ノードを取得
        List<Integer> adjNodes = adjNodesList.get(nodeIdx);
        for(int adjNodeIdx : adjNodes) {
            // 未訪問であれば探索
            if(!isVisited[adjNodeIdx]) {
                dfs(adjNodeIdx);
            }
        }
    }
}
