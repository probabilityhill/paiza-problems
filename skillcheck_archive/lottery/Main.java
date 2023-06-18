import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 入力
        final int winningNum = sc.nextInt();
        final int totalTickets = sc.nextInt();

        // 1枚ずつ当選判定
        for(int i = 0; i < totalTickets; i++) {
            int lotterytNum = sc.nextInt();
            
            // 当選結果
            String result = "blank";

            if(lotterytNum == winningNum) {
                result = "first";
            }
            else if(Math.abs(lotterytNum - winningNum) == 1) {
                result = "adjacent";
            }
            else if((lotterytNum - winningNum) % 10000 == 0) {
                result = "second";
            }
            else if((lotterytNum - winningNum) % 1000 == 0) {
                result = "third";
            }

            // 当選結果を出力
            System.out.println(result);
        }
    }
}
