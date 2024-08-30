import java.util.Arrays;

public class TSP {
//    bruteforce approach to TSP

    static int minCostTour(int [][]dist, boolean []visited, int node, int count, int n){
//       source node is 0
        if (count == n){
            System.out.println(node);
            return dist[node][0];
        }
        visited[node] = true;
        int ans = Integer.MAX_VALUE;

        for (int i =0; i<n; i++){
            if (!visited[i]){
                int cost = dist[node][i] + minCostTour(dist, visited, i, count+1, n);
                ans = Math.min(cost, ans);
            }
        }
//        backtrack
        visited[node] = false;

        return ans;
    }

    public static void main(String[] args) {
        int dist[][] = {
                {0, 20, 42, 25},
                {20, 0, 30, 34},
                {42, 30, 0, 10},
                {25, 34, 10, 0},
        };

        int n = dist.length;
        boolean visited [] = new boolean[n];
        Arrays.fill(visited, false);
        System.out.println(minCostTour(dist,visited,0,1,4));
    }
}
