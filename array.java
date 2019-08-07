/*
Data Structures is a way to store and organise data in computer, so that it can be used efficeintly.

ARRAYS: is a collection of elements stored in contiguous memory locations.
Index: Used to uniquely identify an element in array.
Throws ArrayIndexOutOfBoundExceptions: when accessed with index greater than size of array or negative value.
OPERATIONS: 
    Insert     O(n)
    Access     O(1)
    Delete     O(n)
*/

class array {
    public static void main(String args[]) {
        int[] example = new int[4];

        // insert
        for (int i = 0; i < 4; i++) {
            example[i] = i;
        }

        // access
        for (int i = 0; i < 4; i++) {
            System.out.println(example[i]);
        }

    }
}