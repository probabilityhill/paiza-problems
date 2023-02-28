import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final int  N_SINGER = sc.nextInt();
        final int LEN_SONG = sc.nextInt();
        final int[] PITCH_LIST = new int[LEN_SONG];
        int score;
        int maxScore = 0;
        
        for (int i = 0; i < LEN_SONG; i++) {
            PITCH_LIST[i] = sc.nextInt();
        }
        
        for (int i = 0; i < N_SINGER; i++) {
            score = 100;
            for (int j = 0; j < LEN_SONG; j++) {
                score = getScore(score, sc.nextInt(), PITCH_LIST[j]);
            }
            if (score < 0) {
                score = 0;
            }
            if (score > maxScore) {
                maxScore = score;
            }
        }
        System.out.println(maxScore);
    }
    
    public static int getScore(int sc, int result, int correctPitch) {
        int error = Math.abs(result - correctPitch);
        if (error <= 5) {
            return sc;
        } else if (error <= 10) {
            return sc-1;
        } else if (error <= 20) {
            return sc-2;
        } else if (error <= 30) {
            return sc-3;
        } else {
            return sc-5;
        }
    }
    
}
