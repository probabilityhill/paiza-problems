import java.util.*;

public class Main {
    static class Node {
        int dist;
        int idx;
        Node(int dist, int idx) {
            this.dist = dist;
            this.idx = idx;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int numNodes = sc.nextInt();
        final int startNode = sc.nextInt();
        final int endDist = sc.nextInt();
        // 隣接リスト作成
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList<>());
        }
        int el, er;
        for(int i = 0; i < numNodes - 1; i++) {
            el = sc.nextInt();
            er = sc.nextInt();
            adjList.get(el - 1).add(er - 1);
            adjList.get(er - 1).add(el - 1);
        }
        // 訪問済みのチェックを行う配列作成
        boolean[] visited = new boolean[numNodes];
        visited[startNode - 1] = true;
        // キュー作成
        ArrayDeque<Node> queue = new ArrayDeque<>();
        // 最初のノードをキューに追加
        queue.add(new Node(0, startNode - 1));

        // キューが空になったら終了
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            // 先頭を取得＆キューから削除
            Node nowNode = queue.poll();
            if(nowNode.dist >= endDist) {
                result.add(nowNode.idx + 1);
                continue;
            }
            // 隣接ノードを取得
            for(int adjNodeIdx : adjList.get(nowNode.idx)) {
                // 未訪問であれば隣接ノードをキューに追加し訪問済みにする
                if(!visited[adjNodeIdx]) {
                    queue.add(new Node(nowNode.dist + 1, adjNodeIdx));
                    visited[adjNodeIdx] = true;
                }
            }
        }
        Collections.sort(result);
        for(int i : result) {
            System.out.println(i);
        }
    }
}
