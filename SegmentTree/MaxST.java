package SegmentTree;

public class MaxST {

    // Create a segment tree

    static int[] tree;
    static int n;

    // TC :- O(n)
    public static void CreateTree(int arr[] , int i , int si , int ei) {
        // base case
        if(si == ei) {
            tree[i] = arr[si];
            return;
        }

        // Get the left and right element
        int mid = (si + ei) / 2;

        CreateTree(arr, 2 * i + 1, si, mid);
        CreateTree(arr, 2 * i + 2, mid + 1, ei);

        tree[i] = Math.max(tree[2 * i + 1] , tree[2 * i + 2]);  // return the maximum fron the tree
    }

    // get the maximum from the range

    public static int getMaxUtil(int i , int si , int sj , int qi , int qj) {
        // Non Overlapping case
        if (si >= qj || sj <= qi) {
            return Integer.MIN_VALUE;
        }

        // Complete Ovelapping case
        if (si >= qi && sj <= qj) {
            return tree[i];
        }

        // Partial Ovelapping
        int mid = (si + sj) / 2;

        int left = getMaxUtil(2 * i + 1, si, mid, qi, qj);
        int right = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);

        return Math.max(left , right);
    }

    public static int getMax(int arr[] , int qi , int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj);
    }

    // Update Query

    public static void updateUtil(int i , int si , int sj , int idx , int newVal) {
        // check the index is present in the range or not
        if(idx > sj || idx < si) {
            return;
        } 

        if(si == sj) {
            tree[i] = newVal;
            return;
        }

        int mid = (si + sj) / 2;
        updateUtil(2 * i + 1, si, mid, idx, newVal);
        updateUtil(2 * i + 2, mid + 1, sj, idx, newVal);

        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static void update(int arr[], int idx , int newVal) {
        arr[idx] = newVal;
        int n = arr.length;
        updateUtil(0, 0, n - 1, idx, newVal);
    }

    public static void main(String[] args) {
        int arr[] = {6 , 8 , -1 , 2 , 17 , 1 , 3 , 2 , 4};

        n = arr.length;
        tree = new int[4 * n];

        CreateTree(arr, 0, 0, n - 1);

        // Printing the tree
        for(int i = 0 ; i < 2 * n - 1 ; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        // Get the maximum element from the range 1 to 5 => 17
        System.out.println(getMax(arr, 1, 5));

        // Updating the idx 2 with value 20
        update(arr, 2, 20);

        // now print the new tree
        for(int i = 0 ; i < 2 * n - 1 ; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        // Get the maximum element from the range 1 to 5 => 20 after update
        System.out.println(getMax(arr, 1, 5));
    }
}
