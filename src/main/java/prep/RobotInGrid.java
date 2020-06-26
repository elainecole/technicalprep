package prep;

/**
 * 8.2 Robot in a Grid
 * 6/8/20
 * int rows, cols = some number; 
 // false if “off limits” 
// determine if there is a path from top left to bottom right 
// to get to bottom right (last), need to get to first to last, second to last, third to last, … second 

 */
public class RobotInGrid {
    int nRows, nCols; 
    int[][] grid = new int[nRows][nCols];

    public static void main(String[] args) {
        System.out.println("Initializing Technical Prep: Robots in a Grid");
    }
    
	public void Mark(int r, int c, int step) {
		// can we make a step here?
		if (c < nCols && r < nRows && grid[r][c] == 0)
		{
			grid[r][c] = step;
			// try next step: right first, then down
			Mark(r, c+1, step+1);
			Mark(r+1, c, step+1);
		}
	}

    boolean pathExists(int r, int c) {
        // for each position: (start at 0, 0)
        if (r == nRows && c == nCols) { // base case: hit bottom right cell
        // RECURSION: can I go right or down from this position? 
        // Etc. until it is the last cell 
        // (return true at last cell)
            return true; 
        }
        // 	can I go right or down? 
        if (grid[r + 1][c] == -1) {
            // can’t go down; try right 
        if (grid[r][c + 1] == -1) {
                // can’t go right; nowhere to go
        return false; 
        } else {
            // can go right
            pathExists(r, c + 1); 
        }
        } else {
            // can go down 
            pathExists(r + 1, c); 
        }
        return false;
    }
}