import java.util.Stack;
import java.util.Scanner;


public class Solution {
    public static int solution(int[] A, int[] B) {
        Stack<Integer> downstreamFish = new Stack<>();  // Initialize a stack to keep track of downstream fish.
        int numSurvivingFish = 0;  // Initialize a variable to keep track of the number of surviving fish.

        // Start iterating through the fish in the river using a loop.
        for (int i =  0; i < A.length; i++) {

            // Check if the current fish is flowing upstream or downstream using 'B[i]'.
            if (B[i] == 0) {

                // For upstream fish, handle the cases where they encounter downstream fish using a 'while' loop.
                while (!downstreamFish.isEmpty()) {
                    if (A[i] > downstreamFish.peek()) {
                        downstreamFish.pop();
                    } else {
                        break;
                    }
                }
                // If the downstream fish stack is empty, it means the current upstream fish survives, so increment the 'numSurvivingFish'.
                if (downstreamFish.isEmpty()) {
                    numSurvivingFish++;
                }
            } else {
                // For downstream fish, simply push them onto the stack.
                downstreamFish.push(A[i]);
            }
        }

        // After iterating through all the fish, add the count of surviving downstream fish to the 'numSurvivingFish'.
        numSurvivingFish += downstreamFish.size();

        return numSurvivingFish;  // Return the final count of surviving fish.
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of fish: ");
        int n = s.nextInt(); // Reads an integer 'n' from input, representing the number of elements in the array.

        int[] A = new int[n];  // Creates an array 'A' of size 'n' to store the input elements.
        int[] B = new int[n]; // Creates an array 'B' of size 'n' to store the input elements.

        System.out.print("Enter the sizes of the fish: ");
        // A loop to read 'n' integers from input and store them in the array 'A'.
        for (int i = 0; i < n; i++) {
            A[i] = s.nextInt();
        }

        System.out.print("Enter the directions of the fish: ");
        for (int i = 0; i < n; i++) {
            B[i] = s.nextInt();
        }
        s.close();

        // Calls the 'solution' method with the array 'A' and stores the result in 'distinctCount'.
        int result = solution(A, B);  
        System.out.print("The number of surviving fish is " + result);
    }
    
}
