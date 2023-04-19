import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int A1 = sc.nextInt();
        final int A2 = sc.nextInt();
        System.out.printf("%d %d", Math.max(A1, A2), Math.min(A1, A2));
    }
}
