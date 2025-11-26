package LinkList;

public class ZigZagLinkList {

    public static class Node {
        int data;
        Node next;

        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }   

    public static Node mid(Node Head) {
        Node slow = Head;
        Node fast = Head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow;
    }

    public static Node reverse(Node Head) {
        Node curr = Head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static Node ZigZag(Node Head) {
        // Step 1 Find the mid (1 half last node)
        Node mid = mid(Head);

        // Step 2 divide and reverse second half
        Node RigthHead = reverse(mid.next);
        mid.next = null;
        Node LeftHead = Head;

        // step 3 Alternate Merging

        Node nextL;
        Node nextR;

        while (RigthHead != null && LeftHead != null) {
            nextL = LeftHead.next;
            LeftHead.next = RigthHead;
            nextR = RigthHead.next;
            RigthHead.next = nextL;

            RigthHead = nextR;
            LeftHead = nextL;
        }

        return Head;

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
        Node Head = new Node(1);
        Head.next = new Node(2);
        Head.next.next = new Node(3);
        Head.next.next.next = new Node(4);
        Head.next.next.next.next = new Node(5);
        Head.next.next.next.next.next = new Node(6);

        PrintLl(Head);
        Head = ZigZag(Head);
        PrintLl(Head);
    } 
}
