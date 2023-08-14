import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        final int X = sc.nextInt();

        // 隣接ノードを記録
        List<List<Integer>> adjNodesList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjNodesList.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            adjNodesList.get(n1 - 1).add(n2 - 1);
            adjNodesList.get(n2 - 1).add(n1 - 1);
        }

        // 訪問管理
        List<Integer> visitedList = new ArrayList<>();

        // キュー
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(X - 1));
        visitedList.add(X - 1);

        while(!queue.isEmpty()) {
            Node currNode = queue.poll();

            // 未訪問の隣接ノードをキューに追加
            List<Integer> adjNodes = adjNodesList.get(currNode.idx);
            Collections.sort(adjNodes);
            for(int nodeIdx : adjNodes) {
                if(!visitedList.contains(nodeIdx)) {
                    visitedList.add(nodeIdx);
                    Node adjNode = new Node(nodeIdx);
                    queue.add(adjNode);
                }
            }
        }

        // 経路を出力
        for(int nodeIdx : visitedList) {
            System.out.println(nodeIdx + 1);
        }
    }
}

class Node {
    int idx;

    Node(int idx) {
        this.idx = idx;
    }
}
