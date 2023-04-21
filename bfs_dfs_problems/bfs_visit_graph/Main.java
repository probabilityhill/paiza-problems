import java.util.*;

public class Main {
    static class Node {
        int idx;
        ArrayList<Integer> adjList;
        boolean visited;
        Node(int idx, ArrayList<Integer> adjList, boolean visited) {
            this.idx = idx;
            this.adjList = adjList;
            this.visited = visited;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int numNodes = sc.nextInt();
        final int numEdges = sc.nextInt();
        final int nodeX = sc.nextInt();
        // ノードリスト作成
        ArrayList<Node> nodes = new ArrayList<>();
        for(int i = 0; i < numNodes; i++) {
            nodes.add(new Node(i, new ArrayList<>(), false));
        }
        // 隣接リストを記録
        for(int i = 0; i < numEdges; i++) {
            int el = sc.nextInt();
            int er = sc.nextInt();
            nodes.get(el - 1).adjList.add(er - 1);
            nodes.get(er - 1).adjList.add(el - 1);
        }
        // 隣接リストをソート
        for(int i = 0; i < numNodes; i++) {
            Collections.sort(nodes.get(i).adjList);
        }
        // キュー作成
        ArrayDeque<Node> queue = new ArrayDeque<>();
        // 最初のノードをキューに追加
        Node startNode = nodes.get(nodeX - 1);
        startNode.visited = true;
        queue.add(startNode);

        // キューが空になるまで繰り返し
        ArrayList<Integer> route= new ArrayList<>();
        while(!queue.isEmpty()) {
            // 先頭を取得＆キューから削除
            Node nowNode = queue.poll();
            // 経路に追加
            route.add(nowNode.idx + 1);
            // 隣接ノードを取得
            for(int adjNodeIdx : nowNode.adjList) {
                Node adjNode = nodes.get(adjNodeIdx);
                // 未訪問であれば訪問済みにし隣接ノードをキューに追加
                if(!adjNode.visited) {
                    adjNode.visited = true;
                    queue.add(adjNode);
                }
            }
        }
        // 経路を出力
        for(int r : route) {
            System.out.println(r);
        }
    }
}
