import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int t;
        for (int i = 0; i < 9; i++) {
            t = sc.nextInt();
            if (Math.abs(t - y) >= 3) {
                System.out.println("Yes");
                System.exit(0);
            }
            y = t;
        }
        System.out.println("No");
    }
}
