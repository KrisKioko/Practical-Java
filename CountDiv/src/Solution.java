// To find the number of integers divisible by 'K' within the range
// [A..B], we can use some basic arithmetic. The count of such integers
// can be computed using the following formula: 
// 'Count = (B/K) - (A/K) + 1'. However, there is a special case when 'A'
// is divisible by 'K'. In that case, we need to consider 'A' as
// well in the count; otherwise, it will be missed in the formula below.


import java.util.Scanner;


public class Solution {
    public static int solution(int A, int B, int K) {
        // Here, (B/K) denotes the number of integers divisible by
        // 'K' that are less than or equal to B, and (A/K) denotes
        // the number of integers divisible by 'K' that are less
        // than or equal to A.
        int count = (B / K) - (A / K);

        // Checks if 'A' is divisible by 'K'. If it is, we need to consider it in the count.
        if (A % K == 0) {
            count++;  
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the value of A: ");
        int A = s.nextInt();

        System.out.print("Enter the value of B: ");
        int B = s.nextInt();

        System.out.print("Enter the value of K: ");
        int K = s.nextInt();

        int result = solution(A, B, K);
        System.out.print("The number of integers divisible by K in the range [" + A +".." + B + "] is: " + result);
    }
}