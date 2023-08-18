import java.util.Scanner;


class Solution {
    public static int solution(int[] A) {
        int N = A.length;
        int[] maxEndingHere = new int[N];
        int[] maxStartingHere = new int[N];

        for (int i = 1; i < N - 1; i++) {
            maxEndingHere[i] = Math.max(maxEndingHere[i - 1] + A[i], 0);
        }
        
        for (int i = N -2; i > 0; i--) {
            maxStartingHere[i] = Math.max(maxStartingHere[i + 1] + A[i], 0);
        }

        int maxDoubleSlice = 0;

        for (int i = 1; i < N - 1; i++) {
            maxDoubleSlice = Math.max(maxDoubleSlice, maxEndingHere[i - 1] + maxStartingHere[i + 1]);
        }
        return maxDoubleSlice;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int N = s.nextInt();
        
        int[] A = new int[N];
        System.out.println("Enter values of each element: ");
        for (int i = 0; i < A.length; i++) {
            A[i] = s.nextInt();
        }

        int results = solution(A);
        System.out.println(results);
    }
}