import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 出店する店舗の数
            final int storeCount = sc.nextInt();
            // 営業する月数
            final int openMonths = sc.nextInt();
            // 1店舗あたりの店舗の建設費用
            final int builtCost = sc.nextInt();
            // 1店舗あたりの毎月の人件費
            final int laborCost = sc.nextInt();
            // ラーメン1杯あたりの利益
            final int profit = sc.nextInt();

            // 総コスト
            final int totalCost = builtCost + laborCost * openMonths;

            // 閉店することになる店舗の数
            int closedStoreCount = 0;

            for (int storeIdx = 0; storeIdx < storeCount; storeIdx++) {
                // <storeIdx>番目の店舗が<openMonths>ヶ月間に販売したラーメンの杯数
                final int ramenCount = sc.nextInt();
                final int totalProfit = profit * ramenCount;

                // 総利益が総コストを下回る場合は閉店する
                if (totalProfit < totalCost) {
                    closedStoreCount++;
                }
            }

            System.out.println(closedStoreCount);
        }
    }
}
