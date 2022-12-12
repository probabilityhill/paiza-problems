import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int A = sc.nextInt();
        final int B = sc.nextInt();
        final int C = sc.nextInt();
        int[] prices = {A, B, C};
        Arrays.sort(prices);
        System.out.println(prices[1]);
    }
}
