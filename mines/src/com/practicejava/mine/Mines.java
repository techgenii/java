package com.practicejava.mine;

public class Mines {

	static int rows = 3;
	static int columns = 4;
	
    // mine matrix
    static int in[][] = new int[rows][columns];

    private static boolean inBounds(int x, int y)
    {
    	// Check if position of the cell is within bounds
    	return 0 <= x && x < in.length && 0 <= y && y < in[x].length;
    }
		    
     private static int outCount(int x, int y)
	 {
    	int outCount = 0;               
        // Count -1 (*'s) in surrounding cells
        for(int r = -1; r <= 1; r++) {
                for(int c = -1; c <= 1; c++) {
                	int newx = x + r;
                    int newy = y + c;
                    if(inBounds(newx, newy)) {
                    	if(in[newx][newy] == -1)
                    		outCount++;
                    }
                }
        }
		return outCount;
	  }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int x = 0;
        int j = 0;

    	// Stores final mine information to output
        int out[][] = new int[rows][columns];

        // Initialize the input board
        for (x=0; x < rows; x++) {
            for (j=0; j < columns; j++) {
                in[x][j] = 0;
            }
        }
        
        // Set the mine areas
        in[0][0] = -1;
        in[1][2] = -1;
        in[2][1] = -1;
        
        
        // Compute the * for a mine or the number of adjacent mine-squares if the square does not contain a mine.
    	System.out.print("Output Mine Matrix\n");
        for (x=0; x < rows; x++){
        	for(j=0; j<columns; j++) {
        		// if there is a mine, then place the mine there
        		if (in[x][j] == -1) {
        			out[x][j] = -1;
        		}
        		// if there is not a mine, then compute the number of adjacent mine-squares
        		if (in[x][j] == 0) {
        			out[x][j] += outCount(x,j);
        		}
        		// output the mine-squares
        		System.out.print((out[x][j]== -1) ? "*" : out[x][j]);
        	}
        	System.out.print("\n");
        }
	}

}
