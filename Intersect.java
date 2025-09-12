
import java.util.ArrayList;

public class Intersect {
    public ArrayList<Integer> intersect(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int idx_i = 0;
        int idx_j = 0;

        while (idx_i < arrayList1.size() && idx_j < arrayList2.size()) {
            int value1 = arrayList1.get(idx_i);
            int value2 = arrayList2.get(idx_j);

            if (value1 == value2) {
                result.add(value1);
                idx_i++;
                idx_j++;
            } else if (value1 < value2) {
                idx_i++;
            } else {
                idx_j++;
            }
        }

        return result;
    }
}


