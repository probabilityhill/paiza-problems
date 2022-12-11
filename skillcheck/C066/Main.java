import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final int NUM_FISH = sc.nextInt();
        int numPaper = sc.nextInt();
        final int DURABILITY = sc.nextInt();
        int hp = DURABILITY;
        int weight = sc.nextInt();
        int NumFishCaught = 0;
        
        while (true) {
            hp -= weight;
            // ポイが壊れたら
            if (hp <= 0) {
                // ポイが1枚減少
                numPaper--;
                // ポイがなくなったら終了
                if (numPaper == 0) {
                    break;
                }
                // hpが復活
                hp = DURABILITY;
            }
            else {
                // ポイが壊れなかったら金魚獲得
                NumFishCaught++;
                // 全て獲得したら終了
                if (NUM_FISH == NumFishCaught) {
                    break;
                }
                weight = sc.nextInt();
            }
        }
        System.out.println(NumFishCaught);
    }
}
