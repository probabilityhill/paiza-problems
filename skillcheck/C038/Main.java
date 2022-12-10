import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        final int NUM_MACHINE = sc.nextInt();
        final int NUM_SNACK = sc.nextInt();
        int numCase;
        int numRest;
        int[] bestMachine = {0, 0, 1000};  // {i, numCase, numRest}
        for (int i = 1; i <= NUM_MACHINE; i++) {
            numCase = sc.nextInt();
            numRest = NUM_SNACK - NUM_SNACK / numCase * numCase;
            if ((numRest < bestMachine[2]) || (numRest == bestMachine[2] && numCase > bestMachine[1])) {
                bestMachine[0] = i;
                bestMachine[1] = numCase;
                bestMachine[2] = numRest;
            }
        }
        System.out.println(bestMachine[0]);
    }
}
