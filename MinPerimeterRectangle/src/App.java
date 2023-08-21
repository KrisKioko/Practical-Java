import java.util.Scanner;


class Solution {
    public static int solution(int N) {
        // This initializes a variable 'minPerimeter' to the maximum possible integer value. 
        // This variable will be used to store the minimal perimeter found during the process
        int minPerimeter = Integer.MAX_VALUE;
        
        // This initiates a loop that iterates through integers starting from '1' up to the point 
        // where 'i * i' is less than or equal to 'N'. This is done because if 'i * i' becomes 
        // greater than 'N', there's no need to continue the loop, as any rectangle with sides 
        // larger than the square root of 'N' would have an area greater than 'N'.
        for (int i = 1; i * i <= N; i++) {

            // This condition checks if 'N' is divisible evenly by 'i'. If it is, then it means that 
            // 'i' can be one of the sides of a rectangle with an area equal to 'N'.
            if (N % i == 0) {
                int factor = N / i;  // If 'N' is divisible by 'i', this calculates the other factor that when multiplied by 'i', results in 'N'.
                int perimeter = 2 *(i + factor);   // This calculates the perimeter of the rectangle with sides 'i' and 'factor' using the formula '2 * (A + B)'.

                // This updates the 'minPerimeter' variable with the smaller of its current value and the calculated perimeter. This way, 
                // as the loop progresses, 'minPerimeter' stores the smallest perimeter found so far.
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }
        return minPerimeter;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter an integer representing the area of a rectangle: ");
        int N = s.nextInt();

        s.close();

        int results = solution(N);
        System.out.println("The minimum perimeter of any rectangle equal with the area 'N' is " + results);
    }
}