package conwaygame;
import java.util.ArrayList;
/**
 * Conway's Game of Life Class holds various methods that will
 * progress the state of the game's board through it's many iterations/generations.
 *
 * Rules 
 * Alive cells with 0-1 neighbors die of loneliness.
 * Alive cells with >=4 neighbors die of overpopulation.
 * Alive cells with 2-3 neighbors survive.
 * Dead cells with exactly 3 neighbors become alive by reproduction.

 * @author Seth Kelley 
 * @author Maxwell Goldberg
 */
public class GameOfLife {

    // Instance variables
    private static final boolean ALIVE = true;
    private static final boolean  DEAD = false;

    private boolean[][] grid;    // The board has the current generation of cells
    private int totalAliveCells; // Total number of alive cells in the grid (board)

    /**
    * Default Constructor which creates a small 5x5 grid with five alive cells.
    * This variation does not exceed bounds and dies off after four iterations.
    */

    public GameOfLife() {
        grid = new boolean[5][5];
        totalAliveCells = 5;
        grid[1][1] = ALIVE;
        grid[1][3] = ALIVE;
        grid[2][2] = ALIVE;
        grid[3][2] = ALIVE;
        grid[3][3] = ALIVE;
    }

    /**
    * Constructor used that will take in values to create a grid with a given number
    * of alive cells
    * @param file is the input file with the initial game pattern formatted as follows:
    * An integer representing the number of grid rows, say r
    * An integer representing the number of grid columns, say c
    * Number of r lines, each containing c true or false values (true denotes an ALIVE cell)
    */
    public GameOfLife (String file) {

        // NEW CODE
            StdIn.setFile(file);
            int row = StdIn.readInt();
            int col = StdIn.readInt();
            grid = new boolean[row][col];
//read file and populate array saying T or F//
            for (int i = 0; i< grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = StdIn.readBoolean();
                }
            }
        // NEW CODE
    }

    /**
     * Returns grid
     * @return boolean[][] for current grid
     */
    public boolean[][] getGrid () {
        return grid; 
    }
    
    /**
     * Returns totalAliveCells
     * @return int for total number of alive cells in grid
     */
    public int getTotalAliveCells () {
        return totalAliveCells;
    }

    /**
     * Returns the status of the cell at (row,col): ALIVE or DEAD
     * @param row row position of the cell
     * @param col column position of the cell
     * @return true or false value "ALIVE" or "DEAD" (state of the cell)
     */
    public boolean getCellState (int row, int col) {

        // CAVE Reviewed Code
       //check if cell is alive, not whole entire thing//
       if(grid[row][col]== true){
        return true; // northCoorddate this line, provided so that code compiles
    
    } else {
        return false;
        }
    }
    // CAVE Reviewed Code

    /**
     * Returns true if there are any alive cells in the grid
     * @return true if there is at least one cell alive, otherwise returns false
     */
    public boolean isAlive () {

       // NEW CODE
 //run through each coordinate of the 2d array//
   //create temporary boolean//
   //if cell is alive, boolean = true//
   //return boolean //

 for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid.length; j++) {
        if(grid[i][j] = true) {
            return true;
        }
    }  
}
    return false; // northCoorddate this line, provided so that code compiles
}

    /**
     * Determines the number of alive cells around a given cell.
     * Each cell has 8 neighbor cells which are the cells that are 
     * horizontally, vertically, or diagonally adjacent.
     * 
     * @param col column position of the cell
     * @param row row position of the cell
     * @return neighboringCells, the number of alive cells (at most 8).
     */
    public int numOfAliveNeighbors (int row, int col) {

        // NEW CODE
        int aliveNeighbors = 0;

        int leftCoord = col - 1;
        int rightCoord = col + 1;
        int northCoord = row - 1;
        int southCoord = row + 1;

        if(leftCoord < 0){
            leftCoord = grid[0].length - 1;
        }
        if(rightCoord > grid[0].length - 1){
            rightCoord = 0;
        }
        if(northCoord < 0){
            northCoord = grid.length - 1;
        }
        if(southCoord > grid.length - 1){
            southCoord = 0;
        }


        // if(row < 0){
        //     row = grid.length-1; 
        // }
        // if((row+1)<grid.length && (col+1)<grid[0].length){
            if(grid[northCoord][leftCoord]==true){
                aliveNeighbors++;
            }
            if(grid[northCoord][col]==true){
                aliveNeighbors++;
            }
            if(grid[northCoord][rightCoord]==true){
                aliveNeighbors++;
            }

            if(grid[southCoord][leftCoord]==true){
                aliveNeighbors++;
            }
            if(grid[southCoord][col]==true){
                aliveNeighbors++;
            }
            if(grid[southCoord][rightCoord]==true){
                aliveNeighbors++;
            }
        
            if(grid[row][leftCoord]==true){
                aliveNeighbors++;
            }
            if(grid[row][rightCoord]==true){
                aliveNeighbors++;
            }
        

        // if((row+1)<grid.length && (col-1)<grid[0].length){
            
        
        return aliveNeighbors; // northCoorddate this line, provided so that code compiles
    }
    // NEW CODE

    /**
     * Creates a new grid with the next generation of the current grid using 
     * the rules for Conway's Game of Life.
     * 
     * @return boolean[][] of new grid (this is a new 2D array)
     */
    public boolean[][] computeNewGrid () {

        boolean[][] newGrid=new boolean[grid.length][grid[0].length];

        //creating new state, returning that as new grid//
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(numOfAliveNeighbors(i,j) == 3 || 
                (grid[i][j]) && 
                numOfAliveNeighbors(i,j) == 2) 
                {
                    newGrid[i][j] = ALIVE;
                }
                else 
                {
                    if ((!grid[i][j]) && 
                    numOfAliveNeighbors(i,j) == 3){
                        newGrid[i][j] = ALIVE;
                    }
                }
            }

        }
    return newGrid;
}

