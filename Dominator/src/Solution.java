import java.util.Scanner;



public class Solution {
    public static int solution(int[] A) {
        int size = 0;    // Initializes a variable 'size' to keep track of the number of occurrences of the current candidate.
        int value = -1;   // Initializes a variable 'value' to store the current candidate for the dominator.

        // The first loop is used to find a candidate for the dominator. It iterates through the array and maintains the 'size' and 'value'
        // variables. If 'size' becomes zero, a new candidate is chosen.
        for (int i = 0; i < A.length; i++) {
            if (size == 0) {
                size++;
                value = A[i];
            } else {
                if (value != A[i]) {
                    size--;
                } else {
                    size++;
                }
            }
        }

        int count = 0;
        int candidateIndex = -1;
        // The second loop counts the occurrences of the candidate found in the first loop and also keeps track of the index of the last occurrence.
        for (int i = 0; i < A.length; i++) {
            if (A[i] == value) {
                count++;
                candidateIndex = i;
            }
        }

        // This line checks if the candidate is indeed a dominator by comparing its count with half the length of the array. If it is a dominator, 
        // the index of the candidate's last occurrence is returned; otherwise, -1 is returned.
        if (count > A.length / 2) {
            return candidateIndex;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }

        int result = solution(A);
        System.out.println(result);
    }
}
