import java.util.Stack;

public class stackA {
    // Push new data at the bottom of stack using recursion
    public static void pushAtBottom(Stack<Integer> list, int data) { // O(n)
        if (list.isEmpty()) {
            list.push(data);
            return;
        }

        int top = list.pop();
        pushAtBottom(list, data);
        list.push(top);
    }

    // Reverse the String using stack
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx != str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder("");

        while (!s.isEmpty()) {
            char curr = s.pop();
            sb.append(curr);
        }

        return sb.toString();
    }

    // reverse a stack
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void PrintStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // pushAtBottom(s, 4);

        // while (!s.isEmpty()) {
        // System.out.println(s.peek());
        // s.pop();
        // }

        // String str = "abcdefg";
        // System.out.println(reverseString(str));

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // 3 , 2 , 1
        // PrintStack(s);

        reverseStack(s);

        PrintStack(s);  // 1 , 2 , 3
    }
}
