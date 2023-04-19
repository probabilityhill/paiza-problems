import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int max = -1000000000;
        int min = 1000000000;
        while(sc.hasNextInt()) {
            n = sc.nextInt();
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        System.out.printf("%d %d", max, min);
    }
}
