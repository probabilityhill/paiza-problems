// 20

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt() - 1;

        int num = N;
        String cellName = "";

        while(num >= 0) {
            char lastDigit = (char)('A' + num % 26);
            cellName = lastDigit + cellName;
            num /= 26;
            // 繰り上がる場合はマイナス1する
            num--;
        }
        
        // 出力
        System.out.println(cellName);
    }
}
