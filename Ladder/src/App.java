/* 
    You have to climb up a ladder. The ladder has exactly N rungs, numbered from 1 to N. With each step, you can ascend by one or two rungs. More precisely:

    with your first step you can stand on rung 1 or 2,
    if you are on rung K, you can move to rungs K + 1 or K + 2,
    finally you have to stand on rung N.
    Your task is to count the number of different ways of climbing to the top of the ladder.

    For example, given N = 4, you have five different ways of climbing, ascending by:

    1, 1, 1 and 1 rung,
    1, 1 and 2 rungs,
    1, 2 and 1 rung,
    2, 1 and 1 rungs, and
    2 and 2 rungs.
    Given N = 5, you have eight different ways of climbing, ascending by:

    1, 1, 1, 1 and 1 rung,
    1, 1, 1 and 2 rungs,
    1, 1, 2 and 1 rung,
    1, 2, 1 and 1 rung,
    1, 2 and 2 rungs,
    2, 1, 1 and 1 rungs,
    2, 1 and 2 rungs, and
    2, 2 and 1 rung.
    The number of different ways can be very large, so it is sufficient to return the result modulo 2P, for a given integer P.

    Write a function:

    class Solution { public int[] solution(int[] A, int[] B); }

    that, given two non-empty arrays A and B of L integers, returns an array consisting of L integers specifying the consecutive answers; position I should contain the number of different ways of climbing the ladder with A[I] rungs modulo 2B[I].

    For example, given L = 5 and:

        A[0] = 4   B[0] = 3
        A[1] = 4   B[1] = 2
        A[2] = 5   B[2] = 4
        A[3] = 5   B[3] = 3
        A[4] = 1   B[4] = 1
    the function should return the sequence [5, 1, 8, 0, 1], as explained above.

    Write an efficient algorithm for the following assumptions:

    L is an integer within the range [1..50,000];
    each element of array A is an integer within the range [1..L];
    each element of array B is an integer within the range [1..30].
 */



import java.util.Arrays;
import java.util.Scanner;


class Solution {
    public static int[] solution(int[] A, int[] B) {
        int limit = Arrays.stream(A).max().getAsInt();    // Calculates the maximum value in array 'A', representing the possible largest number of rungs on a ladder.
        int[] result = new int[A.length];    // Creates an integer array named 'result' with the same length as array 'A'. This array will store the results for each query
        int modLimit = (1 << Arrays.stream(B).max().getAsInt()) - 1;   // Calculate a 'modLimit' using bitwise left shift ('<<') and bitwise AND ('&'). This limit is used to avoid having large integers in the Fibonacci numbers.

        int[] fib = new int[limit + 2];   // Create an integer array named 'fib' to store Fibonacci numbers.
        fib[1] = 1;   // Initialize the first two elements: 'fib[0]' is not used, and 'fib[1]' is set to '1', as the base case for Fibonacci.
        for (int i = 2; i < limit + 2; i++) {   // Use a loop to calculate Fibonacci numbers for each position from '2' to 'limit + 1'.
            fib[i] = (fib[i - 1] + fib[i - 2]) & modLimit;   // Calculate each Fibonacci number using the sum of the two previous Fibonacci numbers, and apply bitwise AND with 'modLimit' to avoid integer overflow.
        }

        // Loop through each query in arrays A and B. Calculate the number of different ways to climb a ladder with 'A[i]' rungs using Fibonacci number at position 'A[i] + 1'. Apply bitwise AND with '((1 << B[i]) - 1)' to get the 
        // result within the range specified by 'B[i]'.
        for (int i = 0; i < A.length; i++) {
            // To climb to A[i] rungs, you could either
            // come from A[i]-1 with a one-step jump
            // OR come from A[i]-2 with a two-step jump
            // So from A[i] rungs, the number of different ways of climbing
            // to the top of the ladder is the Fibonacci number at position
            // A[i] + 1
            result[i] = fib[A[i] + 1] & ((1 << B[i]) - 1);
        }
        return result;  // Contains the solutions for each query.
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int L = s.nextInt();
        int[] A = new int[L];
        int[] B = new int[L];

        for (int i = 0; i < L; i++) {
            A[i] = s.nextInt();
            B[i] = s.nextInt();
        }
        s.close();

        int[] result = solution(A, B);

        for (int res : result) {
            System.out.println(res);
        }
    }
}



/* 
 * In summary, this Java code calculates the number of different ways to climb a ladder with varying numbers of rungs and step sizes. It uses Fibonacci 
 * numbers to determine the possible climbing combinations and bitwise operations to manage large numbers and limit the results to specified ranges.
 */