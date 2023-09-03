// 35

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        final int K = sc.nextInt();

        final List<Integer> unvisitedStores = new ArrayList<>();
        final List<Integer> goodStores = new ArrayList<>();
        int starNum;
        for(int si = 0; si < N; si++) {
            starNum = sc.nextInt();
            if(starNum == 0) {
                unvisitedStores.add(si);
            }
            if(starNum == 3) {
                goodStores.add(si);
            }
        }

        final int[][] reviews = new int[M][N];
        for(int ui = 0; ui < M; ui++) {
            for(int si = 0; si < N; si++) {
                reviews[ui][si] = sc.nextInt();
            }
        }

        // 好みが似ているユーザー：自分とそのユーザーの両方とも評価が星3である店の数がK以上
        final List<Integer> similarTastesUsers = new ArrayList<>();
        for(int ui = 0; ui < M; ui++) {
            int threeStarsCount = 0;
            for(int si : goodStores) {
                if(reviews[ui][si] == 3) {
                    threeStarsCount++;
                }
            }
            if(threeStarsCount >= K) {
                similarTastesUsers.add(ui);
            }
        }

        // おすすめの店: 好みが似ているユーザーが星3の評価をしているかつ未訪問の店
        final Set<String> recommendedStores = new TreeSet<>();
        for(int ui : similarTastesUsers) {
            for(int si : unvisitedStores) {
                if(reviews[ui][si] == 3) {
                    recommendedStores.add(String.valueOf(si + 1));
                }
            }
        }

        String answer = "";
        if(recommendedStores.size() == 0) {
            answer = "no";
        }
        else {
            answer = String.join(" ", recommendedStores);
        }

        // 出力
        System.out.println(answer);
    }
}
