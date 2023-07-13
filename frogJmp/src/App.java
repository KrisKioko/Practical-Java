import java.util.Scanner;

class FrogJmp {
    public static int frogJmp(int X, int Y, int D) {
        int distance = Y - X;   // calculates the distance the frog needs to cover by subtracting X from Y
        int jumps = distance / D;  //calculates the number of jumps he frog has to cover

        // This condition checks if there is a reminder when distance is 
        // divided by 'D'. If there is a reminder, it means that an
        // additional jump is needed to cover the remaining distance. 
        // In that case we increment 'jumps' by one.
        if (distance % D != 0) {
            jumps++;
        }
        return jumps;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter start point: ");
        int X = s.nextInt();
        System.out.println("Enter last point: ");
        int Y = s.nextInt();
        System.out.println("Enter distance covered by one jump: ");
        int D = s.nextInt();
        
        int jumps = frogJmp(X, Y, D);
        System.out.println("The minimum jumps number covered by the frog is "+jumps);
    }
}