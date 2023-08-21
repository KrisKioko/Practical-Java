import java.util.Scanner;


class Solution {
    public static int solution(int N) {
        int countFactors = 0;   // This initializes a variable 'countFactors' to store the count of factors. It starts at '0'.

        // This initiates a loop that iterates through numbers from '1' to the square root of 'N'. The loop variable 'i' represents a potential factor.
        for (int i = 1; i <= Math.sqrt(N); i++) {
            // This checks if 'i' is a factor of 'N' by testing if the remainder of the division 'N / i' is zero.
            if (N % i == 0) {
                countFactors += 2;   // If 'i' is a factor of 'N', then both 'i' and 'N / i' are factors. So, we increment 'countFactors' by 2.
                // This checks if 'i' and 'N / i' are the same, which would happen when 'i' is the square root of 'N'.
                if (i == N / i) {
                    countFactors--;  //  If 'i' and 'N / i' are the same, we decrement factors by '1' to avoid counting the same factor twice.
                }
            }
        }
        return countFactors;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a positive integer: ");
        int N = s.nextInt();


        int results = solution(N);
        System.out.print("The number of factors of this no. is " + results);
    }
}




/* So, the code efficiently calculates the number of factors for a given positive integer N by iterating through 
possible factors up to the square root of N, considering both the divisor and its corresponding quotient, and 
adjusting the count when necessary. This approach avoids redundant calculations and leads to an efficient solution 
for the problem. */