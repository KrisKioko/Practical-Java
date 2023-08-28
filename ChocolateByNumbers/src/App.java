 /* 
  *Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.

    You start to eat the chocolates. After eating a chocolate you leave only a wrapper.

    You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.

    More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).

    You stop eating when you encounter an empty wrapper.

    For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.

    The goal is to count the number of chocolates that you will eat, following the above rules.

    Write a function:

    class Solution { public int solution(int N, int M); }

    that, given two positive integers N and M, returns the number of chocolates that you will eat.

    For example, given integers N = 10 and M = 4. the function should return 5, as explained above.

    Write an efficient algorithm for the following assumptions:

    N and M are integers within the range [1..1,000,000,000]. 
 */




import java.util.Scanner;


class Solution {
    public int solution(int N, int M) {
        long gcd = calculateGCD(N, M);     // Calculate the greatest common divisor
        long totalSteps = (long) N * M / gcd;    // Calculate the total number of steps needed to eat all chocolates
        int chocolatesEaten = (int) (totalSteps / M);    // Calculate the number of chocolates eaten before encountering an empty wrapper

        return chocolatesEaten;
    }

    private long calculateGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);    // Recursive call with a = b and b = a % b
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of chocolates available: ");
        int N = s.nextInt();

        System.out.println("Enter wrappers' position:");
        int M = s.nextInt();
        s.close();

        Solution solution = new Solution();
        System.out.println("The number of chocolates eaten are " + solution.solution(N, M));
    }
}


/* 
 * To solve this problem efficiently, we can use the concept of finding the greatest common divisor (GCD) between N and M. The relationship between the GCD and the number 
 * of chocolates you will eat can be derived using some mathematical properties. The idea is to calculate the total number of steps needed to eat all the chocolates and 
 * then divide it by the GCD of N and M. This will give us the number of chocolates eaten before encountering an empty wrapper.


*/