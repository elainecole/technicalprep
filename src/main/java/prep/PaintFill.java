package prep;

/**
 * 8.10 Paint Fill 
 * 7/27/20
 */
public class PaintFill {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 1, 2, 3},
                       {0, 2, 2, 2, 1},
                       {1, 2, 3, 2, 1},
                       {3, 3, 3, 3, 3},
                       {0, 2, 1, 1, 3}};
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println(); 
        }
        System.out.println("\nPaint Fill: "); 
        callPaintFill(arr, 1, 2, 5);
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println(); 
        }
    }

    static void callPaintFill(int[][] arr, int x, int y, int newVal) {
        int origVal = arr[x][y];
        paintFill(arr, x, y, origVal, newVal);
    }
    static void paintFill(int[][] arr, int x, int y, int origVal, int newVal) {
        if (arr[x][y] == origVal) {
            arr[x][y] = newVal; 
            // x - 1, y
            if (x - 1 >= 0) {
                paintFill(arr, x - 1, y, origVal, newVal); 
            }
            // x + 1, y
            if (x + 1 <= arr.length) {
                paintFill(arr, x + 1, y, origVal, newVal); 
            }
            // x, y - 1
            if (y - 1 >= 0) {
                paintFill(arr, x, y - 1, origVal, newVal); 
            }
            // x, y + 1
            if (y + 1 <= arr[0].length) {
                paintFill(arr, x, y + 1, origVal, newVal); 
            }
        }
        return; 
    }
}