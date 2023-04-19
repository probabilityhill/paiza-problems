import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        int max = -1000000000;
        int min = 1000000000;
        int n;
        for(int i = 0; i < N; i++) {
            n = sc.nextInt();
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        System.out.printf("%d %d", max, min);
    }
}
