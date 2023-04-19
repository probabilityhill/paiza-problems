import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int[][] ARRAY = new int[N][2];
        for(int i = 0; i < N; i++) {
            ARRAY[i][0] = sc.nextInt();
            ARRAY[i][1] = sc.nextInt();
        }
        final int K = sc.nextInt();
        int xi, yi;
        int xn = ARRAY[N - 1][0];
        int yn = ARRAY[N - 1][1];
        int manhattanDistance;  // マンハッタン距離
        int count = 0;
        for(int i = 0; i < N; i++) {
            xi = ARRAY[i][0];
            yi = ARRAY[i][1];
            manhattanDistance = Math.abs(xi - xn) + Math.abs(yi - yn);
            if(manhattanDistance <= K) {
                count++;
            }
        }
        System.out.println(count);
    }
}
