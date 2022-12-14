import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NUM_FOOD = sc.nextInt();                    // 必要な食材の数
        Map<String, Integer> FOOD_LIST = new HashMap<>();     // 必要な食材リスト
        for (int i = 0; i < NUM_FOOD; i++) {
            FOOD_LIST.put(sc.next(), sc.nextInt());
        }
        final int NUM_MY_FOOD = sc.nextInt();                 // 持っている食材の数
        // 持っている食材の数の方が少なければ0人前確定
        if (NUM_FOOD > NUM_MY_FOOD) {
            System.out.println(0);
            System.exit(0);
        }
        Map<String, Integer> MY_FOOD_LIST = new HashMap<>();  // 持っている食材リスト
        String myFood;
        int numMyFood;
        for (int i = 0; i < NUM_MY_FOOD; i++) {
            myFood = sc.next();
            numMyFood = sc.nextInt();
            // 必要な食材リストに含まれる食材を追加
            if (FOOD_LIST.containsKey(myFood)) {
                MY_FOOD_LIST.put(myFood, numMyFood);
            }
        }
        // 必要な食材を持っていないければ0人前確定
        if (NUM_FOOD > MY_FOOD_LIST.size()) {
            System.out.println(0);
            System.exit(0);
        }
        // 食材ごとのnumDish(人前)の最小値を求める
        int numDish = 10000;
        for (Map.Entry<String, Integer> entry : MY_FOOD_LIST.entrySet()) {
            numDish = Math.min(numDish, entry.getValue() / FOOD_LIST.get(entry.getKey()));
        }
        System.out.println(numDish);
    }
}
