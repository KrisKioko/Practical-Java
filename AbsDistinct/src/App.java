/* 
A non-empty array A consisting of N numbers is given. The array is sorted in non-decreasing order. The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.

For example, consider array A such that:

  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N numbers, returns absolute distinct count of array A.

For example, given array A such that:

  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
        array A is sorted in non-decreasing order.
 */



import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

class Solutions {
    public static int solution(int[] A) {
        // These lines initialize two pointers, 'left' and 'right'. 'left' starts at the beginning of the array (index 0), 
        // and 'right' starts at the end of the array (index 'A.length - 1').
        int left = 0;
        int right = A.length - 1;

        Set<Integer> distinctAbsValues = new HashSet<>();     // This line creates a 'HashSet' called 'distinctAbsValues' to store the distinct absolute values encountered during the iteration.

        // This initiates a 'while' loop that continues as long as the 'left' pointer is less than or equal to the 'right' 
        // pointer, ensuring that all elements in the array are processed.
        while (left <= right) {

            // These lines calculate the absolute values of the elements at the 'left' and 'right' pointers
            int leftValue = Math.abs(A[left]);
            int rightValue = Math.abs(A[right]);

            // This 'if' block checks if the absolute value at the 'left' pointer is greater than the absolute 
            // value at the 'right' pointer. If it is, it adds the 'leftValue' to the 'distinctAbsValues' set 
            // and increments the 'left' pointer while skipping over any duplicate absolute values.
            if (leftValue > rightValue) {
                distinctAbsValues.add(rightValue);
                while (left < A.length && Math.abs(A[left]) == leftValue) {
                    left++;
                }
            } else {   // In the 'else' block, it means that the absolute value at the 'right' pointer is greater or equal to the absolute value at the 'left' pointer.
                       // In this case, it adds the 'rightValue' to the 'distinctAbsValues' set and decrements the 'right' pointer while skipping over any duplicate absolute values.
                distinctAbsValues.add(rightValue);
                while (right >= 0 && Math.abs(A[right]) == rightValue) {
                    right--;
                }
            }
        }

        return distinctAbsValues.size();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int N = s.nextInt();

        int[] A = new int[N];

        System.out.println("Enter the elements of the sorted array:");

        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }

        s.close();

        int result = solution(A);
        System.out.println("The absolute distinct count of the array is: " + result);
    }
}


/* 
    This function uses two pointers, left and right, which start at the beginning and end of the array, respectively. It calculates the absolute values of the elements at these positions and adds them to a 
    set to keep track of distinct absolute values. The pointers move towards each other while avoiding duplicates in the absolute values.The time complexity of this solution is O(N), where 'N' is the number 
    of elements in the array, and the space complexity is O(N) due to the use of the set to store distinct absolute values.
 */