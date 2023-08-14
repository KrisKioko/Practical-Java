import java.util.Stack;
import java.util.Scanner;



public class Solution {
    public static int solution(int[] H) {
        int N = H.length;   //  Get the length of the input array 'H'.

        Stack<Integer> stack = new Stack<>();   // Initialize a stack called 'stack' to keep track of the heights.
        int blocks = 0;   // Initialize a variable 'blocks' to keep track of the count of blocks.

        // Start a loop to iterate through each height in the array.
        for (int i = 0; i < N; i++) {
            // Inside the loop, check if the current height is less than the top height in the stack. 
            // If yes, pop heights from the stack until the condition is false. This ensures that the 
            // heights in the stack are in non-decreasing order.
            while (!stack.isEmpty() && H[i] < stack.peek()) {
                stack.pop();
            }

            // If the stack is empty or the current height is greater than the top of the stack,
            // add the current height to the stack and increment the block count
            if (stack.isEmpty() || H[i] > stack.peek()) {
                stack.push(H[i]);
                blocks++;
            }
        }
        return blocks;  // Return the minimum number of blocks needed.
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();   // Read the length(no. of elements) of the input array

        int[] H = new int[N];    // Initialize the array to store heights
        
        for (int i = 0; i < N; i++) {
            H[i] = s.nextInt();    // Read each height and store it in the array
        }

        int result = solution(H);   // Call the solution method to calculate the minimum number of blocks
        System.out.println(result);   // Print the result
    }    
}
