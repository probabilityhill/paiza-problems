import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 条件の数
        final int N = sc.nextInt();

        // 100以下の自然数をリストに追加
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            nums.add(i);
        }

        for(int i = 0; i < N; i++) {
            final String o = sc.next();
            final int x = sc.nextInt();

            // 条件を満たす数のみ抽出
            List<Integer> filteredNums = nums.stream()
                .filter(num -> {
                    switch(o) {
                        case "<":
                            return num < x;
                        case ">":
                            return num > x;
                        case "/":
                            return num % x == 0;
                    }
                    return false;
                }).collect(Collectors.toList());

            // リストを更新
            nums = filteredNums;    
        }
    
        // 残った数を出力
        System.out.println(nums.get(0));
    }
}
