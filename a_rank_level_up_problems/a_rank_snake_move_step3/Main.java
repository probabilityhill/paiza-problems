import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        final String D = sc.next();  // N, S, E, W
        final int LR_MOVE = sc.next().equals("L") ? 1 : -1;
        if(D.equals("N")) {
            x -= LR_MOVE;
        }
        else if(D.equals("E")) {
            y -= LR_MOVE;
        }
        else if(D.equals("S")) {
            x += LR_MOVE; 
        }
        else {
            y += LR_MOVE;
        }
        System.out.println(y + " " + x);
    }
}
