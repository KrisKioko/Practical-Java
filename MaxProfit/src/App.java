import java.util.Scanner;



class Solution {
    public static int solution(int[] A) {

        // Handles a special case: if the array 'A' is null or has fewer than two elements, there's no way to make a profit, so it immediately returns 0.
        if (A == null || A.length < 2) {
            return 0;
        }

        int minPrice = A[0];   // Initializes the 'minPrice' variable with the value of the first element in the array 'A'.
        int maxPrice = 0;   // Initializes the 'maxProfit' variable to 0, which will hold the maximum profit.

        for (int i = 1; i < A.length; i++) {   // Starts a loop from the second element (index 1) of the array 'A' and iterates through the rest of the array.

            // If the current element in the array 'A' is less than the 'currentMinPrice' variable, it is set to the current element in the array 'A'.
            if (A[i] < minPrice) {
                minPrice = A[i];
            } else {  // If the current stock price is greater than or equal to 'minPrice', calculates the potential profit from buying at 'minPrice' and selling at the current price '(A[i])'. Compares this potential profit with the current 'maxProfit' using 'Math.max' and updates 'maxProfit' if the potential profit is greater.
                int currentProfit = A[i] - minPrice;
                maxPrice = Math.max(maxPrice, currentProfit);
            }
        }
        return maxPrice;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of elements of the array: ");
        int N = s.nextInt();

        System.out.println("Enter the elements data: ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }

        int result = solution(A);
        System.out.println(result);
    }
}