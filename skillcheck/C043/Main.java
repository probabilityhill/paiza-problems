import java.util.*;

public class Main {
    private static final int MAX_ID_COUNT = 10000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final Integer N = sc.nextInt();
        // 頻度記録用配列
        int[] freqArray = new int[MAX_ID_COUNT];
        for(int i = 0; i < N; i++) {
            freqArray[sc.nextInt() - 1]++;
        }

        // 最頻値
        int mode = 0;
        // 最頻値idリスト
        List<Integer> modeIds = new ArrayList<>();
        int freq;
        for(int i = 0; i < MAX_ID_COUNT; i++) {
            freq = freqArray[i];
            if(freq < mode) {
                continue;
            }
            // 最頻値を更新した際は最頻値idリストをクリア
            if(freq > mode) {
                mode = freqArray[i];
                modeIds.clear();
            }
            modeIds.add(i + 1);
        }

        // idを昇順にソート
        Collections.sort(modeIds);

        // スペース区切りで出力
        StringBuilder sb = new StringBuilder();
        for(int id : modeIds) {
            sb.append(id + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
