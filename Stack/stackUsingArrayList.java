// package Stack;

import java.util.ArrayList;

public class stackUsingArrayList {
    public static class stack {
        ArrayList<Integer> list = new ArrayList<>();

        // Check is empty
        public boolean isEmpty() {
            return list.size() == 0;
        }

        // push Operation
        public void push(int data) {
            list.add(data);
        }

        // Pop Operation
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int data = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return data;
        }

        // Peek Operation
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        stack s = new stack();

        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
