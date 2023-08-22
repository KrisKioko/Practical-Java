import java.util.Scanner;


class Solution {
    public static int solution(int[] A) {
        int length = A.length;

        // array ends can't be peaks, len < 3 must return 0
        if (length < 3) {
            return 0;
        }

        int[] peaks = new int[length];

        // compute a list of 'peaks to the left' in O(n) time
        for (int index = 2; index < length; index++) {
            peaks[index] = peaks[index - 1];

            // check if there was a peak to the left, add it to the count
            if (A[index - 1] > A[index - 2] && A[index - 1] > A[index]) {
                peaks[index] += 1;
            }
        }

        // candidate is the block size we're going to test
        for (int candidate = 3; candidate <= length; candidate++) {

            // skip if not a factor
            if (length % candidate != 0) {
                continue;
            }

            // test at each point n / block
            boolean valid = true;
            int index = candidate;
            while (index != length) {

                // if no peak in this block, break
                if (peaks[index] == peaks[index - candidate]) {
                    valid = false;
                    break;
                }

                index += candidate;
            }

            // one additional check since peaks[length] is outside of array
            if (index == length && peaks[index - 1] == peaks[index - candidate]) {
                valid = false;
            }

            if  (valid) {
                return length / candidate;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws Exception {
         Scanner s = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int N = s.nextInt();

        System.out.println("Enter the integer values of each element: ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }
        s.close();

        int results = solution(A);
        System.out.println(results);
    }
}
