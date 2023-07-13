import java.util.Scanner;

// To find the missing element in an array,
// you can use the XOR operation. By XORing
// all the elements in the array with the numbers
// from 1 to N+1, the result will be the missing element.
class PermMissingElem {
    public static int permMissingElem(int[] A) {
        int xorSum = 0;

        // We iterate through the array A using a for loop.
        // In each iteration, we XOR the current element A[i]
        // with the current index i + 1 and update the xorSum variable.
        for (int i = 0; i < A.length; i++) {
            xorSum ^= A[i] ^ (i + 1);
        }

        // Finally, we XOR the xorSum with A.length + 1
        // to account for the missing element.
        xorSum ^= A.length + 1;
        
        return xorSum;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elemments in the array: ");
        int n = s.nextInt();  // Read the length of the array
        int[] A = new int[n];  // Create an array of size 'n'

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            A[i] = s.nextInt(); // Read each element of the array
        }

        s.close();

        int missingElement = permMissingElem(A);  // Call the solution method
        System.out.println("Missing element is " + missingElement);
    }
}