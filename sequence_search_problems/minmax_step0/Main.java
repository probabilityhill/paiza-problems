import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int min = sc.nextInt();
        int tmp;
        if(max < min) {
            tmp = max;
            max = min;
            min = tmp;
        }
        System.out.printf("%d %d", max, min);        
    }
}
