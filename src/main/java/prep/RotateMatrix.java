package prep;

/**
 * 1.7 Rotate Matrix
 * 6/18/20
 */
public class RotateMatrix {
    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep");
        int n = 5; 
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = (i + 1) + (j * n); 
                System.out.print(m[i][j] + " "); 
            }
            System.out.println(); 
        }
        System.out.println("Rotate Matrix:"); 
        m = rotate(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + " "); 
            }
            System.out.println(); 
        }
    }
    static int[][] rotate(int n, int[][] matrix) {
        for (int r = 0; r < n / 2; r++) {
            for (int c = r; c < n - 1 - r; c++) {
                moveSquare(r, c, n, matrix); 
            }
        }
        return matrix; 
    }
    
    
    static void moveSquare(int x, int y, int n, int[][] matrix) {
        int temp = matrix[x][y];		// save upper left
        n--;
        matrix[x][y] = matrix[y][n - x];
        matrix[y][n - x] = matrix[n - x][n - y];
        matrix[n - x][n - y] = matrix[n - y][x];
        matrix[n - y][x] = temp;
    }
    
}