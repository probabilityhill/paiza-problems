import java.util.*;

class Main {
    private static final String NO_SOLUTION = "miss";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int totalLegs = sc.nextInt();
        final int totalHeads = sc.nextInt();
        final int craneLegsNum = sc.nextInt();
        final int turtleLegsNum = sc.nextInt();

        System.out.println(tsurukame(totalLegs, totalHeads, craneLegsNum, turtleLegsNum));
    }

    // 鶴亀算（面積図を用いた解法）
    private static String tsurukame(int totalLegs, int totalHeads, int craneLegsNum, int turtleLegsNum) {
        // 鶴と亀の足の数が同じとき、一意解となるのは鶴1羽かつ亀1匹の場合のみ
        if(craneLegsNum == turtleLegsNum) {
            if(totalHeads != 2) {
                return NO_SOLUTION;
            }
            if(craneLegsNum + turtleLegsNum != totalLegs) {
                return NO_SOLUTION;
            }
            return "1 1";
        }
        int craneNum = (totalHeads * turtleLegsNum - totalLegs) / (turtleLegsNum - craneLegsNum);
        if(craneNum <= 0 || craneNum >= totalHeads) {
            return  NO_SOLUTION;
        }
        return craneNum + " " + (totalHeads - craneNum);
    }
}
