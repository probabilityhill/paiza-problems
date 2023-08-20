// 28

import java.util.*;

public class Main {
    private static List<String> MOVE_DIR = Arrays.asList("Yes", "No");
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 次の質問を持つ質問の総数
        final int totalInnerNodes = sc.nextInt();
        // 回答者の回答数
        final int totalMovement = sc.nextInt();
        // 回答者が最初に答える質問の番号
        final int firstNodeNum = sc.nextInt();

        // 次のノードを格納するマップ
        Map<Integer, int[]> nextNodes = new HashMap<>();
        int nodeNum, leftNodeNum, rightNodeNum;
        for(int i = 0; i < totalInnerNodes; i++) {
            nodeNum = sc.nextInt();
            leftNodeNum = sc.nextInt();
            rightNodeNum = sc.nextInt();
            nextNodes.put(nodeNum - 1, new int[]{leftNodeNum - 1, rightNodeNum - 1});
        }

        int nodeIdx = firstNodeNum - 1;
        String nextMoveDir;
        for(int i = 0; i < totalMovement; i++) {
            nextMoveDir = sc.next();
            // 次の質問へ移動する
            nodeIdx = nextNodes.get(nodeIdx)[MOVE_DIR.indexOf(nextMoveDir)];
        }

        System.out.println(nodeIdx + 1);
    }
}
