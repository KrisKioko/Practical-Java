
class Solution {
    public int solution(int X, int[] A) {
        // Create a boolean array to keep track of the positions where leaves have fallen
        boolean[] leafPositions = new boolean[X + 1];

        // Intialize a variable to keep track of the number of the covered positions
        int coveredPositions = 0;

        // Loop through the array of the leaves
        for (int time = 0; time < A.length; time++) {
            // Get the position where the leaf falls
            int leafPosition = A[time];

            // Check if the leaf has fallen in a new position (not previously covered)
            if (!leafPositions[leafPosition]) {
                // Mark the position as corvered
                leafPositions[leafPosition] = true;

                // Increment the court of covered positions
                coveredPositions++;
            }

            // If all positions from 1 to X are covered, return the current time
            if (coveredPositions == X) {
                return time;
            }
        }
        // If not all positions are covered, retuen -1 (the frog can't cross)
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Run's good");
    }
}