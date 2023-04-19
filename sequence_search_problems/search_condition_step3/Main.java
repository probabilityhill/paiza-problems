import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int[] ARRAY = new int[N];
        for(int i = 0; i < N; i++) {
            ARRAY[i] = sc.nextInt();
        }
        final int K = sc.nextInt();
        int max = -101;
        int n;
        for(int i = 0; i < N; i++) {
            n = ARRAY[i];
            if(n <= K) {
                max = Math.max(max, n);
            }
        }
        System.out.println(max);
    }
}
