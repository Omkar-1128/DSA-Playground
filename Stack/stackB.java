import java.util.Stack;

// 901. Online Stock Span
// Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

// The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

// For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
// Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
// Implement the StockSpanner class:

// StockSpanner() Initializes the object of the class.
// int next(int price) Returns the span of the stock's price given that today's price is price.


// Leetcode solution
// class StockSpanner {   // TC - O(1) per next overall = O(n)
//     // Stack

//     public ArrayList<Integer> Prices;
//     public Stack<Integer> s = new Stack<>();
//     public StockSpanner() {
//         Prices = new ArrayList<>();
//     }
    
//     public int next(int price) {
//         Prices.add(price);
//         int n = Prices.size();
    
//         while (!s.isEmpty() && Prices.get(s.peek()) <= price) {
//             s.pop();
//         }

//         int span = s.isEmpty()? n : (n - 1) - s.peek();

//         s.push(n - 1);
//         return span;
//     }
// }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */


// 32. Longest Valid Parentheses

// class Solution {  TC- O(n) & SC - O(n) }
//     public int longestValidParentheses(String s) {
//         Stack<Integer> st = new Stack<>();
//         st.push(-1);
//         int length = 0;
//         for (int i = 0 ; i < s.length() ; i++) {
//             char ch = s.charAt(i);
          
//             if ( ch == '(') {
//                 st.push(i);
//             } else {
//                 st.pop();
//                 if (st.isEmpty()) {
//                     st.push(i);
//                 } else {
//                     length = Math.max(length , i - st.peek());
//                 }
                
//             }
//         }

//         return length;
//     }
// }

public class stackB {

    public static void StockSpan(int stocks[] , int span[]) {   // TC - O(n)
        Stack<Integer> s = new Stack<>();

        span[0] = 1;
        s.push(0);
     
        for (int i = 1 ; i < stocks.length ; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    // Valid Parenthesis
    public static boolean isValid(String s) {  // O(n)
        Stack<Character> st = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            // Opening
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                // closing
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.peek();

                if ((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // Duplicate Parenthesis
    public static boolean DuplicateParenthesis(String s) {  // O(n)
        Stack<Character> st = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);

            if (ch == ')') {
                int count = 0;
                
                while (st.pop() != '(') {
                    count++;
                } 

                if (count < 1) {
                    return true;  // duplicate exist
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // int stocks[] = {100 , 80 , 60 , 70 , 60 , 85 , 100};
        // int span[] = new int[stocks.length];

        // StockSpan(stocks , span);

        // for (int i = 0 ; i < span.length ; i++) {
        //     System.out.print(span[i] + " ");
        // }

        // String s = "({{[]})";
        // System.out.println(isValid(s));

        String s = "(a + b)";
        System.out.println(DuplicateParenthesis(s));
    }
}
