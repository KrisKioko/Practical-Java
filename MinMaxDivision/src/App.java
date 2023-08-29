/* 
You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not greater than M.

You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.

The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.

The large sum is the maximal sum of any block.

For example, you are given integers K = 3, M = 5 and array A such that:

  A[0] = 2
  A[1] = 1
  A[2] = 5
  A[3] = 1
  A[4] = 2
  A[5] = 2
  A[6] = 2
The array can be divided, for example, into the following blocks:

[2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
[2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
[2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
[2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.

Write a function:

class Solution { public int solution(int K, int M, int[] A); }

that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.

For example, given K = 3, M = 5 and array A such that:

  A[0] = 2
  A[1] = 1
  A[2] = 5
  A[3] = 1
  A[4] = 2
  A[5] = 2
  A[6] = 2
the function should return 6, as explained above.

Write an efficient algorithm for the following assumptions:

N and K are integers within the range [1..100,000];
M is an integer within the range [0..10,000];
each element of array A is an integer within the range [0..M].
 */



import java.util.Scanner;



class Solution {
    public static int solution(int K, int M, int[] A) {
        // Initialize left and right variables to determine the range for binary search
        int left = 0;
        int right = 0;

        // Initialize left and right variables to determine the range for binary search
        for (int num : A) {
            right += num;      // Sum of all elements
            left = Math.max(left, right);      // Largest element
        }

        int result = right;      // Initialize the result to the sum of all elements

        // Perform binary search
        while (left <= right) {
            int mid = (left + right) / 2;        // Calculate the mid point of the current range

            // Check if it's possible to divide the array into 'K' blocks with a maximal sum less than or equal to mid
            if (isPossibleToDivide(A, K, mid)) {
                // Update result and narrow down the search space to the left
                result = mid;
                right = mid - 1;
            } else {
                // Move the search space to the right
                left = mid + 1;
            }
        }
        // Return the final result (minimal large sum)
        return result;
    }

    // Helper function to check if it's possible to divide the array 'A' into 'K' blocks with a maximal sum less than or equal to 'maxSum'
    private static boolean isPossibleToDivide(int[] A, int K, int maxSum) {
        int blockSum = 0;
        int blockCount = 0;

        // Iterate through the array
        for (int num : A) {
            // Check if adding the current element to the 'blockSum' exceeds the 'maxSum'
            if (blockSum + num > maxSum) {
                // Start a new block and reset 'blockSum'
                blockSum = num;
                blockCount++;
            } else {
                 // Add the current element to the current block
                blockSum += num;
            }

            // If the number of blocks exceeds or equals K, return false
            if (blockCount >= K) {
                return false;
            }
        }
        // Return true if it's possible to divide the array into 'K' blocks with the given 'maxSum'
        return true;
    }

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int K = s.nextInt();
        int M = s.nextInt();
        int N = s.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }

        s.close();

        int result = solution(K, M, A);
        System.out.println(result);
    }
}



/* 
 * To solve this problem efficiently, we can use binary search to find the minimum value of the maximal sum. We can use binary search to narrow
 *  down the range of possible solutions for the maximal sum and then check if it's possible to divide the array into K blocks with a maximal 
 * sum less than or equal to the value we're testing.
 */