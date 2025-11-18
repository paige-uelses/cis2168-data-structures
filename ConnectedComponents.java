import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {

        // YOUR CODE HERE
        boolean[] marked = new boolean[adj.length];
        int components = 0;

        for (int v = 0; v < adj.length; v++){
            if (!marked[v]){
                dfs(adj, v, marked);
                components++;
            }
        }

        return components;
        
    }

    // feel free to add a helper method to make your code cleaner & modular.

    private static void dfs(ArrayList<Integer>[] adj, int v, boolean[] marked){
        marked[v] = true;

        for (int w : adj[v]){
            if (marked[w] == false){
                dfs(adj, w, marked);
            }
        }
    }


    public static void main(String[] args) {
        //In in = new In("G.txt");
        // In in = new In("G2-1.txt");
        // In in = new In("G2-2.txt");
        In in = new In("G2-3.txt");
        // In in = new In("mediumG.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = in.readInt();
            y = in.readInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
            // for mediumG.txt (fixes index)
            // adj[x].add(y);
            // adj[y].add(x);
        }
        System.out.println(numberOfComponents(adj));
    }
}

