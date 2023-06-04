import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int SIZE_A = sc.nextInt();
        final int[] A = new int[SIZE_A];
        for(int i = 0; i < SIZE_A; i++) {
            A[i] = sc.nextInt();
        }
        final int Q = sc.nextInt();

        for(int i = 0; i < Q; i++) {
            int k = sc.nextInt();
            int left = 0;
            int right = SIZE_A - 1;
            String result = "No";

            while(left <= right) {
                int mid = (left + right) / 2;

                if(A[mid] == k) {
                    result = "Yes";
                    break;
                }
                else if(A[mid] < k) {
                    left = mid +1;
                }
                else {
                    right = mid - 1;
                }
            }
            System.out.println(result);
        }

    }
}
