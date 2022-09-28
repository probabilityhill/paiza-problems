import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numArray = new int[1000];
        for(int i = 0; i < 1000; i++) {
            numArray[i] = sc.nextInt();
        }
        for(int n : numArray) {
            System.out.println(n); 
        }
        sc.close();
    }
}
