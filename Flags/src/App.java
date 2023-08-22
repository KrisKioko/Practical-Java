import java.util.Scanner;


class Solution {
    public static int solution(int[] A) {
        transform(A);   // This line calls the 'transform' method with the input array 'A'.

        int lowerFlag = 0;   // 'lowerFlag' will keep track of the lower bound of the number of flags that can be placed
        int upperFlag = (int) Math.sqrt(A.length) + 2;   // 'upperFlag' will keep track of the upper bound. The 'upperFlag' value is calculated based on the square root of the length of array 'A', with a small offset of 2.

        // The 'assert' keyword is used to perform a debugging check. It ensures that the condition inside the assertion is 'true'. If it's 'false', an 'AssertionError' will be thrown.
        // In this case, it's checking whether flags can be placed with the upper bound value. If this assertion fails, it means that the initial assumption about the upper bound was incorrect.
        assert !canFitFlags(A, upperFlag);

        // This line starts a 'while' loop that will continue as long as the condition 'lower < upper - 1' is true. 
        // This loop will be used to iteratively narrow down the range of possible flag positions.
        while (lowerFlag < upperFlag - 1) {
            
            // In each iteration of the loop, the midpoint between 'lowerFlag' and 'upperFlag' is calculated and stored in the 'next' variable. 
            // This will help in narrowing down the range of possible flag positions.
            int next = (lowerFlag + upperFlag) / 2;


            // This 'if-else' block checks whether it's possible to place flags at positions determined by 'next'. If it is possible, the 'lowerFlag' bound is updated to next. If
            // not, the 'upperFlag' bound is updated to 'next'.
            if (canFitFlags(A, next)) {
                lowerFlag = next;
            } else {
                upperFlag = next;
            }
        }
        return lowerFlag;   // The 'lowerFlag' value is returned. This value represents the maximum number of flags that can be placed while meeting certain conditions.
    }

    // The 'transform' method modifies the input array to help optimize the flag placement,
    private static void transform(int[] A) {
        int peakPos = A.length;
        int lastHeight = A[A.length - 1];

        for (int p = A.length - 1; p > 0; p--) {
            if (A[p - 1] < A[p] && A[p] > lastHeight) {
                peakPos = p;
            }
            lastHeight = A[p];
            A[p] = peakPos;
        }
        A[0] = peakPos;
    }

    // The 'canFitFlags' method checks whether it's possible to place a given number of flags with a specific pattern in the array.
    private static boolean canFitFlags(int[] A, int k) {
        int flag = 1 - k;

        for (int i = 0; i < k; i++) {
            if (flag + k > A.length - 1) {
                return false;
            }
            flag = A[flag + k];
        }
        return flag < A.length;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int N = s.nextInt();

        System.out.println("Enter the integer values of each element: ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }
        s.close();

        int results = solution(A);
        System.out.println(results);
    }
}