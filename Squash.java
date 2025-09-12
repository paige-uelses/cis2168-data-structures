public class Squash {
    public void squash(int[] squash_array) {

        int write = 0;

        for (int read = 1; read < squash_array.length; read++) {
            if (squash_array[read] != squash_array[write]) {
                write++;
                squash_array[write] = squash_array[read];
            } 
        }

        //changes end of array into -1
        for (int k = write + 1; k < squash_array.length; k++) {
            squash_array[k] = -1;
        }
    }
}    
/////goal
// Given: [ 0 0 0 0 1 1 0 0 0 7 7 7 1 1 0 ]
//Output: [ 0 1 0 7 1 0 -1 -1 -1 -1 -1 -1 -1 -1 -1 ]