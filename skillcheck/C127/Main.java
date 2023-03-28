import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();                       // 来店するとキャンペーンの対象から外れる期間の日数
        int M = sc.nextInt();                       // キャンペーンの対象となる期間の日数
        String name;                                // 来店した客の名前
        Set<String> names = new HashSet<String>();  // 直近N日間に来店していない客の名前の集合
        for (int i = 0; i < M; i++) {
            name = sc.next();
            names.add(name);
            // 直近N日間に
            if (M - i <= N) {
                // 来店していたら
                if (names.contains(name)) {
                    // 集合から削除
                    names.remove(name);
                }
            }
        }
        System.out.println(names.size());
    }
}
