// 18

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 連休の日数
        final int totalHolidays = sc.nextInt();
        // 旅行の日数
        final int totalTravelDays = sc.nextInt();

        // 降水確率を記録する配列
        int[] chanceOfRainArray = new int[totalHolidays];
        // 連休の初日
        int firstHoliday = 0;

        int day, chanceOfRain;
        for(int i = 0; i < totalHolidays; i++) {
            day = sc.nextInt();
            chanceOfRain = sc.nextInt();
            // 連休の初日を記録
            if(i == 0) {
                firstHoliday = day;
            }
            chanceOfRainArray[i] = chanceOfRain;
        }

        // 降水確率の平均が最小 <=> 合計が最小
        // 降水確率の合計を求める
        List<Integer> sumList = new ArrayList<>();
        for(int i = 0; i < totalHolidays - totalTravelDays + 1; i++) {
            int sum = 0;
            for(int j = 0; j < totalTravelDays; j++) {
                sum += chanceOfRainArray[i + j];
            }
            sumList.add(sum);
        }
        
        int minSumIdx = sumList.indexOf(Collections.min(sumList));
        int firstTravelDay = firstHoliday + minSumIdx;
        int lastTravelDay = firstTravelDay + totalTravelDays - 1;

        System.out.println(firstTravelDay + " " + lastTravelDay);
    }
}