//if alive cell has 0 or 1 neighbors it dies
//if alive cell has 2 or 3 nieghbors it lives
//if alive cell has 4 or more it dies
//if alive has 3 exactly it becomes alive

//3 conditons for cell is alive

//if grid is alive
//if num alive neighbors == 3

//if alive and has 2 or 3 neighbors
//if dead and 3 neighors, then ALIVE




    /**
     * northCoordinates the current grid (the grid instance variable) with the grid denoting
     * the next generation of cells computed by computeNewGrid().
     * 
     * northCoorddates totalAliveCells instance variable
     */ 

    public void nextGeneration () {
        // NEW CODE
//only northCoorddating from previous grid//
//set old grid == new grid//
        grid = computeNewGrid();
        int x = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j])
                x++;
        // NEW CODE
        }
    }
    totalAliveCells = x;
}
    /**
     * northCoorddates the current grid with the grid computed after multiple (n) generations. 
     * @param n number of iterations that the grid will go through to compute a new grid
     */
    public void nextGeneration (int n) {

        // NEW CODE
        //fast forwarding by n generations//
        //northCoorddating by n number of times//
       //* */ computeNewGrid();
        for (int x = 0; x < n; x++){
            nextGeneration();
        }
    }


    /**
     * Determines the number of separate cell communities in the grid
     * @return the number of communities in the grid, communities can be formed from edges
     */
    
   
public int numOfCommunities() {
    ArrayList<Integer> tracker = new ArrayList<Integer>();
    WeightedQuickUnionUF quickU = new WeightedQuickUnionUF(grid.length, grid[0].length);

    for (int i = 0; i < grid.length; i++){
        for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j]){
                    int aliveNeighbors = numOfAliveNeighbors(i,j);
                    if (aliveNeighbors > 0) {
                        int leftCoord = j - 1;
                        int rightCoord = j + 1;
                        int northCoord = i - 1;
                        int southCoord = i + 1;
                
                        if(leftCoord < 0){
                            leftCoord = grid[0].length - 1;
                        }
                        if(rightCoord > grid[0].length - 1){
                            rightCoord = 0;
                        }
                        if(northCoord < 0){
                            northCoord = grid.length - 1;
                        }
                        if(southCoord > grid.length - 1){
                            southCoord = 0;
                        }

                        //NORTH
                        if(grid[northCoord][leftCoord]==true){
                            quickU.union(i, j, northCoord, leftCoord);
                        }
                        if(grid[northCoord][j]==true){
                            quickU.union(i, j, northCoord, j);
                        }
                        if(grid[northCoord][rightCoord]==true){
                            quickU.union(i, j, northCoord, rightCoord);
                        }
        
                        //South
                        if(grid[southCoord][leftCoord]==true){
                            quickU.union(i, j, southCoord, leftCoord);
                        }
                        if(grid[southCoord][j]==true){
                            quickU.union(i, j, southCoord, j);
                        }
                        if(grid[southCoord][rightCoord]==true){
                            quickU.union(i, j, southCoord, rightCoord);
                        }

                        //LEFT AND RIGHT
                        if(grid[i][rightCoord]==true){
                            quickU.union(i, j, i, rightCoord);
                        }
                        if(grid[i][leftCoord]==true){
                            quickU.union(i, j, i, leftCoord);
                        }
                    
                    
                        
                    }
                }
                else {
                    quickU.union(i, j, 0, 0);
                }
            }
        }
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
            if (quickU.find(i,j) !=1){
        if(!tracker.contains(quickU.find(i,j)))
        tracker.add(quickU.find(i,j));
                }
            }
        }
    return tracker.size();
    }
}
