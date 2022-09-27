import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int H = sc.nextInt();
        final int W = sc.nextInt();
        String[] line;
      	for(int i = 0; i < H; i++) {
      	    line = sc.next().split("");
      	    for(int j = 0; j < W; j++) {
                // 左端または左隣が"#"の場合
      	        if(j == 0 || line[j-1].equals("#")) {
                    // 右端または右隣が"#"の場合
      	            if(j == W-1 || line[j+1].equals("#")) {
      	                System.out.println(i + " " + j);
      	            }
      	        }
      	    }
      	}
    }
}
