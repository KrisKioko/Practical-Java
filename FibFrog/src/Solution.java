/* 
The Fibonacci sequence is defined using the following recursive formula:

    F(0) = 0
    F(1) = 1
    F(M) = F(M - 1) + F(M - 2) if M >= 2
A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:

0 represents a position without a leaf;
1 represents a position containing a leaf.
The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

For example, consider array A such that:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.

For example, given:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

   * N is an integer within the range [0..100,000];
   * each element of array A is an integer that can have one of the following values: 0, 1.
 */





import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;



class Solution {
    public static int solution(int[] A) {
        int lenA = A.length;   // Represents the length of the input array 'A'.
        List<Integer> fibonacci = fibonacciDynamic(lenA + 1);   // A list of Fibonacci numbers generated dynamically up to 'lenA + 1'.
        Queue<Status> statusQueue = new LinkedList<>();    //  A queue that will be used for the Breadth-First Search (BFS) algorithm. It starts with an initial status of '-1' position and '0' moves.
        statusQueue.offer(new Status(-1, 0));
        boolean[] accessed = new boolean[lenA];     // A boolean array to keep track of visited positions.

        while (!statusQueue.isEmpty()) {
            Status currentStatus = statusQueue.poll();
            int currentPos = currentStatus.position;
            int currentMoves = currentStatus.moves;

            /* The method performs BFS(Breadth-first search) by processing each status in the 'statusQueue'. It checks different conditions for each jump length:
                (i), if the frog reaches the goal position, it returns the number of moves plus one.
                (ii), if the jump is invalid (out of bounds, no leaf, or already visited), it continues to the next jump length.
                Otherwise, it enqueues the new status with an updated position and moves, and marks the new position as visited.
             */
            for (int length : fibonacci) {
                if (currentPos + length == lenA) {
                    return currentMoves + 1;
                } else if (currentPos + length >= lenA || currentPos + length <= -1 || A[currentPos + length] == 0 || accessed[currentPos + length]) {
                    continue;
                }
                statusQueue.offer(new Status(currentPos + length, currentMoves + 1));
                accessed[currentPos + length] = true;
            }
        }
        return -1;
    }

    private static List<Integer> fibonacciDynamic(int n) {   // This method generates the Fibonacci numbers dynamically.
        List<Integer> fib = new ArrayList<>();     //  It takes an integer 'n' and returns a list of Fibonacci numbers up to 'n'.
        fib.add(0);
        fib.add(1);

        // It generates Fibonacci numbers iteratively until they are less than or equal to 'n'.
        while (true) {
            int nextFib = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
            if (nextFib > n) {
                break;
            }
            fib.add(nextFib);
        }
        return fib;
    }

    private static class Status {    //  This is a nested class to represent the status of a jump.
        int position;   //  Represents the current position.
        int moves;     // Represents the number of moves taken to reach this position.

        Status(int position, int moves) {
            this.position = position;
            this.moves = moves;
        }
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }
        s.close();

        int result = solution(A);
        System.out.println(result);
    }
}


/* 
    The main purpose of this code is to find the minimum number of jumps needed for a frog to cross a river, using the provided array 'A' to 
    determine available leaf positions. The BFS(Breadth-first search) approach explores different jump possibilities to find the shortest path. 
    The code handles various conditions and constraints to ensure accurate results.
 */