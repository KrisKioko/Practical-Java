import java.util.Scanner;

public class Solution {
    // This is the mainfunction of our solution as it
    // takes three parameters; (i) 's' is the DNA sequence as
    // string, (ii) ''
    public static int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;

        // Preprocess and build prefix sum arrays
        int[][] prefixSums = new int[4][N + 1];
        for (int i = 0; i < N; i++) {
            int a = 0, c = 0, g = 0, t = 0;
            char nucleotide = S.charAt(i);
            if (nucleotide == 'A') {
                a = 1;
            } else if (nucleotide == 'C') {
                c = 1;
            } else if (nucleotide == 'G') {
                g = 1;
            } else if (nucleotide == 'T') {
                t = 1;
            }
            // Building the prefix sum arrays for each nucleotide type
            prefixSums[0][i + 1] = prefixSums[0][i] + a;  // Prefix sum for A
            prefixSums[1][i + 1] = prefixSums[1][i] + c;  // Prefix sum for C
            prefixSums[2][i + 1] = prefixSums[2][i] + g;  // Prefix sum for G
            prefixSums[3][i + 1] = prefixSums[3][i] + t;  // Prefix sum for T
        }
        // Process queries
        int[] result = new int[M];
        for (int i = 0; i < M; i++){
            int start = P[i];
            int end = Q[i] + 1;  // Adding 1 to make the range inclusive

            // Calculate the difference between prefix sums for each
            // nucleotide type while finding the minimum impact factor 
            // in the query range
            if (prefixSums[0][end] - prefixSums[0][start] > 0) {
                result[i] = 1;
            } else if (prefixSums[1][end] - prefixSums[1][start] > 0) {
                result[i] = 2;
            } else if (prefixSums[2][end] - prefixSums[2][start] > 0) {
                result[i] = 3;
            } else if (prefixSums[3][end] - prefixSums[3][start] > 0) {
                result[i] = 4;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the DNA sequence (i.e. should comprise of 'A', 'C', 'G' & 'T'): ");
        String S = s.nextLine();

        System.out.print("Enter number of queries (M): ");
        int M = s.nextInt();
        int[] P = new int[M];
        int[] Q = new int[M];

        System.out.println("Enter the queries (P & Q) on separate lines:");
        for (int i = 0; i < M; i++) {
            P[i] = s.nextInt();
            Q[i] = s.nextInt();
        }
        s.close();

        int[] result = solution(S, P, Q);
        System.out.println("The minimal impact factor of nucleotides contained in the DNA sequence is: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}