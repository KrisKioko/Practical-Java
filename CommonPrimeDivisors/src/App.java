import java.util.Scanner;


class Solution {
    public static int solution(int[] A, int[] B) {
        int count = 0;

        for (int K = 0; K < A.length; K++) {
            if (hasSamePrimeDivisors(A[K], B[K])) {
                count++;
            }
        }
        return count;
    }

    private static int gcd (int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    private static int removeCommonPrimeDivisors(int a, int b) {
        while (a != 1) {
            int gcdValue = gcd(a, b);
            if (gcdValue == 1) {
                break;
            }
            a /= gcdValue;
        }
        return a;
    }

    private static boolean hasSamePrimeDivisors(int a, int b) {
        int gcdValue = gcd(a, b);
        a = removeCommonPrimeDivisors(a, gcdValue);
        if (a != 1) {
            return false;
        }
        b = removeCommonPrimeDivisors(b, gcdValue);
        return b == 1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int Z = s.nextInt();
        int[] A = new int[Z];
        int[] B = new int[Z];

        for (int i = 0; i < A.length; i++) {
            A[i] = s.nextInt();
            B[i] = s.nextInt();
        }
        s.close();

        int result = solution(A, B);
        System.out.println(result);
    }
}