import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        WeightedGraph graph = new WeightedGraph(6);
        graph.addEdge(0,1, 4 );
        graph.addEdge(0,2, 5);
        graph.addEdge(2,4, 3 );
        graph.addEdge(2,1, 11);
        graph.addEdge(1,4,7);
        graph.addEdge(3,4, 13);
        graph.addEdge(1,3, 9);
        graph.addEdge(3,5, 2);
        graph.addEdge(4,5, 6);

        graph.dijkstra(0);
    }
}
