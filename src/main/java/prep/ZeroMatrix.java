package prep;

public class ZeroMatrix {
    
    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep");
        int m = 20; 
        int n = 25; 
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (Math.random() * 100 < 2) ? 0 : i + j; 
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(); 
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", matrix[i][j]); 
            }
        }
        System.out.println(); 
        System.out.println("Zero Matrix: " + zeroMatrix(matrix, m, n));
        for (int i = 0; i < m; i++) {
            System.out.println(); 
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", matrix[i][j]); 
            }
        }
    }

    static int[][] zeroMatrix(int[][] matrix, int m, int n) {
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        // walk through matrix, marking zeros into arrays
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    rows[r] = true; 
                    cols[c] = true; 
                } // else do nothing 
            }
        }

        // zero entire rows and cols given arrays
        for (int r = 0; r < m; r++) {
            if (rows[r]) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = 0;
                }
            }
        }
        for (int c = 0; c < n; c++) {
            if (cols[c]) {
                for (int r = 0; r < m; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
        return matrix; 
    }
}