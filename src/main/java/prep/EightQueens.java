package prep; 

/**
 * 8.12 Eight Queens
 * 8/4/20
 */
public class EightQueens {
    static int numSolutions = 0;

    public static void main(String[] args) {
        boolean[][] arr = new boolean[8][8];
        for (boolean[] row : arr) {
            for (int c = 0; c < row.length; c++) {
                row[c] = false;
            }
        }
        recursingQueens(0, arr);
    }

    static boolean isValidPosition(int row, int col, boolean[][] arr) {
        // check each val in row
        for (int c = 0; c < arr[row].length; c++) {
            if (arr[row][c]) {
                return false;
            }
        }
        // check each val in col
        for (int r = 0; r < arr.length; r++) {
            if (arr[r][col]) {
                return false;
            }
        }
        // check each val in diagonal
        for (int r = 0; r < arr[0].length; r++) {
            int cSmaller = 0; 
            int cGreater = 0; 
                // two vals for each row
            if (r < row) {
                cSmaller = col - (row - r); 
                cGreater = col + (row - r); 

            } else if (r > row) {
                cSmaller = col - (r - row); 
                cGreater = col + (r - row); 
            } else {
                // ignore r = row
                continue; 
            }
            if (cSmaller >= 0) {
                // within box; check val 
                if (arr[r][cSmaller]) {
                    return false; 
                }                    
            }
            if (cGreater <= 7) {
                // within box; check val
                if (arr[r][cGreater]) {
                    return false; 
                }
            }
        }
        return true; 
    }

    static void recursingQueens(int queensDone, boolean[][] arr) {
        if (queensDone == arr.length) {
            // success
            printBoard(arr);
            return;
        }
        for (int c = 0; c < arr[0].length; c++) {
            // try each pos in row
            if (isValidPosition(queensDone, c, arr)) {
                arr[queensDone][c] = true;
                // mark rest of row, col and diag
                recursingQueens(queensDone + 1, arr);
                arr[queensDone][c] = false;
            }

        }
        // failure
        return;
    }

    static void printBoard(boolean[][] arr) {
        numSolutions++;
        System.out.println("Board Solution: " + numSolutions); 
        for(boolean[] row : arr) {
            for (boolean c : row) {
                if (c) {
                System.out.print("Q ");
                } else {
                    System.out.print(". "); 
                }
            }
            System.out.println(); 
        }
    }
}