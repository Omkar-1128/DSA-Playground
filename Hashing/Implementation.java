package Hashing;

import java.util.LinkedList;

public class Implementation {
    public class HashMapCode<K, V> { // generics
        public class Node {

            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }

        }

        private int size;  // n -> Total number of nodes
        private LinkedList<Node> Bucket[];  // N  -> array size

        @SuppressWarnings("unchecked")

        public void HashMap() {
            this.size = 0;
            this.Bucket = new LinkedList[4];

            for (int i = 0 ; i < Bucket.length ; i++) {
                Bucket[i] = new LinkedList<>();
            }
        }
        
    }
}
