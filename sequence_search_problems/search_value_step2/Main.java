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
        int idx = 0;
        for(int i = N - 1; i >= 0; i--) {
            if(ARRAY[i] == K) {
                idx = i + 1;
                break;
            }
        }
        System.out.println(idx);
    }
}
