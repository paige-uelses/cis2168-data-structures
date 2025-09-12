import java.util.ArrayList;
import java.util.List;

public class ZigZag {
    public static List<Integer> zigzag(List<List<Integer>> array) {
        List<Integer> result = new ArrayList<>();
        
        //how big is the 2d array
        int m = array.size();
        int n = array.get(0).size();

        //current index positions
        int row_idx = 0;
        int column_idx = 0;

        //go through 2d array
        boolean goingDown = true;

        while (result.size() < m*n) {
            result.add(array.get(row_idx).get(column_idx));
            //going down
            if (goingDown) {
                //case 1 - reaches bottom border
                if (row_idx == m-1) {
                    column_idx++;
                    goingDown = false;
                //case 2 - reaches left border
                } else if (column_idx == 0) {
                    row_idx++;
                    goingDown = false;
                //case 3 - not at a border
                } else { 
                    row_idx++;
                    column_idx--;
                }

            } else { //going up
                //case 1 - reaches right border
                if (column_idx == n-1) {
                    row_idx++;
                    goingDown = true;
                //case 2 - reaches top border
                } else if (row_idx == 0) {
                    column_idx++;
                    goingDown = true;
                //case 3 - not at a border
                } else {
                    row_idx--;
                    column_idx++;
                }

               
            }
        }
        return result;
    }
}