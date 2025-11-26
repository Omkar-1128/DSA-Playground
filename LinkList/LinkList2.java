package LinkList;

public class LinkList2 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node Head;
    public static Node Tail;

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (Head == null) {
            Head = Tail = newNode;
            return;
        }

        Tail.next = newNode;

        Tail = newNode;
    }

    public static void PrintLl() {
        Node temp = Head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
        ;
    }

    // Check the Linklist is Cyclic or not
    // floyd's Cycle finding algorithm
    public static boolean isCycle() {
        Node slow = Head;
        Node fast = Head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

            if (slow == fast) {
                return true; // cyclic
            }
        }

        return false; // not cyclic
    }

    // Remove the cycle from the link list

    public static void RemoveCycle() {

        // Detect cycle
        Node slow = Head;
        Node fast = Head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // find th meeting point
        Node Prev = null; // Tail of Cyclic LinkList
        slow = Head;
        while (slow != fast) {
            slow = slow.next; // +1
            Prev = fast;
            fast = fast.next; // +1
        }

        // Remove cycle make last node null

        Prev.next = null;
    }

    public static void main(String[] args) {
        // LinkList2 Ll = new LinkList2();

        Head = new Node(1);
        Node temp = new Node(2);
        Head.next = temp;
        Head.next.next = new Node(3);
        Head.next.next.next = temp; // 1 -> 2 -> 3 -> 1 (cycle) (infinit loop)

        // PrintLl();
        System.out.println(isCycle());
        RemoveCycle();
        System.out.println(isCycle());
        PrintLl();
    }
}
