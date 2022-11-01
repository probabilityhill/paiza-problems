import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        final String D = sc.next();         // N, S, E, W
        final String DIR_MOVE = sc.next();  // L, R
        if(D.equals("N")) {
            if(DIR_MOVE.equals("L")) {
                x -= 1;
            }
            else {
                x += 1;
            }
        }
        else if(D.equals("E")) {
            if(DIR_MOVE.equals("L")) {
                y -= 1;
            }
            else {
                y += 1;
            }   
        }
        else if(D.equals("S")) {
            if(DIR_MOVE.equals("L")) {
                x += 1;
            }
            else {
                x -= 1;
            }   
        }
        else {
            if(DIR_MOVE.equals("L")) {
                y += 1;
            }
            else {
                y -= 1;
            }   
        }
        System.out.println(y + " " + x);
    }
}
