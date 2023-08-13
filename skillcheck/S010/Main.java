import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        // サイコロの面（T B U D L R）の数字
        final int[] dice = new int[6];
        for(int i = 0; i < 6; i++) {
            dice[i] = sc.nextInt();
        }
        // マスの総数
        final int totalSpaces = sc.nextInt();
        // ボード
        int[] board = new int[totalSpaces];
        for(int i = 0; i < totalSpaces; i++) {
            board[i] = sc.nextInt();
        }

        // 最小回転数
        int minCount = 0;

        int currNum, nextNum;
        for(int i = 0; i < totalSpaces - 1; i++) {
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
        // 表の数字のインデックスを求める
        int topIdx = 0;
        for(int i = 0; i < 6; i++) {
            if(topNum == dice[i]) {
                topIdx = i;
                break;
            }
        }

        // 底の数字のインデックスを求める
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
