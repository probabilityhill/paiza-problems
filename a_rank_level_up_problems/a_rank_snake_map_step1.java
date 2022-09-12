import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int N = sc.nextInt();
        String[] map = new String[H];
        
        for (int i = 0; i < H; i++) {
            map[i] = sc.next();
        }
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(map[x].charAt(y));
        }        
        
    }
}
