import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 手札の個数
        final int totalSets = sc.nextInt();

        // 役の判定結果
        String result = "";

        for(int i = 0; i < totalSets; i++) {
            int cards = sc.nextInt();

            // 役を判定
            if(cards % 1111 == 0) {
                result = "Four Card";
            }
            else if(((cards % 1000) % 111 == 0) || ((cards / 10)  % 111 == 0)) {
                result = "Three Card";
            }
            else if(((cards % 100) % 11 == 0) && ((cards / 100)  % 11 == 0)) {
                result = "Two Pair";
            }
            else if(((cards % 100) % 11 == 0) || ((cards / 100)  % 11 == 0) || (((cards % 1000) / 10) % 11 == 0)) {
                result = "One Pair";
            }
            else {
                result = "No Pair";
            }
            
            // 結果を出力
            System.out.println(result);
        }
    }
}
