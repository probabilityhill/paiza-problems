// 47分

import java.util.*;

public class Main {

    private static final List<String> NUM_LIST = Arrays.asList(
        "1111110",
        "0110000",
        "1101101",
        "1111001",
        "0110011",
        "1011011",
        "1011111",
        "1110010",
        "1111111",
        "1111011"
    );

    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final String[] A = sc.nextLine().split(" ");
        final String[] B = sc.nextLine().split(" ");

        // AとBどちらも数字になるか判定する
        boolean[] isNum = {
            NUM_LIST.contains(String.join("", A)) && NUM_LIST.contains(String.join("", B)),
            NUM_LIST.contains(moveSymmetric(A)) && NUM_LIST.contains(moveSymmetric(B)),
            NUM_LIST.contains(moveRotate(A)) && NUM_LIST.contains(moveRotate(B))       
        };

        // 結果を出力
        for(boolean b : isNum) {
            System.out.println(b ? "Yes" : "No");
        }
    }

    // 対象移動する
    private static String moveSymmetric(String[] segment) {
        String[] movedSegment = segment.clone();
        swap(movedSegment, 1, 5);
        swap(movedSegment, 2, 4);
        return String.join("", movedSegment);
    }

    // 回転移動する
    private static String moveRotate(String[] segment) {
        String[] movedSegment = segment.clone();
        swap(movedSegment, 0, 3);
        swap(movedSegment, 1, 4);
        swap(movedSegment, 2, 5);
        return String.join("", movedSegment);
    }

    // 配列の要素をスワップする
    private static void swap(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

/*

input:
1 1 1 1 0 1 1
0 1 1 0 0 0 0

output:
Yes
No
No

--------------

input:
0 0 0 0 1 1 0
1 1 0 1 1 1 1

output:
No
Yes
No

 */
