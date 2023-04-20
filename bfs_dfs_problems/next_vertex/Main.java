import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int X = sc.nextInt();
        final int[][] EDGES = new int[N - 1][2];
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 2; j++) {
                EDGES[i][j] = sc.nextInt();
            }
        }
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 2; j++) {
                if(X == EDGES[i][j]) {
                    nodes.add(EDGES[i][1 - j]);
                }
            }
        }
        Collections.sort(nodes);
        for(Integer n : nodes) {
            System.out.println(n);
        }
    }
}

/*
解答例：隣接リストを用いて木の辺の情報を管理

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree.get(a - 1).add(b - 1);
            tree.get(b - 1).add(a - 1);
        }

        Collections.sort(tree.get(X - 1));
        for (int x : tree.get(X - 1)) {
            System.out.println(x + 1);
        }
    }
}
*/
