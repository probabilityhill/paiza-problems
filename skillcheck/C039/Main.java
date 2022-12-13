import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] symbols = sc.next().toCharArray();
        int sum = 0;
        for (char n : symbols) {
            if (n == '<') {
                sum += 10;
            }
            else if (n == '/') {
                sum += 1;
            }
        }
        System.out.println(sum);
    }
}
