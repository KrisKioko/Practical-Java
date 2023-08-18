import java.util.Scanner;
import java.util.Stack;



public class Solution {
    public static int solution(int[] A) {
        int N = A.length;   // Get the length of the array 'A' and store it in the variable 'N'.

        // Create an empty stack of integers using the 'Stack' class to help find the candidate leader.
        Stack<Integer> stack = new Stack<>();
        
        for (int num : A) {   // Start a loop to iterate through each element 'num' in the array 'A'.
            
            // If the stack is empty, push the current number 'num' onto the stack.
            if (stack.isEmpty()) {
                stack.push(num);
            } else {  // If the stack is not empty, check if the top element of the stack is different from the current number 'num'. If they are different, pop the top element from the stack.
                if (stack.peek() != num) {
                    stack.pop();
                } else {   // Otherwise, push the current number 'num' onto the stack.
                    stack.push(num);
                }
            }
        }

        if (stack.isEmpty()) {  // If the stack is empty, there is no candidate leader, so return 0.
            return 0;
        }

        int candidateLeader = stack.pop();  // Pop the remaining element from the stack to get the candidate leader.
        int candidateCount = 0;  //  Initialize a variable 'candidateCount' to store the count of the candidate leader in the array.

        // Another loop to count the occurrences of the candidate leader by iterating through each element 'num' in the array 'A', and 
        // if it is equal to the candidate leader, increment 'candidateCount'.
        for (int num : A) {
            if (num == candidateLeader) {
                candidateCount++;
            }
        }

        // Check if the candidate leader appears more than N/2 times and if the candidate leader's count is less than or equal to half of 
        // the array length 'N', return 0 (no equi leaders).
        if (candidateCount <= N / 2) {
            return 0;
        }

        // Initialize variables to count equi leaders and left leader occurrences.
        int equiLeaderCount = 0;
        int leftLeaderCount = 0;

        // Loop through the array elements to find equi leaders by incrementing 'leftLeaderCount' 
        // if the current element is equal to the candidate leader.
        for (int i = 0; i < N; i++) {
            if (A[i] == candidateLeader) {
                leftLeaderCount++;
            }

            // Calculate 'rightLeaderCount' as the difference between 'candidateCount' and 'leftLeaderCount'.
            int rightLeaderCount = candidateCount - leftLeaderCount;
            
            // Check if both the left and right sequences have a leader that appears more than half the time 
            // in each sequence. If so, increment 'equiLeaderCount'.
            if (leftLeaderCount > (i + 1) / 2 && rightLeaderCount > (N - i - 1) / 2) {
                equiLeaderCount++;
            }
        }

        return equiLeaderCount;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }

        int result = solution(A);
        System.out.println(result);
    }
}
