import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

class PairW{
    public int dist;
    public int node;

    public PairW(int d, int n){
        dist=d;
        node=n;
    }
    @Override
    public String toString() {
        return "Pairs{" +
                "dist=" + dist +
                ", node=" + node +
                '}';
    }
}

public class WeightedGraph {
    int V;
    List<PairW> adjList[];

    public WeightedGraph(int V){
        this.V = V;
        this.adjList = new LinkedList[V];
        for (int i =0; i<V; i++){
            this.adjList[i] = new LinkedList();
        }
    }
    void addEdge(int u, int v, int wt){
        adjList[u].add(new PairW(wt, v));
        adjList[v].add(new PairW(wt, u));
    }

    @Override
    public String toString() {
        return "WeightedGraph{" +
                "V=" + V +
                ", adjList=" + Arrays.toString(adjList) +
                '}';
    }


    void dijkstra(int src){
        TreeSet<PairW> set = new TreeSet<>((PairW p1, PairW p2)->(p1.dist - p2.dist));
        int dist [] = new int[V]; Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        set.add(new PairW(0, src));
        while (!set.isEmpty()){
            PairW frontPair = set.pollFirst();
            int currNode = frontPair.node;
            int currDist = dist[currNode];
            for (PairW nbrPair : adjList[currNode]){
                int nbrNode = nbrPair.node;
                int nbrDist = nbrPair.dist;
                if (currDist + nbrDist < dist[nbrNode]){
                    set.remove(new PairW(dist[nbrNode], nbrNode));
                    dist[nbrNode] = currDist + nbrDist;
                    set.add(new PairW(dist[nbrNode], nbrNode));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
