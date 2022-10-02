import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            int m = sc.nextInt();
            for(int j = 0; j < m; j++) {
                System.out.print(sc.nextInt()); 
                if(j != m-1) {
                    System.out.print(" "); 
                }
            }
            System.out.println();
        }
        sc.close();
    }
}

