package ArrayList;

import java.util.ArrayList;

public class PairSum {
    // PairSum 1
    // brute force  - O(n^2)
    public static ArrayList<Integer> PairSum1(ArrayList<Integer> arr , int target) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0 ; i < arr.size() ; i++) {
            for (int j = i + 1 ; j < arr.size() ; j++) {
                if(arr.get(i) + arr.get(j) == target) {
                    ans.add(arr.get(i));
                    ans.add(arr.get(j));
                }
            }
        }

        return ans;
    }

    // Optimal
    // Two Pointer Approch  -O(n)
    public static ArrayList<Integer> PairSum1Pointer(ArrayList<Integer> list , int target) {
        ArrayList<Integer> ans = new ArrayList<>();

        int leftP = 0;
        int rightP = list.size() - 1;

        while(leftP < rightP) {
            if (list.get(leftP) + list.get(rightP) == target) {
                ans.add(list.get(leftP));
                ans.add(list.get(rightP));
            }

            if (list.get(leftP) + list.get(rightP) < target) {
                leftP++;
            } else {
                rightP--;
            }
        }

        return ans;
    }


    // Given an array of positive elements arr[] that is sorted and then rotated around an unknown point, the task is to check if the array has a pair with sum equals to a given target.
    // Examples:
    // Input: arr[] = [7, 9, 1, 3, 5], target = 6
    // Output: true
    // Explanation: arr[2] and arr[4] has sum equals to 6 which is equal to the target

    // Pairsum 2
    // Two Pointer Approch - O(n)
    public static ArrayList<Integer> PairSum2(ArrayList<Integer> list , int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int pivotIdx = pivot(list);
        int n = list.size();
        int leftP = pivotIdx;  // Smallest element 
        int rightP = pivotIdx - 1; // Largest element

        while (leftP != rightP) {
            int sum = list.get(leftP) + list.get(rightP);
            if (sum == target) {
                ans.add(list.get(leftP));
                ans.add(list.get(rightP));
                break;
            }

            if (sum < target) {
                // if (leftP == list.size() - 1) {
                //     leftP = 0;
                // } else {
                //     leftP++;
                // }

                leftP = (leftP + 1) % n;
            } else {
                // if (rightP == 0) {
                //     rightP = list.size() - 1;
                // } else {
                //     rightP--;
                // }

                rightP = (n + rightP - 1) % n;
            }
        }

        return ans;
        
    }

    public static int pivot(ArrayList<Integer> list) {
        for (int i = 0 ; i < list.size() - 1 ; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return i + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        // int arr[] = {2,7,11,15};
        // int target = 9;

        // ArrayList<Integer> nums = new ArrayList<>();

        // nums.add(2);
        // nums.add(7);
        // nums.add(11);
        // nums.add(15);

        // System.out.println(PairSum1Pointer(nums , target));

        // arr[] = [7, 9, 1, 3, 5], target = 6
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(7);
        nums.add(9);
        nums.add(1);
        nums.add(3);
        nums.add(5);

        int target = 6;

        System.out.println(PairSum2(nums, target));
    }
}
