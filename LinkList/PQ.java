package LinkList;

// questions 1
// 160. Intersection of Two Linked Lists

// solution1 
// public class Solution {   // TC = O(m * n)
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         while (headB != null) {   
//             ListNode temp = headA;

//             while (temp != null) {
//                 if (temp == headB) {
//                     return temp;
//                 }

//                 temp = temp.next;
//             }

//             headB = headB.next;
//         }

//         return null;
//     }
// }

// solution 2 // optimized
// public class Solution {   // TC = O(m + n)
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         if (headA == null || headB == null) {
//             return null;
//         }

//         ListNode ptr1 = headA;
//         ListNode ptr2 = headB;
//         while (ptr1 != ptr2) {
//             if (ptr1 == null) {
//                 ptr1 = headB;
//             } else {
//                 ptr1 = ptr1.next;
//             }

//             if (ptr2 == null) {
//                 ptr2 = headA;
//             } else {
//                 ptr2 = ptr2.next;
//             }
//         }

//         return ptr1;
//     }
// }

// Solution 3 
// public class Solution {  //TC = O(n)
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         // Using Hashset

//         HashSet<ListNode> set = new HashSet<>();

//         // add elements in set
//         ListNode temp = headA;
//         while (temp != null) {
//             set.add(temp);
//             temp = temp.next;
//         }

//         temp = headB;
//         while (temp != null) {
//             if (set.contains(temp)) {  // check common Node
//                 return temp;  // Common Node
//             }

//             temp = temp.next;
//         }

//         return null;
//     }
// }

// question 2
// Delete N nodes after M nodes of a linked list
// Given a linked list, delete n nodes after skipping m nodes of a linked list until the last of the linked list.
// Examples:

// Input: Linked List: 9->1->3->5->9->4->10->1, n = 1, m = 2

// Output: 9->1->5->9->10->1

// Explanation: Deleting 1 node after skipping 2 nodes each time, we have list as 9-> 1-> 5-> 9-> 10-> 1.

// class Solution {   // TC - O(n)
//     static void linkdelete(Node head, int n, int m) {
//         // your code here
//         Node temp = head;
        
//         while (temp != null) {
//             int i = 0;
        
//             while (i != m - 1) {
//                 temp = temp.next;
//                 i++;
//             }
            
//             if (temp == null) {
//                 return;
//             }
            
//             Node t = temp.next;
//             for (int j = 0 ; j < n && t != null ; j++) {
//                 t = t.next;
//             }
            
//             temp.next = t;
            
//             temp = t;
//         }
        
//     }
// }


// question 3
// 1721. Swapping Nodes in a Linked List

// slution 1
// class Solution {  // TC - O(n)
//     public ListNode swapNodes(ListNode head, int k) {
//         // calculate size 
//         ListNode temp = head;
//         int size = 0;

//         while (temp != null) {
//             temp = temp.next;
//             size++;
//         }

//         // find the kth prev node from begining
//         ListNode start = head;
//         int i = 1;
//         while (i < k ) {
//             start = start.next;
//             i++;
//         }

//         // find the kth prev node from end
//         ListNode end = head;
//         int j = 1;
//         while (j < size - k + 1) {
//             end = end.next;
//             j++;
//         }

//         // swap the values of start and end
//         int dummy = start.val;
//         start.val = end.val;
//         end.val = dummy;

//         return head;
//     }
// }

// solution 2

// class Solution {
//     public ListNode swapNodes(ListNode head, int k) {
//         // calculate size 
//         ListNode temp = head;
//         int size = 0;

//         while (temp != null) {
//             temp = temp.next;
//             size++;
//         }

//         if (k == (size - k + 1)) {
//             return head;
//         }

//         // find the kth prev node from begining
//         ListNode start = head;
//         ListNode pstart = null;
//         int i = 1;
//         while (i < k) {
//             pstart = start;
//             start = start.next;
//             i++;
//         }

//         // find the kth prev node from end
//         ListNode end = head;
//         ListNode pend = null;
//         int j = 1;
//         while (j < size - k + 1) {
//             pend = end;
//             end = end.next;
//             j++;
//         }

//         if (start == null || end == null) {
//             return head;
//         }

//         if (pstart != null) {
//             pstart.next = end;
//         } else {
//             head = end;
//         }

//         if (pend != null) {
//             pend.next = start;
//         } else {
//             head = start;
//         }

//         ListNode dummy = start.next;
//         start.next = end.next;
//         end.next = dummy;

//         return head;
//     }
// }

// question 5
// 23. Merge k Sorted Lists

// solution 1

// class Solution {
//     public static ListNode SortedMerge(ListNode a, ListNode b) {
//         ListNode ans = null;

//         if (a == null) {
//             return b;
//         }

//         if (b == null) {
//             return a;
//         }

//         if (a.val <= b.val) {
//             ans = a;
//             ans.next = SortedMerge(a.next, b);
//         } else {
//             ans = b;
//             ans.next = SortedMerge(a, b.next);
//         }

//         return ans;
//     }

//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists.length == 0) {
//             return null;
//         }

//         int k = lists.length;
//         int last = k - 1;

//         while (last != 0) {
//             int i = 0;
//             int j = last;
//             while (i < j) {
//                 lists[i] = SortedMerge(lists[i], lists[j]);
//                 i++;
//                 j--;

//                 if (i >= j) {
//                     last = j;
//                 }
//             }
//         }

//         return lists[0];
//     }
// }

