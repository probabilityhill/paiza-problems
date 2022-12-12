import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        while (n > 1) {
            n /= 2;
        }
        if (n == 1) {
            System.out.println("OK");
        }
        else {
            System.out.println("NG");
        }
    }
}
