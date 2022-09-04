import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int t;
        String str = "No";
        for (int i = 0; i < 9; i++) {
            t = sc.nextInt();
            if (Math.abs(t - y) >= 3) {
                str = "Yes";
                break;
            }
            y = t;
        }
        System.out.println(str);
    }
}
