import java.util.Scanner;

public class Solution {
    public static int solution(int[] A) {
        // This line declares two integer variables 'sum1' and 'sum2' 
        // and initializes 'sum2' with 0. 'sum1' will be used to calculate 
        // the sum of two consecutive elements, and 'sum2' will be used to 
        // calculate the sum of three consecutive elements.
        int sum1, sum2 = 0;

        // This line declares a double variable 'minAvg' and initializes it 
        // with the maximum possible value of a double. It is initialized to a 
        // high value to ensure that any calculated average will be smaller than 
        // this initial value.
        double minAvg = Double.MAX_VALUE;

        // This line declares a double variable 'currentAvg1' and initializes 
        // it with the maximum possible value of a double. This variable will store 
        // the current average of two consecutive elements being considered.
        double currentAvg1 = Double.MAX_VALUE;

        // This variable will store the current average of three consecutive elements being considered.
        double currentAvg2 = Double.MAX_VALUE;

        // This line declares an integer variable 'minAvgSliceIndex' and initializes it with 0. This 
        // variable will keep track of the index of the slice with the minimum average.
        int minAvgSliceIndex = 0;

        // The loop will be used to check all possible slices of size 2 and 3 in the array.
        for (int i = 0; i < A.length - 2; i++) {
            // This line calculates the sum of two consecutive elements in the array 'A' and 
            // stores it in the variable 'sum1'.
            sum1 = A[i] + A[i + 1];

            // This line calculates the average of the two consecutive elements by dividing 
            // 'sum1' by 2.0 and stores it in the variable 'currentAvg1'.
            currentAvg1 = sum1 / 2.0;

            // This line checks if the 'currentAvg1' is less than the current minimum average
            // 'minAvg' then  it updates the 'minAvg' to the value of 'currentAvg1' and also 
            //  updates the 'minAvgSliceIndex' to the current index 'i'.
            if (currentAvg1 < minAvg) {
                minAvg = currentAvg1;
                minAvgSliceIndex = i;
            }

            // This line calculates the sum of three consecutive elements in the array 'A' by 
            // adding the value of the next element '(A[i+2])' to the previously calculated 'sum1', 
            // and stores it in the variable 'sum2'.
            sum2 = sum1 + A[i + 2];

            // This line calculates the average of the three consecutive elements by dividing 'sum2' 
            // by 3.0 and stores it in the variable 'currentAvg2'.
            currentAvg2 = sum2 / 3.0;

            // This line checks if the 'currentAvg2' is less than the current minimum average 'minAvg'.
            // And if so, it updates the 'minAvg' to the value of 'currentAvg2' and also updates the 
            // 'minAvgSliceIndex' to the current index 'i'.
            if (currentAvg2 < minAvg) {
                minAvg = currentAvg2;
                minAvgSliceIndex = i;
            }
        }

        // This line calculates the average of the last two elements in the array (if the array length is 
        // greater than 1) and stores it in the variable 'currentAvg1'.
        currentAvg1 = (A[A.length - 2] + A[A.length - 1]) / 2.0;

        // This line checks if the 'currentAvg1' is less than the current minimum average 'minAvg'.
        // If the condition is met it updates the 'minAvg' to the value of 'currentAvg1' while aslo
        // updating the 'minAvgSliceIndex' to the index of the last two elements.
        if (currentAvg1 < minAvg) {
            minAvg = currentAvg1;
            minAvgSliceIndex = A.length - 2;
        }
        return minAvgSliceIndex;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of elements of the array: ");
        int N = s.nextInt();
        int[] A = new int[N];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }

        s.close();

        int result = solution(A);
        System.out.println("The index of the slice withe the least average is " + result);
    }
}