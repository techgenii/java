import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: barbarabickham
 * Date: 7/20/13
 * Time: 9:28 PM
 */
public class setRowColZero {

    // In an MxN matrix, if an element is 0, then entire row and column are set to 0
    // Speed: O(n^2)
    // Space: O(n)
    public static void setRowColZero(int[][] matrix) {
        int row_len = matrix.length;
        int col_len = matrix[0].length;
        int i, j, rowset, colset;

        // store the row and column index with value zero
        rowset = colset = 0;
        for (i=0; i < row_len; i++) {
            for (j=0; j < col_len; j++) {
                if (matrix[i][j] == 0) {
                    rowset |= (1 << i);
                    colset |= (1 << j);
                }
            }
        }

        // set the matrix[i][j] to zero if either row[i] == 0 or col[j] == 0
        for (i=0; i < row_len; i++)   {
            for (j=0; j < col_len; j++) {
                if (  ((rowset & (1 << i)) > 0) || ((colset & (1 << j)) > 0)  ) {
                    matrix[i][j]  = 0;
                }
            }
        }

    }


    /**
     * @param args command line args
     */
    public static void main(String[] args) {
        int[][] matrix = {
                 {2,3,4,5},
                 {3,4,1,7},
                 {4,5,8,88},
                 {5,9,1,6},
                 {7,8,99,38},
                 {2,1,6,72},
                 {6,10,25,0}
        } ;

        int rows = matrix.length;
        System.out.println("--- Orig Matrix ---");
        for (int i=0; i<rows; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        // setRowColZero calls
        setRowColZero(matrix);

        rows = matrix.length;
        System.out.println("--- New Matrix ---");
        for (int i=0; i<rows; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
