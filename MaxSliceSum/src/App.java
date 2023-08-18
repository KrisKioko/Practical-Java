import java.util.Scanner;



class Solution {
    public static int solution(int[] A) {
        int maxEndingHere = A[0];    // Initializes the variable 'maxEndingHere' with the value of the first element in the array. This variable will keep track of the maximum sum ending at the current position.
        int maxSoFar = A[0];     //  Initializes the variable 'maxSoFar' with the value of the first element in the array. This variable will store the maximum sum found so far.

        // Starts a loop that iterates through the array starting from the second element (index 1) up to the last element.
        for (int i = 1; i < A.length; i++) {

            // Updates 'maxEndingHere' by taking the maximum value between the current element 'A[i]' and the sum of the current element and the previous maximum ending value 'maxEndingHere + A[i]'. This step decides whether to extend the current slice or start a new slice.
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);

            // Updates 'maxSoFar' by taking the maximum value between the previous 'maxSoFar' value and the new 'maxEndingHere' value. This ensures that 'maxSoFar' always holds the maximum sum found so far.
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of element in the array: ");
        int N = s.nextInt();
        
        int[] A = new int[N];
        System.out.println("Enter the values of each element: ");
        for (int i = 0; i < A.length; i++) {
            A[i] = s.nextInt();
        }

        s.close();

        int results = solution(A);
        System.out.println(results);
    }
}