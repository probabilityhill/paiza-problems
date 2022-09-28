import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArray = sc.nextLine().split(" ");
        for(String s : strArray) {
            System.out.println(s); 
        }
        sc.close();
    }
}
