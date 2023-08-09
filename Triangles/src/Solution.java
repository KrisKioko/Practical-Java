import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    public static int solution(int[] A) {
        int n = A.length;

        // Check if the length of the array is less than 3. 
        // If it is, you return 0 since a triangular triplet 
        // requires at least 3 elements.
        if (n < 3) {
            return 0;
        }

        // You're sorting the array 'A' in non-decreasing order 
        // using the 'Arrays.sort' method.
        Arrays.sort(A);

        // This loop iterates through the array from the beginning up 
        // to the third-to-last element. You're initializing three long variables 
        // 'p', 'q', and 'r' with the values of array elements 'A[i]', 'A[i + 1]', 
        // and 'A[i + 2]', respectively.
        for (int i = 0; i < n - 2; i++) {
            long p = A[i];
            long q = A[i + 1];
            long r = A[i + 2];

            // Inside the loop, you're checking if the current combination 
            // of elements satisfies the triangular conditions. If it does, 
            // you return 1 to indicate that a triangular triplet has been found.
            if (p + q > r && q + r > p && r + p > q) {
                return 1;
            }
        }
        // If the loop completes without finding a valid triangular triplet, you 
        // return 0 to indicate that no such triplet exists.
        return 0;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // Reads an integer 'n' from input, representing the number of elements in the array.
        int[] A = new int[n];  // Creates an array 'A' of size 'n' to store the input elements.

        // A loop to read 'n' integers from input and store them in the array 'A'.
        for (int i = 0; i < n; i++) {
            A[i] = s.nextInt();
        }
        s.close();

        // Calls the 'solution' method with the array 'A' and stores the result in 'distinctCount'.
        int distinctCount = solution(A);  
        System.out.println(distinctCount);
    }
    
}
