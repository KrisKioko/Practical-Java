class OddOccurrences {
    public int oddOccurrences(int[] A) {
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            result ^= A[i];   //XOR operation takes place
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Good to go" );
    }
}