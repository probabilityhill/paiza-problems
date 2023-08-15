// 16

import java.util.*;

public class Main {
    // 隣接ノードリスト
    private static List<List<Integer>> adjList;
    private static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int X = sc.nextInt();

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

        isVisited = new boolean[N];
        
        dfs(X - 1);

    }

    private static void dfs(int currNodeIdx) {
        // 訪れた頂点番号を出力
        System.out.println(currNodeIdx + 1);

        // 訪問済みにする
        isVisited[currNodeIdx] = true;

        // 未訪問の隣接ノードを昇順に探索する
        List<Integer> currAdjNodes = adjList.get(currNodeIdx);
        Collections.sort(currAdjNodes);
        for(int adjNodeIdx : currAdjNodes) {
            if(!isVisited[adjNodeIdx]) {
                dfs(adjNodeIdx);
            }
        }
    }
}
