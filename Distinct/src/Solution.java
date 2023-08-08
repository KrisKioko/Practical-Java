import java.util.HashSet;
import java.util.Scanner;


public class Solution {
    public static int solution(int[] A) {
        // Here, a 'HashSet' named 'distinctValues' is created. 
        // A 'HashSet' is a collection that does not allow 
        // duplicate elements and provides constant-time complexity 
        // for basic operations like adding, removing, and searching elements.
        HashSet<Integer> distinctValues = new HashSet<>();

        // This line initiates a loop that iterates through each element 'num' in the array 'A'.
        for (int num : A) {
            // Within this loop, each 'num' is added to the 'distinctValues' 'HashSet'. 
            // This ensures that only distinct values are added to the set.
            distinctValues.add(num);
        }
        // The 'size()' method of the HashSet is used to return the 
        // count of distinct values present in the array 'A'.
        return distinctValues.size();
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