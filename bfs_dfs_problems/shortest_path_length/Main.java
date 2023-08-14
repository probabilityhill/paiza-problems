import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        final int X = sc.nextInt();
        final int Y = sc.nextInt();

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
        queue.add(new Node(X - 1, 0));
        visitedList.add(X - 1);

        int ansDist = -1;

        while(!queue.isEmpty()) {
            Node currNode = queue.poll();

            // Yに到達したら距離を記録して終了
            if(currNode.idx == Y - 1) {
                ansDist = currNode.dist;
            }

            // 未訪問の隣接ノードをキューに追加
            List<Integer> adjNodes = adjNodesList.get(currNode.idx);
            for(int nodeIdx : adjNodes) {
                if(!visitedList.contains(nodeIdx)) {
                    visitedList.add(nodeIdx);
                    Node adjNode = new Node(nodeIdx, currNode.dist + 1);
                    queue.add(adjNode);
                }
            }
        }

        // 距離を出力
        System.out.println(ansDist);
    }
}

class Node {
    int idx, dist;

    Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}
