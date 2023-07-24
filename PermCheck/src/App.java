import java.util.Scanner;

class Solution {
    public static int solution(int[] A) {

        //  This line gets the length of the input array A,
        //  which represents the number of elements in the array.
        int N = A.length;

        // This creates a boolean array seen of length N + 1.
        // This array is used to keep track of whether each 
        // element from 1 to N is seen in the array A. We add 1 
        // to the length because the array A is 0-indexed, so 
        // the indices will range from 0 to N-1. We need an
        // additional slot for the element N.
        boolean[] seen = new boolean[N + 1];

        // Step 1: Iterate through the array to mark the elements as seen.
        for (int i = 0; i < N; i++) {

            // Inside the loop, this 'if' condition checks three things:
            // (1) If the current element 'A[i]' is less than 1 or greater than N,
            // it means the element is out of range [1, N]. In this case,
            // the array is not a permutation, so we return 0. If 'seen[A[i]]' is
            // already true, it means the element 'A[i]' has been seen before 
            // in the array. A permutation should have each element from 1 to N
            // exactly once. If this condition is true, the array is not a permutation,
            // so we return 0.
            if (A[i] < 1 || A[i] > N || seen[A[i]]) {
                // If the element is out of range [1, N] or already seen, return 0.
                return 0;
            }

            // After the above check, if the current element is valid, we mark
            // 'seen[A[i]]' as true to indicate that we have seen this element in the array.
            seen[A[i]] = true;
        }
        // Step 2: Check if all elements from 1 to N are seen.
        for (int i = 1; i <= N; i++) {

            // Inside the loop, this 'if' condition checks if the element 'i' is not seen. If 
            // any element from 1 to N is not seen, it means the array is not a permutation,
            // so we return 0.
            if (!seen[i]) {
                // If any element is missing, return 0.
                return 0;
            }
        }
        // If all elements from 1 to N are seen, return 1 (permutation).
        return 1;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no. of elements in the array: ");
        int N = s.nextInt();
        System.out.println("Enter the elements: ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }
        s.close();

        int result = solution(A);
        System.out.println(result);
    }
}


/* The algorithm has a time complexity of O(N) since it 
    iterates through the array twice, and a 
    space complexity of O(N) due to the boolean array 
    seen used for bookkeeping. This is an efficient
    solution to determine whether an array is a permutation. */