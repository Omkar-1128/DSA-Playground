// 234. Palindrome Linked List

// class Solution {
//     public boolean isPalindrome(ListNode head) {  // O(n)
//         Stack<Integer> s = new Stack<>();
//         // find middle

//         ListNode slow = head;
//         while (slow != null) {  // O(n)
//             s.push(slow.val);
//             slow = slow.next;
//         }

//         while (head != null) {   // O(n)
//             int top = s.pop();

//             if (top != head.val) {
//                 return false;
//             }

//             head = head.next;
//         }

//         return true;
//     }
// }


// 42. Trapping Rain Water
// class Solution {
//     public int trap(int[] height) {
//         Stack<Integer> s = new Stack<>();
//         int n = height.length;
//         int MaxTrapedWater = 0;

//         for (int i = 0 ;  i < n ; i++) {
//             while (!s.isEmpty() && height[s.peek()] < height[i]) {
//                 int pop_height = s.pop();

//                 if (s.isEmpty()) {
//                     break;
//                 }

//                 int distance = i - s.peek() - 1;
//                 int minHeight = Math.min(height[i] , height[s.peek()]) - height[pop_height];
//                 MaxTrapedWater += minHeight * distance;
//             }

//             s.push(i);
//         }

//         return MaxTrapedWater;
//     }
// }


// 71. Simplify Path

// class Solution {  TC = O(n) && SC = O(1) }
//     public String simplifyPath(String path) {
//         StringBuilder res = new StringBuilder("");
//         res.append("/");
//         int n = path.length();
//         Stack<String> st = new Stack<>();

//         // add the direcetory name in the stack
//         for (int i = 0 ; i < n ; i++) {
//             StringBuilder dir = new StringBuilder("");
//             while (i < n && path.charAt(i) == '/') {
//                 i++;
//             } 
//             while (i < n && path.charAt(i) != '/') {
//                 dir.append(path.charAt(i));
//                 i++;
//             }
    
//             String d = dir.toString();

//             if(d.length() == 0) {
//                 continue;
//             }

//             if (d.equals("..") == true && !st.isEmpty()) {
//                 st.pop();
//             }

//             if (d.equals(".") == true) {
//                 continue;
//             }

//             if (d.equals("..") == false && d.equals(".") == false) {
//                 st.push(d);
//             }
//         }  

//         // reverse the stack 
//         Stack<String> st2 = new Stack<>();

//         while(!st.isEmpty()) {
//             st2.push(st.pop());
//         }

//         // Make the solution
//         while (!st2.isEmpty()) {
//             if (st2.size() != 1) {
//                 res.append(st2.pop() + "/");
//             } else {
//                 res.append(st2.pop());
//             } 
//         }

//         return res.toString();
//     }
// }