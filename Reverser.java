//Exercise 2_7

public class Reverser {
    public int[] reverse(int[] nums)  
    {
        int idx_i = 0;
        int idx_j = nums.length - 1;
        while (idx_i < idx_j) {
            exch(nums, idx_i, idx_j);
            idx_i++;
            idx_j--;
        }
        return nums; 
    }

// example nums = [2, 1, 6, 8, 8, 4]
    // idx        [0, 1, 2, 3, 4, 5]   
               //  i              j

    //given
    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
