import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int n = s.nextInt();

        int[] A = new int [n];
        System.out.println("Enter "+ n + " integers separated by space: ");
        for (int i = 0; i < n; i++) {
            A[i] = s.nextInt();
        }

        s.close();

        int result = solution(A);
        System.out.println("The smallest positive integer missing in the array: " + result);


    }
    public static int solution(int[] A) {
        // This line creates an integer variable 'n' and
        // assigns the length of the input array 'A' to 
        // it. The variable 'n' represents the number of elements in the array.
        int n = A.length;

        // This line creates a new boolean array called 'present'.
        // The size of this array is 'n + 1'. We add 1 to the size
        // because we want to use the array indices from 1 to 'n' (inclusive)
        // instead of 0 to 'n-1', as the smallest positive integer is 1,
        // not 0. This array will be used to keep track of which 
        // positive integers are present in the input array.
        boolean[] present = new boolean[n + 1];

        // This is the first loop that iterates through each element of the input array 'A'.
        for (int i = 0; i < n; i++) {    // This sets up a loop that starts with 'i' being 0 and runs until 'i'
                                         // becomes equal to 'n - 1' (i.e., it goes through all elements of the array).

            // This condition checks if the current element 'A[i]'
            // is a positive integer greater than 0 and less than or 
            // equal to 'n'. We only care about positive integers within the valid range.
            if (A[i] > 0 && A[i] <= n) {    
                // If the condition in the previous step is true, it means that the value 'A[i]'
                // represents a positive integer within the valid range. The 'present' array is
                // used to keep track of which positive integers are present in the input array.
                // We set 'present[A[i]]' to true to indicate that the integer A[i] is present in the array.
                present[A[i]] = true;
            }
        }

        // This is the second loop that iterates through all the positive integers from 1 to 'n' (inclusive).
        for (int i = 1; i <= n; i++) {    // This sets up a loop that starts with 'i' being 1 and runs until 'i'
                                          // becomes equal to n. It goes through all positive integers from 1 to n.

            // This condition checks if the integer 'i' is not present in the
            // 'present' array, i.e., if 'present[i]' is false.
            if ( i <=n && !present[i]) {
                // If the condition is true, it means that the positive integer 'i' 
                // is not present in the input array 'A'. In that case, we immediately
                // return 'i' as the smallest positive integer that does not occur in 'A'.
                return i;
            }
        }
        // If all positive integers from '1' to 'n' are present in the array 'A',
        // the function will not have returned inside the second loop. In that case,
        // we know that the smallest missing positive integer is n + 1, and we return it as the final result.
        return n + 1;
    }
}



/* The code effectively scans the input array once to mark the presence of positive integers within the valid range in
 the present array. Then, it scans from 1 to n to find the smallest positive integer that is not marked as present.
 If all positive integers from 1 to n are present, it returns n + 1, which would be the smallest missing positive
 integer in that case. */