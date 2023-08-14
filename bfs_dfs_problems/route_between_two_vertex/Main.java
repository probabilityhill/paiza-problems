import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int X = sc.nextInt();
        final int Y = sc.nextInt();

        // 隣接ノードを記録
        List<List<Integer>> adjNodesList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjNodesList.add(new ArrayList<>());
        }
        for(int i = 0; i < N - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            adjNodesList.get(n1 - 1).add(n2 - 1);
            adjNodesList.get(n2 - 1).add(n1 - 1);
        }

        // 訪問管理
        boolean[] isVisited = new boolean[N];

        // キュー
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(X - 1, 0, Arrays.asList(X - 1)));
        isVisited[X - 1] = true;

        while(!queue.isEmpty()) {
            Node currNode = queue.poll();

            // Yに到達したら経路を出力して終了
            if(currNode.idx == Y - 1) {
                for(Integer nodeIdx : currNode.route) {
                    System.out.println(nodeIdx + 1);
                }
                break;
            }

            // 未訪問の隣接ノードをキューに追加
            List<Integer> adjNodes = adjNodesList.get(currNode.idx);
            for(int nodeIdx : adjNodes) {
                if(!isVisited[nodeIdx]) {
                    isVisited[nodeIdx] = true;
                    Node adjNode = new Node(nodeIdx, currNode.dist + 1, new ArrayList<>(currNode.route));
                    adjNode.route.add(adjNode.idx);
                    queue.add(adjNode);
                }
            }
        }
    }
}

class Node {
    int idx;
    int dist;
    List<Integer> route;

    Node(int idx, int dist, List<Integer> route) {
        this.idx = idx;
        this.dist = dist;
        this.route = route;
    }
}
