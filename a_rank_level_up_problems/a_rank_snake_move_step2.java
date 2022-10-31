import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        final int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            String dir = sc.next();
            if(dir.equals("N")) {
                y -= 1;
            }
            else if(dir.equals("W")) {
                x -= 1;
            }
            else if(dir.equals("E")) {
                x += 1;
            }
            else {
                y += 1;
            }
            System.out.println(y + " " + x);            
        }
    }
}
