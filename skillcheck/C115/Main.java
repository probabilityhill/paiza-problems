import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final int  N_CAR = sc.nextInt();          // 車の数
        final int BORDER = sc.nextInt();          // 渋滞を定義する整数
        int dir;                                  // 車間距離
        int sum = 0;                              // 渋滞区間の合計
        
        for (int i = 0; i < N_CAR-1; i++) {
            dir = sc.nextInt();
            if (dir <= BORDER) {
                sum += dir;
            }
        }
        System.out.println(sum);
    }
}
