//Exercise 11.5

import java.util.*;

public class SumQueue {
        public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 5; i++){
            queue.add(i);
        }
        System.out.println(queue); // [1, 2, 3, 4, 5]
        System.out.println(sum(queue)); // 15
        System.out.println(queue); // []
    }

    public static int sum(Queue<Integer> q){
        int sum = 0;
        int m = q.size();
        for (int i = 0; i < m; i++){
            int n = q.remove();
            sum += n;
        }
        return sum;
    }
}

/* 

to fix this i just made a variable m that stores the initial q.size()
as the upper limit rather than referring to a q.size() 
that decreases with each iteration

*/

