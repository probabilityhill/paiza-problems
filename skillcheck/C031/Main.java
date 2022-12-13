import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        Map<String, Integer> list = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            list.put(sc.next(), sc.nextInt());
        }
        final String PLACE = sc.next();
        String[] TIME = sc.next().split(":"); 
        final int H = Integer.parseInt(TIME[0]);
        final int M = Integer.parseInt(TIME[1]);
        int diffHour = H - list.get(PLACE);
        int hour;
        for (Integer n : list.values()) {
            hour = diffHour + n;
            if (hour < 0) {
                hour += 24;
            }
            else if (hour >= 24) {
                hour -= 24;
            }
            System.out.println(String.format("%02d:%02d", hour, M));
        }
        
    }
}
