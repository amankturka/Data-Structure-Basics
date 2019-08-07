/*
 * Binary Search
 * 
 * Given: Sorted array
 * 
 * Search in sorted array by repeatedly dividing the search interval in half.
 */

class BinarySearch {
    int binarySearch(int arr[], int l_index, int r_index, int target) {
        int middle;
        while (l_index <= r_index) {
            middle = (l_index + r_index) / 2;
            if (arr[middle] == target)
                return middle;
            else if (arr[middle] < target)
                l_index = middle + 1;
            else
                r_index = middle - 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        BinarySearch search = new BinarySearch();
        // int arr[] = new int[5];
        int arr[] = { 1, 2, 3, 4, 5, 7, 8, 10, 40 };
        int result = search.binarySearch(arr, 0, arr.length - 1, 10);
        System.out.println(result);
    }

}