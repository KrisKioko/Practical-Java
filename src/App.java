import java.util.Scanner;

class ArrayCyclicRotation {
    public static int[] arraycyclicrotation(int[] A, int K) {
        int length = A.length;  // variable 'length' is assigned tthe length of the input array 'A'
        if (length == 0) {
            return A;   // If the array is empty, returns the original array.
        }

        // Adjust the number of rotations if it exceeds the array length
        K = K % length;   // Calculates the remainer when dividing 'K' by length.

        if (K == 0) {
            return A;
        }

        // Create a new array to store the rotated elements
        int[] rotatedArr = new int[length];

        // Perform the rotation
        for (int i = 0; i < length; i++) {
            int newPosition = (i + K) % length;
            rotatedArr[newPosition] = A[i];
        }
        return rotatedArr;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the number of  elements in the array: ");
        int length = s.nextInt();
        int[] A = new int[length];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < length; i++) {
            A[i] = s.nextInt();
        }

        System.out.print("Enter the number of rotations: ");
        int K = s.nextInt();

        s.close();

        int[] rotatedArray = arraycyclicrotation(A, K);
        System.out.println("Rotated array: ");
        for (int num : rotatedArray) {
            System.out.print(num + " ");
        }
    }
}