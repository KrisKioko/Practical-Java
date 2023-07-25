import java.util.Scanner;



public class MountainHike {
    public static int countWaysToSummit(int n) {
        // Step 1: Create an array to store the number of ways for each position up to n.
        int[] dp = new int[n + 1];

        // Step 2: Initialize the base cases.
        dp[0] = 1; // There is one way to reach the starting position (no rocks to hop over).
        dp[1] = 1; // There is one way to hop over the first rock.

        // Step 3: Calculate the number of ways for each position from 2 up to n.
        for (int i = 2; i <= n; i++) {
            // The number of ways to reach the current position is the sum of the ways to reach
            // the previous two positions (i - 1 and i - 2).
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Step 4: Return the number of ways to reach the summit (the last position, dp[n]).
        return dp[n];
    }

    public static void main(String[] args) {
        // Example usage:
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rocks (n): ");
        int n = scanner.nextInt();
        
        scanner.close();

        int waysToSummit = countWaysToSummit(n);
        System.out.println("Number of ways to reach the summit: " + waysToSummit);
    }
}