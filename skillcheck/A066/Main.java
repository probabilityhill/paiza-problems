// 33

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int[][] workingDays = new int[N][2];

        int A, B;
        int lastWorkingDay = 1;
        for(int i = 0; i < N; i++) {
            A = sc.nextInt();
            B = sc.nextInt();
            workingDays[i] = new int[]{A, B};
            lastWorkingDay = Math.max(B, lastWorkingDay);
        }
        
        boolean[] isWorkingDay = new boolean[lastWorkingDay];

        // 出勤日をtrueにする
        for(int[] days : workingDays) {
            for(int j = days[0] - 1; j <= days[1] - 1; j++) {
                isWorkingDay[j] = true;
            }
        }

        // 連続するtrueを数える
        int maxContWorkingDays = 0;
        int contWorkingDaysCount = 0;
        for(boolean b : isWorkingDay) {
            if(!b) {
                contWorkingDaysCount = 0;
                continue;
            }
            contWorkingDaysCount++;
            maxContWorkingDays = Math.max(contWorkingDaysCount, maxContWorkingDays);
        }

        System.out.println(maxContWorkingDays);
    }
}
