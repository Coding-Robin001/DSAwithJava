import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class GraphUsingAdjList {

    int V;
    List<Integer> adjList[];

    GraphUsingAdjList(int V){
        this.V = V;
        this.adjList = new LinkedList[V];
        for (int i = 0; i < V; i++)
        {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v, boolean undirected){
        adjList[u].add(v);

        if (undirected)
            adjList[v].add(u);
    }

    boolean cycleDetectorHelper(int node, boolean[] visited,int parent) {
        visited[node] = true;

        Iterator<Integer> it = adjList[node].listIterator();
        while (it.hasNext()){
            int nextEl = it.next();
            if (!visited[nextEl]){
                boolean cycleDetected = cycleDetectorHelper(nextEl, visited, node);
                if (cycleDetected)
                    return true;
            }

//            backedge detection happens here
            if (nextEl != parent){
                return true;
            }
        }
        return false;
    }

    boolean cycleDetector(){
        boolean visited[] = new boolean[V];
        return cycleDetectorHelper(0, visited, -1);
    }


    void DFShelper(int node, boolean[] visited){
//        System.out.println(node);
        visited[node] = true;
//        System.out.println(Arrays.toString(visited));

        Iterator<Integer> it = adjList[node].listIterator();
        System.out.println(it.next());
        while (it.hasNext()){
            int nextEl = it.next();
            if (!visited[nextEl]){
                DFShelper(nextEl, visited);
            }
        }
    }

//    assuming a single component in graph
    void DFS(int node){
        boolean visited[] = new boolean[V];
        DFShelper(node, visited);
    }

    void BFS(int src){
        boolean visited[] = new boolean[V];
        int distance [] = new int[V];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.addLast(src);
        distance[src] = 0;
        visited[src] = true;

        while (!queue.isEmpty()){
            int node = queue.removeFirst();
            System.out.println(node);

            Iterator<Integer> it = adjList[node].listIterator();
            while (it.hasNext()){
                int nextEl = it.next();
                if (!visited[nextEl]){
                    visited[nextEl] = true;
                    distance[nextEl] = 1 + distance[node];
                    queue.addLast(nextEl);
                }
            }
        }

        for (int i = 0; i < V; i++){
            System.out.println("Node " + i + " Distance " +  distance[i]);
        }

    }


    int BFSShortestPath(int src, int dest) {
        boolean visited[] = new boolean[V];
        int parent[] = new int[V];
        int distance[] = new int[V];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.addLast(src);
        parent[src] = -1;
        distance[src] = 0;
        visited[src] = true;

        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            System.out.println(node);

            Iterator<Integer> it = adjList[node].listIterator();
            while (it.hasNext()) {
                int nextEl = it.next();
                if (!visited[nextEl]) {
                    visited[nextEl] = true;
                    parent[nextEl] = node;
                    distance[nextEl] = 1 + distance[node];
                    queue.addLast(nextEl);
                }
            }
        }

        int temp = dest;
        while (parent[temp] != -1 ){
            System.out.println(temp);
            temp = parent[temp];
        }
        return distance[dest];

    }

    @Override
    public String toString() {
        return "GraphUsingAdjList{" +
                "V=" + V +
                ", adjList=" + Arrays.deepToString(adjList) +
                '}';
    }

//    backtracking function
    void topologicalSortHelper(int node, boolean visited[], List<Integer> output){
        visited[node] = true;
        Iterator<Integer> it = adjList[node].listIterator();
        while (it.hasNext()){
            int nbr = it.next();
            if (!visited[nbr]){
                topologicalSortHelper(nbr, visited, output);
            }
        }
        output.add(node);
    }

    List<Integer> topologicalSort(){
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        List <Integer> output = new ArrayList<>();

        for (int i=0; i<V; i++){
            if (!visited[i]){
                topologicalSortHelper(i, visited, output);
            }
        }
        Collections.reverse(output);
        return output;
    }

    List<Integer> topologicalSortBFS(){
        int indegree [] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> output = new ArrayList<>();
        Arrays.fill(indegree, 0);

        for (int i = 0; i < V; i++){
            Iterator<Integer> it = adjList[i].listIterator();
            while (it.hasNext()){
                int nbr = it.next();
                indegree[nbr]++;
            }
        }

        for (int i =0; i<V; i++){
            if (indegree[i] == 0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int node = q.poll();
            output.add(node);
            Iterator<Integer> it = adjList[node].listIterator();
            while (it.hasNext()){
                int nbr = it.next();
                indegree[nbr]--;
                if (indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        return output;
    }


}



