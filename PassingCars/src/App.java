import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of consecutive cars on the road: ");
        int n = s.nextInt();

        System.out.println("Enter the car numbers: ");
        int[] A = new int[n];

        for ( int i = 0; i < n; i++) {
            A[i] = s.nextInt();
        }
        s.close();

        App solution = new App();
        int result = solution.solution(A);
        System.out.println(result);
    }

    public int solution(int[] A) {
        int n = A.length;   // Get the length of the input array 'A'
        int countZeros = 0;   // Initialize a variable to count the number of 0s in the array
        int countPairs = 0;   // Initialize a variable to count the number of pairs of passing cars

        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                countZeros++;   // Count the number of 0s encountered in the array
            } else {
                countPairs += countZeros;   // Each 1 encountered contributes to the count of passing cars
                if (countPairs > 1000000000) {
                    return -1;    // Return -1 if the count of passing cars exceeds 1,000,000,000
                }
            }
        }
        return countPairs;   // Return the final count of passing car pairs
    }
}