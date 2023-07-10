import java.util.Scanner;


class Solution {
    public int solution(int N) {
        String binaryString = Integer.toBinaryString(N);   // Converts 'N' integer to binary representation

        int maxGapLength = 0;  //stores the length of the longest binary gap found so far
        int currentGapLength = 0;  //keeps track of the length of the current binary gap being examined
        boolean countingGap = false;  // is a flag that indicates whether the algorithm is currently counting a binary gap
        

        //starts a loop that iterates through each character in the binary representation of 'N'. The loop variable 'i' is the index of the current character being processed.
        for (int i = 0; i < binaryString.length(); i++) {

            //this line retrieves the current character from the 'binaryString' using 'binaryString.charAt(i)'. Its assigns the character to the variable 'c'.
            char c = binaryString.charAt(i);

            //These lines below handle the logic for finding and counting binary gaps.
            if(c == '1') {
                if(countingGap) {

                    //compres the 'currentGapLength' with the 'maxGapLength' using 'Math.max' to update 'maxGapLength'.
                    maxGapLength = Math.max(maxGapLength, currentGapLength);

                    //resets the 'currentGapLength' to 0.
                    currentGapLength = 0;
                } else {
                    // new binary gap starts
                    countingGap = true;
                }
            } else if (countingGap) {
                currentGapLength++;
            }
        }
        //repesents the lenght of the longest binary gap in the input 'N'
        return maxGapLength;
    }

    public static void main(String[] args) {

        // creating an instance of the 'Solution' class, and prints the result.
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        // enter an example value for 'N' i.e. 1041
        int N = scanner.nextInt();

        int longestGap = solution.solution(N);
        // prints the results
        System.out.println("Longest Binary Gap: " + longestGap);

        scanner.close();
    }
}