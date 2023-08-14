// 21

import java.util.*;

public class Main {
    private static final int MAX_DIST = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int X = sc.nextInt();

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
        queue.add(new Node(X - 1, 0));
        isVisited[X - 1] = true;

        List<Integer> answerNodes = new ArrayList<>();

        while(!queue.isEmpty()) {
            Node currNode = queue.poll();

            // 上限の距離に達したら記録しスキップ
            if(currNode.dist == MAX_DIST) {
                answerNodes.add(currNode.idx + 1);
                continue;
            }

            // 未訪問の隣接ノードをキューに追加
            List<Integer> adjNodes = adjNodesList.get(currNode.idx);
            for(int nodeIdx : adjNodes) {
                if(!isVisited[nodeIdx]) {
                    isVisited[nodeIdx] = true;
                    queue.add(new Node(nodeIdx, currNode.dist + 1));
                }
            }
        }

        // 頂点番号を昇順で出力
        Collections.sort(answerNodes);
        for(int n : answerNodes) {
            System.out.println(n);
        }
    }
}

class Node {
    int idx;
    int dist;

    Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}
