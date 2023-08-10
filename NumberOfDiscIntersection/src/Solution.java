import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    public static int solution(int[] A) {
        // This line stores the length of the input array 'A' in the 
        // variable 'n', which represents the number of discs.
        int n = A.length;

        // This line initializes an integer array 'startPoints' to store 
        // the starting points of each disc interval.
        int[] startPoints = new int[n];

        // This line initializes an integer array 'endPoints' to store the 
        // ending points of each disc interval.
        int[] endPoints = new int[n];

        // The 'for' loop iterates through each disc and calculates the starting 
        // and ending points of their intervals based on their radius and position. 
        // These points represent the range on the x-axis where the disc is present.
        for (int i = 0; i < n; i++) {
            startPoints[i] = i - A[i];
            endPoints[i] = i + A[i];
        }

        // These two lines sort the 'startPoints' and 'endPoints' array in ascending order. Sorting these 
        // arrays helps us determine the active discs and their intersections.
        Arrays.sort(startPoints);
        Arrays.sort(endPoints);

        int intersections = 0;  // This line initializes a counter to keep track of the number of intersections.
        int activeDiscs = 0;  // This line initializes a counter to keep track of the number of currently active discs.
        int endIndex = 0;  // This line initializes an index that will be used to track the position in the endPoints array.

        // The next 'for' loop iterates through each disc's starting point and calculates the 
        // intersections based on the active discs and their ending points.
        for (int startIndex : startPoints) {

            // Inside the loop, the 'while' loop iterates through the 'endPoints' array and adjusts 
            // the 'activeDiscs' counter based on the ending points of discs that have ended their interval.
            while (endIndex < n && startIndex > endPoints[endIndex]) {
                activeDiscs--;
                endIndex++;
            }

            // This line adds the number of active discs to the 'intersections' counter. Since any active disc 
            // at this point will intersect with all discs that have a starting point before it, this contributes 
            // to the total intersections.
            intersections += activeDiscs;
            activeDiscs++;  // This line increments the 'activeDiscs' counter, as a new disc's interval is starting.

            // The 'if' statement checks whether the number of intersections has exceeded the limit of 10,000,000. 
            // If it has, the function returns -1, as stated in the problem's requirements.
            if (intersections > 10000000) {
                return -1;
            }
        }
        return intersections;  // Represents the total number of intersecting pairs of discs.
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // Reads an integer 'n' from input, representing the number of elements in the array.
        int[] A = new int[n];  // Creates an array 'A' of size 'n' to store the input elements.

        // A loop to read 'n' integers from input and store them in the array 'A'.
        for (int i = 0; i < n; i++) {
            A[i] = s.nextInt();
        }
        s.close();

        // Calls the 'solution' method with the array 'A' and stores the result in 'distinctCount'.
        int distinctCount = solution(A);  
        System.out.println(distinctCount);
    }
    
}
