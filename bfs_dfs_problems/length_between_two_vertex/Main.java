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
        final int nodeX = sc.nextInt();
        final int nodeY = sc.nextInt();
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
        visited[nodeX - 1] = true;
        // キュー作成
        ArrayDeque<Node> queue = new ArrayDeque<>();
        // 最初のノードをキューに追加
        queue.add(new Node(0, nodeX - 1));

        // 頂点Yが見つかるまで繰り返し
        int result;
        while(true) {
            // 先頭を取得＆キューから削除
            Node nowNode = queue.poll();
            // 頂点Yが見つかったら終了
            if(nowNode.idx == nodeY - 1) {
                result = nowNode.dist;
                break;
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
        System.out.println(result);
    }
}
