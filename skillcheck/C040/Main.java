// 14

import java.util.*;

public class Main {
    private static final String GREATER_OR_EQUAL = "ge";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();

        List<Double> lowerLimits = new ArrayList<>();
        List<Double> upperLimits = new ArrayList<>();
        
        String c;
        double h;
        for(int i = 0; i < N; i++) {
            c = sc.next();
            h = sc.nextDouble();
            if(GREATER_OR_EQUAL.equals(c)) {
                lowerLimits.add(h);
            }
            else {
                upperLimits.add(h);
            }
        }

        // 身長の下限：各下限の最大値
        double lowerLimit = Collections.max(lowerLimits);
        // 身長の上限：各上限の最小値
        double upperLimit = Collections.min(upperLimits);

        // 出力
        System.out.println(lowerLimit + " " + upperLimit);
    }
}
