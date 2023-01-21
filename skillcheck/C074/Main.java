import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        final int X = sc.nextInt();  // 変更後の横幅
        String txt = "";
        
        for (int i = 0; i < H; i++) {
            txt += sc.next();
        }
        while (true) {
            if (txt.length() < X) {
                System.out.println(txt);
                break;
            }
            System.out.println(txt.substring(0, X));
            txt = txt.substring(X);
        }
    }
}
