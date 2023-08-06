import java.util.Scanner;

public class Main {
    private static char LINE = '.';

    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final char START_NUM = sc.next().charAt(0);

        // スタート地点のインデックスを記録
        int startColIdx = 0;
        char[] firstRow = sc.next().toCharArray();
        for(int i = 0; i < W; i++) {
            if(firstRow[i] == START_NUM) {
                startColIdx = i;
            }            
        }

        // あみだくじを入力
        final char[][] AMIDAKUJI = new char[H][W];
        for(int i = 1; i < H; i++) {
            AMIDAKUJI[i] = sc.next().toCharArray();
        }

        // 現在地
        int curRowIdx = 1;
        int curColIdx = startColIdx;
        
        while(curRowIdx < H - 1) {

            // 左に進めるだけ進む
            while(curColIdx - 1 >= 0 && AMIDAKUJI[curRowIdx][curColIdx - 1] == LINE) {
                curColIdx--;
            }

            // 右に進めるだけ進む
            while(curColIdx + 1 <= W - 1 && AMIDAKUJI[curRowIdx][curColIdx + 1] == LINE) {
                curColIdx++;
            }

            // 下に1つ進む
            curRowIdx++;
        }

        // ゴール番号を出力
        System.out.println(AMIDAKUJI[curRowIdx][curColIdx]);
    }
}

/*

input:
6 7 0 
1#0#2#3
...#.#.
...#.#.
.#...#.
.#.#...
2#1#0#3

output:
3

-----------

input:
5 3 1
0#1
.#.
.#.
.#.
1#0

output:
0

-----------

input:
4 7 0
#1##2#0
#....#.
#....#.
#0##1#2

output:
2

 */
