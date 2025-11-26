package LinkList;

public class LinkList {

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
    public static int size;

    // Methods for LinkList

    public void addFirst(int data) { // adds node in the begining of linklist // TC- O(1)

        // Step-1 = create new node
        Node newNode = new Node(data);
        size++;

        // if LinkList was empty
        if (Head == null) {
            Head = Tail = newNode;
            return;
        }

        // Step-2 = add head in new node next
        newNode.next = Head;

        // Step-3 = make newNode as Head
        Head = newNode;
    }

    public void addLast(int data) { // add node in the end of the linkList // TC- O(1);

        // Step-1 = Create new Node
        Node newNode = new Node(data);
        size++;

        // If LinkList was empty
        if (Head == null) {
            Head = Tail = newNode;
            return;
        }

        // Step-2 = add new node in tails next
        Tail.next = newNode;

        // Step-3 = make newNode as a Tail
        Tail = newNode;
    }

    // Add in the Middle

    public void AddMiddle(int index, int data) { // TC - O(n)
        // if Index = 0
        if (index == 0) {
            addFirst(data);
            return;
        }
        // 1 = Create new Node
        Node newNode = new Node(data);
        size++;

        // find the previous index
        int i = 0;
        Node temp = Head;

        while (i < index - 1) {
            i++;
            temp = temp.next;
        }

        // i becomes equal to index - 1 , temp -> prev

        // steps:
        // 1 = newNode.next = temp.next // make the temp old next to the newNode next
        newNode.next = temp.next;

        // 2 = temp.next = newNode // add newNode at temp
        temp.next = newNode;
    }

    // Print the LinkList
    public void PrintLl() { // TC - O(n)
        Node temp = Head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public int RemoveFirst() { // TC - O(1)
        // if linklist is empty
        if (size == 0) {
            System.out.println("Link List was empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) { // if only one node
            int val = Head.data;
            Head = Tail = null; // After removing single node the head and tail becomes Empty
            size = 0;
            return val;
        }

        int val = Head.data;
        // Move head by 1
        Head = Head.next;
        size--;

        return val; // returns value which was deleted
    }

    public int RemoveLast() {
        if (size == 0) {
            System.out.println("Link list was empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = Head.data;
            Head = Tail = null;
            size = 0;
            return val;
        }

        // prev = size - 2
        int i = 0;
        Node temp = Head;
        while (i < size - 2) {
            temp = temp.next;
            i++;
        }

        // temp -> prev
        int val = Tail.data; // temp.next.data
        temp.next = null;
        Tail = temp;
        size--;

        return val;
    }

    // Iterative search in Link List
    public int itrSearch(int key) { // TC - O(n)

        Node temp = Head;

        // for (int i = 0 ; i < size ; i++) {
        // if(temp.data == key) {
        // return i;
        // } else {
        // temp = temp.next;
        // }
        // }
        int i = 0;
        while (temp != null) {
            if (temp.data == key) { // key found
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1; // key not found
    }

    // Search in linklist Recursively
    public int Helper(int key, Node Head) { // TC - O(n) and SC - O(n)
        // Base Case
        if (Head == null) {
            return -1;
        }

        if (key == Head.data) {
            return 0;
        }
        // recursion
        int idx = Helper(key, Head.next);

        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public int recSearch(int key) {
        return Helper(key, Head);
    }

    // Reverse a Link List

    public void Reverse() { // TC - O(n)
        // initialize
        Node curr = Tail = Head;
        Node prev = null;
        Node next;

        while (curr != null) {
            // step 1 - next = curr.next
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Head = prev;
    }

    // Find and remove nth element form the linklist

    public int removeNthFromEnd(int n) {

        // Calculate Size
        int sz = 0;
        Node temp = Head;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }

        int i = 1;
        Node curr = Head;

        if (sz == n) {
            int val = Head.data;
            Head = Head.next;
            return val;
        }

        while (i < sz - n) {
            i++;
            curr = curr.next;
        }

        int val = curr.next.data;
        curr.next = curr.next.next;
        size--;
        return val;
    }

    // Return Middle node using slow fast Technique
    public Node findMid(Node Head) {
        Node slow = Head;
        Node fast = Head;

        while (fast != null && fast.next != null) {
            slow = slow.next;  // +1
            fast = fast.next.next;  // +1
        }

        return slow; // middle node
    }

    // Check the linkList is palindrom or not
    public boolean CheckPlaindrom() {
        if (Head == null || Head.next == null) {
            return true;
        }

        // Step 1 = Find Mid

        Node mid = findMid(Head);

        // Step2 - Reverse the 2nd Half
        Node prev = null;
        Node curr = mid;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;  // Right half Head
        Node left = Head;  // Left half Head

        //Step3 - Check the left half and right half
        while (right != null) {
            if (right.data != left.data) {
                return false;
            }
            
            right = right.next;
            left = left.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkList Ll = new LinkList();

        // Ll.addFirst(2);
        // Ll.addFirst(1);

        // Ll.addLast(3);
        // Ll.addLast(4);

        // LinkList = 1 -> 2 -> 3 -> 4 // by above operations

        // Ll.PrintLl(); // O/P = 1 -> 2 -> 3 -> 4 -> null
        // System.out.println("size: " + size); // 4

        // Ll.AddMiddle(2, 9);
        // Ll.PrintLl(); // O/P = 1 -> 2 -> 9 -> 3 -> 4 -> null
        // System.out.println("size: " + size); // 5

        // int deletedVal1 = Ll.RemoveFirst();
        // Ll.PrintLl();
        // System.out.println("deleted data-> " + deletedVal1);
        // System.out.println("size: " + size);

        // int deletedVal = Ll.RemoveLast();
        // Ll.PrintLl();
        // System.out.println("deleted data-> " + deletedVal);
        // System.out.println("size: " + size);

        // Iterative Search
        // int key = 9;
        // int found = Ll.itrSearch(key);
        // if (found != -1) {
        // System.out.println("The Key " + key + " is at index " + found);
        // } else {
        // System.out.println("The key " + key + " is not present in the LinkList");
        // }

        // Recursive Search
        // int key = 9;
        // int found = Ll.recSearch(key);
        // if (found != -1) {
        // System.out.println("The Key " + key + " is at index " + found);
        // } else {
        // System.out.println("The key " + key + " is not present in the LinkList");
        // }

        // Reverse the LinkList
        // Ll.Reverse();
        // Ll.PrintLl();

        // Remove nth elemtn
        // int deletedData = Ll.removeNthFromEnd(5);
        // Ll.PrintLl();
        // System.out.println("Deleted Value: " + deletedData);
        // System.out.println("Size: " + size);

        // find mid
        // System.out.println(Ll.findMid(Head).data);  // middle node data

        // Check the link list is palindrom or not

        Ll.addLast(1);
        Ll.addLast(2);
        Ll.addLast(3);
        Ll.addLast(2);
        Ll.addLast(1);
        Ll.PrintLl();
        boolean Ispal = Ll.CheckPlaindrom();

        if (Ispal) {
            System.out.println("The LinkList is Palindrom");
        } else {
            System.out.println("The LinkList Is not Plaindrom");
        }
    }
}
