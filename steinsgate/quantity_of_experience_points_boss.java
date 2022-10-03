import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final double K = sc.nextDouble();
        double sum = 0;
        for(int i = 0; i < N; i++) {
            sum += sc.nextDouble();
        }
        if((int)(sum * 10) % (int)(K * 10) == 0) {
            System.out.println((int)(sum / K));
        } else {
            System.out.println((int)(sum / K) + 1);
        }
        
    }
}
