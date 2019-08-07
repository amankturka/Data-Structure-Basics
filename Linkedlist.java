/* 
LinkedList: linear data structure in which elements are stored in non-contigous mempory locations.

Operations:
    Traverse  O(n)
    Insert    
        At nth position  O(n)
    Delete
        At nth position  O(n)
*/

class Linkedlist {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    // Insert in LinkedList at nth position
    static void insert(int data, int n) {

        Node newNode = new Node(data);
        newNode.next = null;
        if (n == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 0; i < n - 2; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete from linkedlist at nth position
    static void delete(int n) {
        Node temp = head;
        if (n == 1) {
            head = temp.next;
            return;
        }
        for (int i = 0; i < n - 2; i++) {
            temp = temp.next;
        }
        Node temp2 = temp.next;
        temp.next = temp2.next;
    }

    // Print linkedlist
    static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public static void main(String args[]) {

        head = null;
        // Insert
        insert(2, 1);
        insert(3, 2);
        insert(4, 1);

        // traverse list
        print();

        // delete from list
        delete(1);
        System.out.println("--------");
        print();

    }
}