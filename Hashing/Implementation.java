package Hashing;

import java.util.LinkedList;

public class Implementation {
    public static class HashMapCode<K, V> { // generics
        public class Node {

            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }

        }

        private int size;  // n -> Total number of nodes
        private int N;  // Bucket Size
        private LinkedList<Node> Bucket[];  // N  -> array size

        @SuppressWarnings("unchecked")

        public HashMapCode() {
            this.N = 4;
            this.Bucket = new LinkedList[4];

            for (int i = 0 ; i < Bucket.length ; i++) {
                Bucket[i] = new LinkedList<>();
            }
        }

        // Print function
        public void PrintMap() {
            System.out.println("Keys: ");
            for(int i = 0 ; i < Bucket.length ; i++) {
                for(int j = 0 ; j < Bucket[i].size() ; j++) {
                    System.out.println(Bucket[i].get(j).key);
                }
            }   

            System.out.println();
            System.out.println();
            System.out.println("Values: ");

            for(int i = 0 ; i < Bucket.length ; i++) {
                for(int j = 0 ; j < Bucket[i].size() ; j++) {
                    System.out.println(Bucket[i].get(j).value);
                }
            }
        }

        public int HashFunction(K key) {
            int hc = key.hashCode(); // Returns and number either -ve or +ve
            return Math.abs(hc) % Bucket.length;
        }

        public int SearchInLL(K key , int bi) {
            LinkedList<Node> ll = Bucket[bi];
            int di = 0;
            for (int i = 0 ; i < ll.size() ; i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        public void rehash() {
            LinkedList<Node> oldBucket[] = Bucket;
            Bucket = new LinkedList[2 * N];

            for(int i = 0 ; i < Bucket.length ; i++) {
                Bucket[i] = new LinkedList<>();
            }

            for(int i = 0 ; i < oldBucket.length ; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for(int j = 0 ; j < ll.size() ; j++) {
                    Node node = ll.remove();
                    put(node.key , node.value);
                }
            }
        }

        public void put(K key , V value) {
            int bi = HashFunction(key);
            int di = SearchInLL(key, bi);   // -1 Key not present

            if(di != -1) {
                Node node = Bucket[bi].get(di);
                node.value = value;
            } else {
                Bucket[bi].add(new Node(key, value));
                size++;
            }

            // check the value of lambda
            double lambda = size / N;
            if(lambda > 2.0) {
                rehash();
            }
        }

        public V get(K key) {
            int bi = HashFunction(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {
                return Bucket[bi].get(di).value;
            } else {
                return null;
            }
        }

        public boolean containsKey(K key) {
            int bi = HashFunction(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) {
            int bi = HashFunction(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {
                return Bucket[bi].remove(di).value;
            } else {
                return null;
            }
        }
        
    }

    public static void main(String[] args) {
            HashMapCode<String , Integer> map = new HashMapCode<>();

            map.put("India", 100);
            map.put("US", 50);
            map.put("China", 150);
            map.put("Nepal", 10);

            map.PrintMap();
            System.out.println();
            System.out.println();
            System.out.println(map.remove("India"));
            System.out.println(map.get("India"));
    }
}
