import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        String[][] map = new String[H][W+2];
        String[] line;
      	for(int i = 0; i < H; i++) {
      	    line = sc.next().split("");     // 行を読み込んで配列に
      	    map[i][0] = "#";                // 左端を埋める
      	    for(int j = 1; j <= W; j++) {
      	        map[i][j] = line[j-1];      // mapに読み込んだ行を代入
      	    }
        	map[i][W+1] = "#";              // 右端を埋める
      	}
      	for(int i = 0; i < H; i++) {
        	for(int j = 1; j <= W; j++) {
        	    // 左右が"#"なら座標を出力
                if(map[i][j-1].equals("#") && map[i][j+1].equals("#")) {
                    System.out.println(i + " " + (j-1));
                }
        	}      		
      	}
    }
}
