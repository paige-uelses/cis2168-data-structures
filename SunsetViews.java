import java.util.*;

public class SunsetViews {
    public List<Integer> sunsetViews(int[] buildings, String direction) {

        List<Integer> result = new ArrayList<>();
        Stack<Integer> sunsetStack = new Stack<>();

        int n = buildings.length;
        int currentMax = 0;

        // [3, 5, 4, 4, 3, 1, 3, 2]

        if (direction == "EAST"){
            for (int i = n-1; i >= 0; i--){
                if (buildings[i] > currentMax){
                    sunsetStack.push(i);
                    currentMax = buildings[i];
                }
            }

        while(!sunsetStack.isEmpty()){
            result.add(sunsetStack.pop());
        }

        } else if (direction == "WEST"){
            for (int i = 0; i < n; i++){
                if (buildings[i] > currentMax){
                    sunsetStack.push(i);
                    currentMax = buildings[i];
                }
            }

            Stack<Integer> temp = new Stack<>();
            while(!sunsetStack.isEmpty()){
                temp.push(sunsetStack.pop());
            }
            while(!temp.isEmpty()){
                result.add(temp.pop());
            }
        
        }
        return result;
    }

    //test
    public static void main(String[] args){
        SunsetViews s = new SunsetViews();
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};

        System.out.println(s.sunsetViews(buildings, "EAST"));
        System.out.println(s.sunsetViews(buildings, "WEST"));
    }
}


