package LinkList;


// TC = O(nlogn)
public class MergeSort {

    public static class Node {
        int data;
        Node next;

        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Find mid
    public static Node FindMid(Node Head) {
        Node slow = Head;
        Node fast = Head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node mergeSort(Node Head) {
        // Base case
        if (Head == null || Head.next == null) {
            return Head;
        }

        // Find mid
        Node mid = FindMid(Head);

        Node LeftHead = Head;
        Node RightHead = mid.next;
        mid.next = null;
        // divide 
        LeftHead = mergeSort(LeftHead);  // Left Half
        RightHead = mergeSort(RightHead);  // Right Half

        // Merge 
        return Merge(LeftHead, RightHead);
    }

    public static Node Merge (Node LeftHead , Node RightHead) {
        Node MergeLl = new Node(-1);  // temp LinkList

        Node temp = MergeLl;

        while (LeftHead != null && RightHead != null) {
            if (LeftHead.data < RightHead.data) {   // leftHead data is small
                temp.next = LeftHead;
                temp = temp.next;
                LeftHead = LeftHead.next;
            } else {                                // RigthHEad data is small
                temp.next = RightHead;  
                temp = temp.next;
                RightHead = RightHead.next;
            }
        }

        while (LeftHead != null) {
            temp.next = LeftHead;
            temp = temp.next;
            LeftHead = LeftHead.next;
        }

        while (RightHead != null) {
            temp.next = RightHead;
            temp = temp.next;
            RightHead = RightHead.next;
        }

        return MergeLl.next;
    }

    public static void PrintLl(Node Head) {
        Node temp = Head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
    public static void main(String[] args) {
        
        Node Head = new Node(3);
        Head.next = new Node(8);
        Head.next.next = new Node(4);
        Head.next.next.next = new Node(1);
        Head.next.next.next.next = new Node(6);  
        Head.next.next.next.next.next = null;  

        PrintLl(Head);
        Head = mergeSort(Head);
        PrintLl(Head);
    }
}
