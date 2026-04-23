package SegmentTree;

public class segmentTree {

    static int n;
    static int tree[];

    // Constructing a segment tree

    // sti => segment tree idx
    // start and end of array for divide and conqure

    // TC := O(n)
    public static int ConstructTree(int[] arr, int sti, int start, int end) {
        // Base Case
        if (start == end) {
            tree[sti] = arr[start];
            return tree[sti];
        }

        // dc
        int mid = (start + end) / 2;

        ConstructTree(arr, 2 * sti + 1, start, mid);
        ConstructTree(arr, 2 * sti + 2, mid + 1, end);

        tree[sti] = tree[2 * sti + 1] + tree[2 * sti + 2];
        return tree[sti];
    }

    // Query On Segment Tree TC:- O(logn)

    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        // Case 1 :- Non Overlapping case
        if (si >= qj || sj <= qi) {
            return 0;
        }

        // Case 2 :- Complete Overlap
        if (si >= qi && sj <= qj) {
            return tree[i];
        }

        // Case 3 :- Partial Overlap
        int mid = (si + sj) / 2;
        int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
        int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);

        return left + right;
    }

    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;

        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    // Update in Segment Tree   TC :- O(logn)

    public static void UpdateUtil(int i, int si, int sj, int idx, int diff) {
        if (idx < si || idx > sj) { // Does not exist in the range
            return;
        }

        tree[i] += diff; // update tree

        if (si != sj) { // if the node is leaf node
            int mid = (si + sj) / 2;

            UpdateUtil(2 * i + 1, si, mid, idx, diff);
            UpdateUtil(2 * i + 2, mid + 1, sj, idx, diff);
        }

    }

    public static void UpdateTree(int arr[], int idx, int newVal) {
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        int n = arr.length;

        UpdateUtil(0, 0, n - 1, idx, diff);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        n = arr.length;
        tree = new int[4 * n]; // 4 * n => size for safety

        ConstructTree(arr, 0, 0, n - 1);

        // Printing the segement tree
        // 2 * n - 1 => actual size of tree
        for (int i = 0; i < 2 * n - 1; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        // Print The Sum of Range of elements
        System.out.println(getSum(arr, 2, 5));

        UpdateTree(arr, 2, 2); // Update in segment tree

        System.out.print("Updated Array:- ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("Updated Segment Tree:- ");
        for (int i = 0; i < 2 * n - 1; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

    }
}
