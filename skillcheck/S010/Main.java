// 31分

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        // サイコロの面（T B U D L R）の値
        final int[] dice = new int[6];
        for(int i = 0; i < 6; i++) {
            dice[i] = sc.nextInt();
        }
        // マスの総数
        final int N = sc.nextInt();
        // ボード
        int[] board = new int[N];
        for(int i = 0; i < N; i++) {
            board[i] = sc.nextInt();
        }

        // 最小回転数
        int minCount = 0;

        int currNum, nextNum;
        for(int i = 0; i < N - 1; i++) {
            currNum = board[i];
            nextNum = board[i + 1];

            // 次のマスが同じ数字であれば回転しない
            if(nextNum == currNum) {
                continue;
            }

            // 次のマスの数字が底の数字と同じ場合のみ2回転
            // それ以外は1回転
            if(nextNum == bottomNum(currNum, dice)) {
                minCount += 2;
            }
            else {
                minCount++;
            }
        }

        // 出力
        System.out.println(minCount);
    }

    // 表の数字から底の数字を得る
    private static int bottomNum(int topNum, int[] dice) {
        int topIdx = 0;
        for(int i = 0; i < 6; i++) {
            if(topNum == dice[i]) {
                topIdx = i;
                break;
            }
        }

        int bottomIdx = 0;
        if(topIdx % 2 == 0) {
            bottomIdx = topIdx + 1;
        }
        else {
            bottomIdx = topIdx - 1;
        }

        return dice[bottomIdx];
    }
}

/*

input:
1 6 2 5 4 3
4
1
5
3
4

output:
4

-------------

input:
6 5 4 3 2 1
6
6
2
1
3
4
3

output:
8

 */
