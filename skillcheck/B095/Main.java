// 25

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int totalPeople = sc.nextInt();
        final int songLen = sc.nextInt();
        final int[] correctPitch = new int[songLen];
        for(int i = 0; i < songLen; i++) {
            correctPitch[i] = sc.nextInt();
        }
        int maxScore = 0;
        for(int i = 0; i < totalPeople; i++) {
            int score = 100;
            for(int cp : correctPitch) {
                int realPitch = sc.nextInt();
                score -= diffScore(realPitch, cp);
            }
            score = Math.max(0, score);
            maxScore = Math.max(maxScore, score);
        }
        
        System.out.println(maxScore);

    }

    // 減点される点数
    public static int diffScore(int realPitch, int correctPitch) {
        int error = Math.abs(realPitch - correctPitch);
        if(error <= 5) {
            return 0;
        }
        if(error <= 10) {
            return 1;
        }
        if(error <= 20) {
            return 2;
        }
        if(error <= 30) {
            return 3;
        }
        return 5;
    }
}

