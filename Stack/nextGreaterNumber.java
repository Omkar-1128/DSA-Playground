import java.util.*;

public class nextGreaterNumber {

    public static int[] nextGNumber(int arr[]) {  // O(n)
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[arr.length];

        for (int i = n - 1 ; i >= 0 ; i--) {
            // 1 while
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // 2 if else
            if (s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = arr[s.peek()];
            }

            // push in s
            s.push(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {6 , 8 , 0 , 1 , 3};

        int ans[] = nextGNumber(arr);

        for (int i = 0 ; i < ans.length ; i++) {
            System.out.print(ans[i]  + " ");
        }
    }
}
