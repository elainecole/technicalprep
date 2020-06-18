package prep;

/**
 * 8.3 Magic Index
 * 6/11/20
 */
public class MagicIndex {
    public static void main(String[] args) throws Exception {
        System.out.println("Initializing Technical Prep");
        int[] arr = new int[10];
        for (int i = 0; i < 5; i++) {
            arr[i] = i - 1; 
        }
        arr[6] = 6; 
        for (int i = 7; i < arr.length - 1; i++) {
            arr[i] = i + 1; 
        }
        System.out.println("Magic Index: " + magicIndex(arr, 0, arr.length - 1));
    }

    static int magicIndex(int[] a, int start, int end) {
        if (end - start <= 2) { // base case: even # size array
            if (a[start] == start) {
                return start; 
            }
            if (a[end] == end) {
                return end; 
            } 
            return -1; 
        }
        // else recurse
        int middle = (end - start) / 2 + start;
        // three parts:
        // [start, middle-1];  middle;  [middle+1, end]
        if (middle == a[middle]) {
            return middle; 
        }
        if (middle < a[middle]) { // is middle a match
            return magicIndex(a, start, middle - 1); 
        } 
        return magicIndex(a, middle + 1, end); 
    }
}