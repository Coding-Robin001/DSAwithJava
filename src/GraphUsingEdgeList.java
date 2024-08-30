import java.util.LinkedList;
import java.util.List;

class Edge{
    int u;
    int v;
    int wt;

    Edge(int u, int v, int wt){
        this.u = u;
        this.v= v;
        this.wt = wt;
    }

    @Override
    public String toString (){
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                ", wt=" + wt +
                '}';
    }
}

public class GraphUsingEdgeList {
    int vertices;
    List<Edge> l;

    GraphUsingEdgeList(int v){
        this.vertices = v;
        l = new LinkedList<>();
    }


    void addEdge(int u, int v, int wt ){
        l.add(new Edge(u,v,wt));

    }

    @Override
    public String toString() {
        return "GraphUsingEdgeList{" +
                "vertices=" + vertices +
                ", l=" + l +
                '}';
    }
}
