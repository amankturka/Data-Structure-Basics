/*
 * Binary Search Tree
 * 
 * Operation: Insert, Search
 */

class BST {

    static class Node {
        int value;
        Node left;
        Node right;
    }

    static Node newNode(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    static Node insertBST(Node root, int value) {
        if (root == null)
            root = newNode(value);
        else if (value <= root.value)
            root.left = insertBST(root.left, value);
        else
            root.right = insertBST(root.right, value);

        return root;
    }

    static boolean search(Node root, int value) {
        if (root == null)
            return false;
        else if (root.value == value)
            return true;
        else if (value <= root.value)
            return search(root.left, value);
        else
            return search(root.right, value);
    }

    public static void main(String args[]) {
        Node root = null;
        root = insertBST(root, 1);
        root = insertBST(root, 8);
        root = insertBST(root, 5);
        root = insertBST(root, 50);

        boolean found = search(root, 8);
        System.out.println(found);
    }
}