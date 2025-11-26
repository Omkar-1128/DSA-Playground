package LinkList;

public class DoubleLl {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node Head;
    public static Node Tail;
    public static int size;

    // Add first 

    public void addFirst(int data) {

        // step 1 = create new node
        Node newNode = new Node(data);

        // if Linklist was empty
        if (Head == null) {
            Head = Tail = newNode;
            size = 1;
            return;
        }

        // step 2 = newNode next = Head;
        newNode.next = Head;

        // step 3 = Head prev = newNode
        Head.prev = newNode;

        size++;

        // step 4 = Update Head
        Head = newNode;
    }

    // Add last

    public void addLast(int data) {
        // step 1 = Create Node
        Node newNode = new Node(data);

        // If linkList was empty
        if (Head == null) {
            Head = Tail = newNode;
            return;
        }

        // step 2 = Tail next = newNode
        Tail.next = newNode;

        // step 3 = newNode.prev = Tail
        newNode.prev = Tail;

        size++;

        // Update tail
        Tail = newNode;
    }

    // remove First

    public void removeFirst() {
        if (Head == null) {
            System.out.print("The linkList was Empty");
            return;
        }

        // if only one node 
        if (size == 1) {  // or Head.next == null
             Head = Tail = null;
             size--;
             return;
        }

        // step 1 undate head
        Head = Head.next;

        // make prev of new Head to null
        Head.prev = null;

        size--;
    }

    // Remove Last

    public void removeLast() {

        // if linkList was empty
        if (Head == null) {
            System.out.print("The linkList was Empty");
            return;
        }

        // if only one node 
        if (size == 1) {  // or Head.next == null
             Head = Tail = null;
             size--;
             return;
        }

        // step 1 = Update tail
        Tail = Tail.prev;

        // step 2 = make new tail next = null
        Tail.next = null;

        size--;
    }

    // Print Double Linklist

    public void PrintLl() {
        Node temp = Head;

        System.out.print("null" + " <-> ");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Reverse a Dll 

    public void reverseList() {
        Node curr = Head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;  // reverse
            curr.next = prev;
            curr.prev = next;

            prev = curr;  // update
            curr = next;
        }

        Head = prev;
    }

    public static void main(String[] args) {
        DoubleLl Ll = new DoubleLl();

        Ll.addFirst(2);
        Ll.addFirst(1);
        Ll.addFirst(0);

        Ll.addLast(3);
        Ll.addLast(4);

        Ll.PrintLl();
        System.out.println("Size: " + size);

        // Ll.removeFirst();
        // Ll.PrintLl();
        // System.out.println("Size: " + size);

        // Ll.removeLast();
        // Ll.PrintLl();
        // System.out.println("Size: " + size);

        Ll.reverseList();
        Ll.PrintLl();
        System.out.println("Size: " + size);
    }
}
