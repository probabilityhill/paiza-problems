import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g_1 = sc.nextInt();
        int p_1 = sc.nextInt();
        int g_2 = sc.nextInt();
        int p_2 = sc.nextInt();
        System.out.println(p_1 * g_2 < p_2 * g_1 ? 1 : 2);
    }
}
