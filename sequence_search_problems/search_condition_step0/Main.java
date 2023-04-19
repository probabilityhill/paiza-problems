import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            if(sc.nextInt() % 2 == 0) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
