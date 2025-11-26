package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class PQ {

    // Lonely Numbers in ArrayList (MEDIUM)
    // You are given an integer arraylist nums. A number x is lonely when it appears only once, and
    // no adjacent numbers (i.e. x + 1 and x - 1) appear in the arraylist.
    // Return all lonely numbers in nums. You may return the answer in any order.
    // Sample Input 1 : nums = [10,6,5,8]
    // Sample Output 1 : [10,8]

    public static ArrayList<Integer> findLonely(int nums[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);  // 5 , 6 , 8 ,10
        int n = nums.length;

        for (int i = 1 ; i < n - 1 ; i++) {
            if (nums[i - 1] + 1 < nums[i] && nums[i + 1] - 1 > nums[i]) {
                ans.add(nums[i]);
            }
        }

        if (n == 1) {
            ans.add(nums[0]);
        }

        if (nums[1] - 1 > nums[0]) {
            ans.add(nums[0]);
        }

        if (nums[n - 2] + 1 < nums[n - 1]) {
            ans.add(nums[n - 1]);
        }

        return ans;
    }


    // 932. Beautiful Array
    public static ArrayList<Integer> BeautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        for (int i = 2 ; i <= n ; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            for(Integer e: ans) {
                if(2*e <= n) {
                    temp.add(2*e);
                }
            }

            for (Integer e: ans) {
                if (2*e - 1 <= n) {
                    temp.add(2*e - 1);
                }
            }

            ans = temp;
        }


        return ans;
    }

    // Beautiful array using recursion
    
    public static ArrayList<Integer> BeautifulArray2(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        DivideConquer(1, 1, n, res); 
        return res;
    }

    public static void DivideConquer(int start , int incr , int n , ArrayList<Integer> res) {
        // base case
        if (start + incr > n) {
            res.add(start);
            return;
        }

        // recursion

        DivideConquer(start, 2 * incr, n, res);  // gives all odd numbers at the begining
        DivideConquer(start + incr, 2 *incr, n, res); // gives all even numbers at the end
    }

    public static void main(String[] args) {
        // int nums[] = {10,6,5,8};

        // System.out.println(findLonely(nums));

        int n = 5;
        System.out.println(BeautifulArray2(n));
    }
}
