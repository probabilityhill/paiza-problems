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
            if(binarySearch(SIZE_A, A, sc.nextInt())) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }

    public static boolean binarySearch(int n, int[] a, int val) {
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(a[mid] == val) {
                return true;
            }
            else if(a[mid] < val) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}
