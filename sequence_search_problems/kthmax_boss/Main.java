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
        int max = 1000000001;
        for(int i = 0; i < K; i++) {
            int nextMax = -1000000001;
            for(int j = 0; j < N; j++) {
                int n = ARRAY[j];
                if(n < max) {
                    nextMax = Math.max(nextMax, n);
                }
            }
            max = nextMax;
        }
        System.out.println(max);
    }
}
