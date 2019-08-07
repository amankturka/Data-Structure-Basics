import java.util.ArrayList;
/*
 * Hash table 
 * 
 * Search time: O(1)
 */

class Node<K, V> {
    K key;
    V value;
    Node next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class HashTable<K, V> {

    private ArrayList<Node<K, V>> bucketArray;

    private int numBuckets; // capacity of bucketlist

    private int size; // size of bucketlist

    public HashTable() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        // create empty chains
        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }

    // Hash function to find index for a key
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }

    public V remove(K key) {
        // find index for a given key
        int bucketIndex = getBucketIndex(key);
        // find head of chain at bucketIndex
        Node<K, V> head = bucketArray.get(bucketIndex);
        Node<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key))
                break;

            prev = head;
            head = head.next;
        }
        if (head == null)
            return null;

        size--;

        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;

    }

    // Get a value for a key k
    public V get(K key) {
        // find index for a given key
        int bucketIndex = getBucketIndex(key);
        // find head of chain at bucketIndex
        Node<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void put(K key, V value) {
        // find index for a given key
        int bucketIndex = getBucketIndex(key);
        // find head of chain at bucketIndex
        Node<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        // insert key in chain
        head = bucketArray.get(bucketIndex);
        Node<K, V> newNode = new Node<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String args[]) {
        HashTable<String, Integer> map = new HashTable<>();

        map.put("hi", 2);
        map.put("bye", 3);
        map.put("yoo", 5);

        System.out.println("Remove from map---" + map.remove("bye"));
        System.out.println("\n");
        System.out.println("Size of map--" + map.size());
        System.out.println("\n");
        System.out.println("Map is empty or no---" + map.isEmpty());
        System.out.println("\n");
    }
}