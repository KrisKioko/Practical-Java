import java.util.Arrays;
import java.util.Scanner;


class Solution {
    public static int[] solution(int N, int[] P, int[] Q) {

        boolean[] primeTable = new boolean[N + 1];   // It creates a boolean array 'primeTable' of size 'N + 1' to track whether a number is prime.

        // Assigns the specified boolean value to each element of the specified range of the specified array of booleans. The range to be filled extends from index fromIndex, inclusive, to index toIndex, exclusive.
        Arrays.fill(primeTable, 2, N + 1, true);
        int[] prime = new int[N + 1];   // The array 'prime' is created to store the list of prime numbers.
        int primeCount = 0;   // 'primeCount' is used to keep track of the number of prime numbers found.

        // This loop iterates through numbers from 2 up to the square root of 'N'. It checks if element 'i' is marked as prime in the 'primeTable'.
        for (int i = 2; i <= Math.sqrt(N); i++) {

            // If element 'i' is prime, it's added to the 'prime' array and 'primeCount' is incremented.
            if (primeTable[i]) { 
                prime[primeCount++] = i;
                int multiple = i * i;

                // Then, it marks the multiples of element 'i' as not prime by setting 'primeTable[multiple]' to 'false', starting from 'multiple = i * i' and incrementing 'multiple' by 'i' in each iteration.
                while (multiple <= N) {
                    primeTable[multiple] = false;
                    multiple += i;
                }
            }
        }

        // This loop continues where the previous loop left off. It iterates from the value immediately after the square root of 'N' up to 'N'.
        for (int i = (int) Math.sqrt(N) + 1; i <= N; i++) {

            // If element 'i' is marked as prime in 'primeTable', it's added to the prime array and 'primeCount' is incremented.
            if (primeTable[i]) {
                prime[primeCount++] = i;
            }
        }

        int[] semiPrime = new int[N + 1];   // An array 'semi-prime' of size 'N + 1' is created to track semi-prime numbers. All values are initially set to '0'.

        // This nested loop generates semi-prime numbers. It uses pairs of prime numbers from the 'prime' array to calculate the products. It checks if the product of 
        // the prime numbers is within the range '[2, N]'. If it's larger than 'N', there's no need to record it, so the loop breaks. If the product is within range, 
        // the corresponding index in the 'semi-prime' array is set to '1'.
        for (int i = 0; i < primeCount - 1; i++) {
            for (int j = i; j < primeCount; j++) {
                if ((long) prime[i] * prime[j] > N) {
                    break;
                }
                semiPrime[prime[i] * prime[j]] = 1;
            }
        }

        // This loop computes the prefix sum of the 'semi-prime' array. Each element now represents the count of semi-prime numbers up to element 'i'.
        for (int i = 1; i <= N; i++) {
            semiPrime[i] += semiPrime[i - 1];
        }

        int questionLen = P.length;   // 'questionLen' is the length of the arrays 'P' and 'Q', representing the number of range queries.
        int[] result = new int[questionLen];   // An array 'result' is created to store the results of each query.

        // The final loop calculates the number of semi-prime numbers within the range '[P[K], Q[K]]' for each query. The result for each 
        // query is stored in the 'result' array.
        for (int i = 0; i < questionLen; i++) {
            result[i] = semiPrime[Q[i]] - semiPrime[P[i] - 1];
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] P = new int[N];
        int[] Q = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = s.nextInt();
        }

        for (int i = 0; i < N; i++) {
            Q[i] = s.nextInt();
        }

        int[] result = solution(N, P, Q);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        s.close();
    }
}