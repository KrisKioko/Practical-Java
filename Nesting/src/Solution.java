import java.util.Scanner;
import java.util.Stack;




public class Solution {
    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();  // A 'Stack<Character>' named 'stack' is initialized to store characters.

        // This initiates a loop that iterates through each character 'c' in the array of characters obtained from the input string 'S'.
        for (char c : S.toCharArray()) {

            // This checks if the current character 'c' is either an opening parentheses, curly bracket or square brackets ('(', '{', '['). 
            // If it is, the character is pushed onto the stack using the 'push' method. The 'else if' block checks if the current character 
            // 'c' is either a closing parentheses, curly bracket or square brackets (')', '{', '[') and if the stack is not empty. It also 
            // verifies if the top character of the stack matches the expected corresponding opening brackets ('(', '{', '['). If all 
            // conditions are met, the top element of the stack (the matching opening bracket) is removed using the 'pop' method.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                // If none of the previous conditions are met, it means the character is not an opening or matching closing bracket, indicating a mismatch. 
                // In this case, the function immediately 'returns 0' to indicate that the string is not properly nested.
                return 0;   
            }
        }
        // This line checks if the stack is empty. If it is, it means all brackets were properly matched and balanced, 
        // so the function 'returns 1' (properly nested). If the stack is not empty, it means there are unmatched opening
        // brackets left, and the function 'returns 0' (not properly nested).
        return stack.isEmpty() ? 1 : 0;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String n = s.nextLine();    // Reads an integer 'n' from input, representing the number of elements in the array.
        Solution solution = new Solution();    // This line creates an instance of the 'Solution' class using the default constructor. This instance will be used to call the solution method to process the input string.
        int result = Solution.solution(n);    // This line calls the solution method of the Solution instance created earlier and passes the input string as an argument. The result of the method (0 or 1) is stored in the result variable of type int.

        System.out.println("Result: " + result);
        s.close();
    }
    
}
