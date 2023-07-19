class Solution {
    public int solution(int[] A) {
     int leftSum = A[0];
     int rightSum = 0;


     for(int i = 1; i < A.length; i++) {
         rightSum += A[i];
     }
     int minDiff = Math.abs(leftSum - rightSum);

     for(int i = 1; i < A.length - 1; i++) {
         leftSum += A[i];
         rightSum -= A[i];

         int diff = Math.abs(leftSum - rightSum);
         minDiff = Math.min(minDiff, diff);
     }
     return minDiff;
    }
}
