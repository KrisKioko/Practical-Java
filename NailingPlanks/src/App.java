/* 
You are given two non-empty arrays A and B consisting of N integers. These arrays represent N planks. More precisely, A[K] is the start and B[K] the end of the K−th plank.

Next, you are given a non-empty array C consisting of M integers. This array represents M nails. More precisely, C[I] is the position where you can hammer in the I−th nail.

We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].

The goal is to find the minimum number of nails that must be used until all the planks are nailed. In other words, you should find a value J such that all planks will be nailed after using only the first J nails. More precisely, for every plank (A[K], B[K]) such that 0 ≤ K < N, there should exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].

For example, given arrays A, B such that:

    A[0] = 1    B[0] = 4
    A[1] = 4    B[1] = 5
    A[2] = 5    B[2] = 9
    A[3] = 8    B[3] = 10
four planks are represented: [1, 4], [4, 5], [5, 9] and [8, 10].

Given array C such that:

    C[0] = 4
    C[1] = 6
    C[2] = 7
    C[3] = 10
    C[4] = 2
if we use the following nails:

0, then planks [1, 4] and [4, 5] will both be nailed.
0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
0, 1, 2, 3, then all the planks will be nailed.
Thus, four is the minimum number of nails that, used sequentially, allow all the planks to be nailed.

Write a function:

class Solution { public int solution(int[] A, int[] B, int[] C); }

that, given two non-empty arrays A and B consisting of N integers and a non-empty array C consisting of M integers, returns the minimum number of nails that, used sequentially, allow all the planks to be nailed.

If it is not possible to nail all the planks, the function should return −1.

For example, given arrays A, B, C such that:

    A[0] = 1    B[0] = 4
    A[1] = 4    B[1] = 5
    A[2] = 5    B[2] = 9
    A[3] = 8    B[3] = 10

    C[0] = 4
    C[1] = 6
    C[2] = 7
    C[3] = 10
    C[4] = 2
the function should return 4, as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..30,000];
each element of arrays A, B and C is an integer within the range [1..2*M];
A[K] ≤ B[K].
 */




import java.util.Arrays;
import java.util.Scanner;



class Solution {
    // This is the main method that calculates the minimum number of nails needed. It takes three arrays as 
    // parameters: 'A' (plank start positions), 'B' (plank end positions), and 'C' (nail positions).
    public static int solution(int[] A, int[] B, int[] C) {
        int N = A.length;    // To determine the number of planks('N')
        int M = C.length;    // To determine the number of nails('M')

        // You set the initial left and right boundaries for the binary search. The binary search will look for 
        // the minimum number of nails needed between 'left' and 'right'.
        int left = 1;
        int right = 2 * M + 1;
        
        // You initialize the result variable, which will store the minimum number of nails needed. It's initially 
        // set to -1 to indicate that the result is unknown
        int result = -1;

        // This is the start of a binary search loop. It continues as long as the left boundary is less than or equal 
        // to the right boundary.
        while (left <= right) {
            int mid = (left + right) / 2;    // You calculate the middle point for the binary search. This determines the number of nails to consider in this iteration.
            int[] nails = new int[mid];     // You create an array to store the nail positions for the current iteration. It has a length of 'mid', which represents the number of nails considered.
            Arrays.fill(nails, -1);       // You initialize the 'nails' array with -1, indicating that no nails have been placed yet.
            boolean allPlanksNailed = true;       // You set a flag to 'true', assuming initially that all planks can be nailed with the current number of nails.

            // You loop through the first 'mid' nail positions and populate the 'nails' array with nail positions from 'C'.
            for (int i = 0; i < mid && i < M; i++) {
                nails[i] = C[i];
            }

            // You sort the 'nails 'array in ascending order to prepare for efficient searching.
            Arrays.sort(nails);

            // The nested 'for' loop iterates through each plank ('A[i]' and 'B[i]'), and the 'findMinNail' function is called to find the 
            // minimum nail position for each plank.
            for (int i = 0; i < N; i++) {
                int minNail = findMinNail(nails, A[i], B[i]);

                //  This means that not all planks can be nailed with the current number of nails. In this case, 'allPlanksNailed' is set to 
                // 'false', and the loop breaks.
                if (minNail == -1) {
                    allPlanksNailed = false;
                    break;
                }
            }

            // If 'allPlanksNailed' remains 'true' after the loop, it means all planks can be nailed with the current number of nails ('mid' nails), 
            // so you update 'result' and adjust the binary search boundaries accordingly.
            if (allPlanksNailed) {
                result = mid;
                right = mid - 1;
            } else {      // If not all planks can be nailed with the current number of nails, you adjust the boundaries for the next iteration of the binary search.
                left = mid + 1;
            }
        }

        return result;
    }

    // The 'findMinNail' method efficiently finds the minimum nail position for a given plank within the 'nails' array using binary search.
    private static int findMinNail(int[] nails, int start, int end) {
        int left = 0;
        int right = nails.length - 1;
        int minNailIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nails[mid] >= start && nails[mid] <= end) {
                minNailIndex = mid;
                right = mid - 1;
            } else if (nails[mid] < start) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (minNailIndex != -1) {
            return nails[minNailIndex];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of planks (N):");
        int N = s.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
         System.out.println("Enter the starting and ending points of each plank:");
        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
            B[i] = s.nextInt();
        }

        System.out.println("Enter the number of nails (M):");
        int M = s.nextInt();
        int[] C = new int[M];
        System.out.println("Enter the positions of each nail:");
        for (int i = 0; i < M; i++) {
            C[i] = s.nextInt();
        }

        s.close();

        int result = solution(A, B, C);
        System.out.println(result);
    }
}



/* This solution uses a binary search on the number of nails to find the minimum number of nails needed to nail all the planks. In each iteration of the binary search, it checks if it's 
    possible to nail all the planks using the first 'mid' nails. If it's possible, it updates the result and continues searching for a smaller number of nails. If it's not possible, it 
    increases the number of nails to search for. The 'findMinNail' function efficiently finds the minimum nail that can be used for a given plank.
   The time complexity of this solution is O((N + M) * log(M)), where 'N' is the number of planks, and 'M' is the number of nails, making it efficient for the given input constraints.
*/