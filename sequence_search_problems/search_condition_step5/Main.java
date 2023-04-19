import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int[] X = new int[N];
        final int[] Y = new int[N];
        for(int i = 0; i < N; i++) {
            X[i] = sc.nextInt();
            Y[i] = sc.nextInt();
        }
        final int X_LEFT = sc.nextInt();
        final int X_RIGHT = sc.nextInt();
        final int Y_BOTTOM = sc.nextInt();
        final int Y_TOP = sc.nextInt();
        int count = 0;
        for(int i = 0; i < N; i++) {
            // 点が長方形の内部に含まれていたらカウント
            if(X[i] >= X_LEFT && X[i] <= X_RIGHT && Y[i] >= Y_BOTTOM && Y[i] <= Y_TOP) {
                count++;
            }
        }
        System.out.println(count);
    }
}
