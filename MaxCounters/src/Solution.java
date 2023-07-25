import java.util.Arrays;
import java.util.Scanner;



public class Solution {
    public static int[] solution(int N, int[] A) {

        // Create an array to store the counters, initialized to 0
        // Each element of counters represents the current value of a counter.
        int[] counters = new int[N];

        // Initialize variables to keep track of the current maximum value
        //  of any counter and the value of the last 'max_counter' operation, respectively.
        int currentMax = 0;
        int lastMaxCounterIndex = 0;

        // Iterate through the array of operations 'A' using variable 'i'
        for (int i = 0; i < A.length; i++) {

            // Get the current operation value and store it in
            // the variable 'operation'.
            int operation = A[i];

            // If the 'operation' is a valid increase operation
            // (i.e., it is between 1 and N inclusive), we
            // update the corresponding counter value by incrementing
            // it by 1. We also update the 'currentMax' value if the 
            // current counter value becomes greater than 'currentMax'.
            if (operation >= 1 && operation <= N) {

                // Update the corresponding counter by increasing it by 1
                int counterIndex = operation - 1;
                counters[counterIndex] = Math.max(counters[counterIndex], lastMaxCounterIndex);
                counters[counterIndex]++;

                // Update the current maximum value if needed
                currentMax = Math.max(currentMax, counters[counterIndex]);
            }
            // If the operation is a max_counter operation 
            // (i.e., it is equal to N + 1), we update the 
            // 'lastMaxCounter' to store the current maximum value.
            // This value will be used later to update any counters 
            // that have not been updated during subsequent operations. 
            else if (operation == N + 1) {
                // Record the index of the last max_counter operation
                lastMaxCounterIndex = currentMax;
            }
        }
        // After the first loop, we ensure that all counters 
        // are updated to at least the value of 'lastMaxCounter'. 
        // This is necessary because some counters might not 
        // have been updated after the last 'max_counter' operation.
        for (int i = 0; i < N; i++) {
            counters[i] = Math.max(counters[i], lastMaxCounterIndex);
            }
            return counters;
        }
    
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);

            System.out.println("Enter the value of N: ");
            int N = s.nextInt();

            System.out.println("Enter no. of operations (M): ");
            int M = s.nextInt();

            int[] A = new int[M];
            System.out.println("Enter the operations (space-separated integers): ");
            for (int i = 0; i < M; i++) {
                A[i] = s.nextInt();
            }

            int[] result = solution(N, A);
            System.out.println("Result array: " + Arrays.toString(result));

            s.close();
        }
}
