//answers to a, c, and d are in 5_12.txt

public class Leader {
    public static void main(String[] args) {
        int n = 7;  // number of people
        int m = 2;  // eliminate every m-th person
        
        // create circle  list with people 1 to n
        SimplifiedList<Integer> circle = new SimplifiedList<>();
        for (int i = 1; i <= n; i++) {
            circle.addLast(i);
        }
        
        // keep eliminating until only one person left
        for (int eliminated = 0; eliminated < n - 1; eliminated++) {
            // move people from front to back
            for (int i = 0; i < m - 1; i++) {
                Integer person = circle.removeFirst();
                circle.addLast(person);
            }
            
            // remove the m-th person
            Integer removedPerson = circle.removeFirst();
            System.out.print(removedPerson + " ");
        }
        
        // the last person remaining is the leader
        System.out.println("\nLeader: " + circle.removeFirst());
    }
}
