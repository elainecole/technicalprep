package prep; 

/**
 * 10.9 Sorted Matrix Search
 * 7/20/20
 * given M x N matrix, each row and col sorted in increasing order, find an element 
 */

public class SortedMatrixSearch {
    public static void main(String[] args) {
        System.out.println("Sorted Matrix Search"); 
        int[][] arr = {{ 1,   2,   3,  40}, 
                       { 5,   6,   7,  80},
                       { 9,  10,  11, 120},
                       {13,  14, 150, 160},
                       {17, 180, 190, 200}};

        int[] result = sortedSearch(arr, 20); 
        System.out.println("found (" + result[0] + ", " + result[1] + ")");
    }

    public static int[] sortedSearch(int[][] arr, int el) {
        // vars to track: 
        // min_row, max_row, min_col, max_col
        int minRow = 0;
        int minCol = 0; 
        int maxRow = arr.length - 1;
        int maxCol = arr[0].length - 1; 
        int[] result = new int[2]; 
        // while row vars aren't the same and cols aren't the same 
        while (!(minRow >= maxRow) && !(minCol >= maxCol)) {
            // scan across minRow
           for (int c = minCol; c < maxCol; c++) {
                // if in row
                if (arr[minRow][c] == el) {
                    result[0] = minRow; 
                    result[1] = c; 
                    return result; 
               } else if (arr[minRow][c] > el) {
                    // know not in row 
                    maxCol = c - 1;
                    break; 
               } else {
                   // less than 
                    continue; 
               }
           }
           // not in row; 
           minRow++; 
           System.out.println("minRow: " + minRow + " maxRow: " + maxRow + " minCol: " + minCol + " maxCol: " + maxCol);

           for (int r = minRow; r < maxRow; r++) {
                // if in row
                if (arr[r][minCol] == el) {
                    result[0] = r; 
                    result[1] = minCol; 
                    return result; 
                } else if (arr[r][minCol] > el) {
                        // know not in row 
                        maxRow = r - 1;
                        break; 
                } else {
                    // less than 
                        continue; 
                }
            }
       // not in col; 
       minCol++; 
       System.out.println("minRow: " + minRow + " maxRow: " + maxRow + " minCol: " + minCol + " maxCol: " + maxCol);
        }
        return result; 
    }
}