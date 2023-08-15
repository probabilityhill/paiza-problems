import java.util.*;

public class Main {
    // 隣接ノードリスト
    private static List<List<Integer>> adjList;
    private static boolean[] isVisited;
    private static int dfsCount;
    private static int Y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int X = sc.nextInt();
        Y = sc.nextInt();

        // 隣接ノードリスト作成
        adjList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        int n1, n2;
        for(int i = 0; i < N - 1; i++) {
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            adjList.get(n1 - 1).add(n2 - 1);
            adjList.get(n2 - 1).add(n1 - 1);
        }
        // 昇順にソート
        for(int i = 0; i < N; i++) {
            Collections.sort(adjList.get(i));
        }
        
        // BFS
        int bfsCount = 0;
        isVisited = new boolean[N];
        isVisited[X - 1] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(X - 1);
        
        while(!queue.isEmpty()) {
            int currNodeIdx = queue.poll();

            // 訪問数をカウント
            bfsCount++;

            if(currNodeIdx == Y - 1) {
                break;
            }

            // 未訪問の隣接ノードを昇順に探索する
            List<Integer> currAdjNodes = adjList.get(currNodeIdx);
            for(int adjNodeIdx : currAdjNodes) {
                if(!isVisited[adjNodeIdx]) {
                    // 訪問済みにする
                    isVisited[currNodeIdx] = true;
                    // キューに追加
                    queue.add(adjNodeIdx);
                }
            }
        }

        // DFS
        dfsCount = 0;
        isVisited = new boolean[N];

        dfs(X - 1);

        // 結果を判定
        String result = "";
        if(bfsCount < dfsCount) {
            result = "bfs";
        }
        else if(bfsCount > dfsCount) {
            result = "dfs";
        }
        else {
            result = "same";
        }

        // 出力
        System.out.println(result);

    }

    private static void dfs(int currNodeIdx) {

        if(isVisited[Y - 1]) {
            return;
        }

        // 訪問数をカウント
        dfsCount++;

        // 訪問済みにする
        isVisited[currNodeIdx] = true;

        // 未訪問の隣接ノードを昇順に探索する
        List<Integer> currAdjNodes = adjList.get(currNodeIdx);
        for(int adjNodeIdx : currAdjNodes) {
            if(!isVisited[adjNodeIdx]) {
                dfs(adjNodeIdx);
            }
        }
    }
}
