import java.util.Scanner;

public class Main {
    public static String getDir(int n) {
        for(int i = 1; i <= n; i++) {
            if((2*i-1) * (2*i-1) == n) {
                return "E";
            }
            else if((2*i-1) * (2*i) == n) {
                return "S";
            }
            else if((2*i) * (2*i) == n) {
                return "W";
            }
            else if((2*i) * (2*i+1) == n) {
                return "N";
            }
            else if((2*i) * (2*i+1) > n) {
                break;
            }
        }
        return "X";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        final int N = sc.nextInt();
        String dir = "N";
        for(int i = 1; i <= N; i++) {
            if(dir.equals("N")) {
                x += 1;
            }
            else if(dir.equals("E")) {
                y += 1;
            }
            else if(dir.equals("S")) {
                x -= 1; 
            }
            else {
                y -= 1;
            }
            String d = getDir(i);
            dir = d == "X" ? dir : d;
        }
        System.out.println(x + " " + y);
    }
}
