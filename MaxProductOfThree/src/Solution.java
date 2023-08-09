import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    public static int solution(int[] A) {
        // This line sorts the input array 'A' in ascending order using the 'Arrays.sort' method 
        // from the Java standard library.
        Arrays.sort(A);

        // This line gets the length of the array 'A' 
        // and stores it in the variable 'n'.
        int n = A.length;

        // 'product1' is the product of the three largest positive elements in the sorted array.
        int product1 = A[n - 1] * A[n - 2] * A[n - 3];

        // 'product2' is the product of the two smallest negative elements and the largest 
        // positive element in the sorted array
        int product2 = A[0] * A[1] * A[n - 1];

        // Returns the maximum value between 'product1' and 'product2', 
        // which represents the maximal product of any triplet in the array.
        return Math.max(product1, product2);
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
