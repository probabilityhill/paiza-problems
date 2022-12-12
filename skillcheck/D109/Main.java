import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next() + sc.next();
        char[] ary = s.toCharArray();
        boolean flag = true;
        for (int i = 1; i < ary.length; i++) {
            if (ary[i-1] != ary[i]) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
