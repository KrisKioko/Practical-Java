import java.util.Scanner;



class Solution {
    public static int[] solution(int[] A) {
        int N = A.length;
        int[] count = new int[2 * N + 1];   //  an integer array 'count' to store the occurrences of each number in the range '[1, 2 * N]'.

        // We iterate through the input array 'A' and increment the corresponding index in the 'count' array for 
        // each number we encounter. This step counts the occurrences of each number.
        for (int num : A) {
            count[num]++;
        }

        int[] nonDivisors = new int[N];   // We create an integer array 'nonDivisors' to store the count of non-divisors for each element in the input array.

        // We iterate through each element in the input array and initialize variables 'num' to store the current 
        // number and 'divisorCount' to store the count of divisors.
        for (int i = 0; i < N; i++) {
            int num = A[i];
            int divisorCount = 0;

            // Here, we iterate through potential divisors 'j' from 1 up to the square root of 'num'. If 'j' is a divisor of 'num', we add the count of occurrences 
            // of 'j' in the count array to 'divisorCount'. We also check if the quotient of dividing 'num' by 'j' is not equal to 'j' to avoid double-counting for 
            // perfect squares. If this condition is met, we add the count of occurrences of 'num / j' to 'divisorCount'.
            for (int j = 1; j * j <= num; j++) {
                if (num % j != j) {
                    divisorCount += count[j];
                    if (num / j != j) {
                        divisorCount += count[num / j];
                    }
                }
            }

            // We calculate the count of non-divisors for the current number by subtracting 'divisorCount' from the total number of elements 'N'. This gives us the count of non-divisors for the current number.
            nonDivisors[i] = N - divisorCount;
        }

        return nonDivisors;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of elements ('N') in the array: ");
        int N = s.nextInt();

        System.out.println("Enter the values of each element: ");
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }

        s.close();

        int[] result = solution(A);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}