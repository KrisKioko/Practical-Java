import java.util.Scanner;

public class Solution {
    // This is the mainfunction of our solution as it
    // takes three parameters; (i) 'S' is the DNA sequence as
    // string, (ii) 'P' is the array containing the starting positions 
    // of the queries, (iii) 'Q' is the array containting the ending 
    // positions of the queries.
    public static int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();   // Stores the length of the DNA sequence
        int M = P.length;   // Stores the number of queries

        // We declare a 2D array called 'prefixSums'. This 
        // array will store the prefix sums for each nucleotide
        // type (A, C, G, T). The first dimension of 
        // the array represents the nucleotide types (0 for A, 
        // 1 for C, 2 for G, and 3 for T), and the second dimension 
        // represents the positions in the DNA sequence.
        int[][] prefixSums = new int[4][N + 1];

        // In this loop, we calculate the prefix sums for each nucleotide 
        // type. We traverse the DNA sequence character by character and 
        // convert each nucleotide into a numerical value ('a', 'c', 'g', 't').
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
            
            // Here, we update the prefix sums by adding the value of 
            // the corresponding nucleotide type to the previous prefix 
            // sum value. This way, 'prefixSums[0][i + 1]' will store 
            // the sum of all occurrences of nucleotide A up to the 
            // position 'i', and so on.
            prefixSums[0][i + 1] = prefixSums[0][i] + a;  // Prefix sum for A
            prefixSums[1][i + 1] = prefixSums[1][i] + c;  // Prefix sum for C
            prefixSums[2][i + 1] = prefixSums[2][i] + g;  // Prefix sum for G
            prefixSums[3][i + 1] = prefixSums[3][i] + t;  // Prefix sum for T
        }


        // Process queries
        int[] result = new int[M];  // We create an array called 'result' to store the output of the queries.

        // In this loop, we process each query.
        for (int i = 0; i < M; i++){
            int start = P[i];
            int end = Q[i] + 1;  // Adding 1 to make the range inclusive

           // For each query 'P[i]' to 'Q[i]' (inclusive), we find the 
           // difference between the prefix sums of each nucleotide type 
           // at the  respective positions. Then, we determine the 
           // minimum impact factor in the query range by checking which
           // nucleotide type has a non-zero count. We update the 'result' 
           // array with the minimum impact factor for each query.
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

        // we return the 'result' array, which contains the minimum
        // impact factors for all the queries.
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