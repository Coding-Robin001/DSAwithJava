import java.util.Arrays;
import java.util.Scanner;

public class GraphRunner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int V, src, dest, snakes, ladders;
        System.out.println("Enter number of Vertices, src, dest");

        V = sc.nextInt();
        src = sc.nextInt();
        dest = sc.nextInt();
        int board[] = new int[V+1];

        System.out.println("Enter number of snakes and snakes position(H > T)");
        snakes = sc.nextInt();
        for (int i = 0; 1 < snakes; i++){
            int head, tail;
            head = sc.nextInt();
            tail = sc.nextInt();
            board[head] = (tail - head);
//            15-3
        }

        System.out.println("Enter number of ladders and ladder position(B > T)");
        ladders = sc.nextInt();
        for (int i = 0; 1 < ladders; i++){
            int bottom, top;
            bottom = sc.nextInt();
            top = sc.nextInt();
            board[top] = (bottom - top);
        }

        System.out.println(Arrays.toString(board));

        GraphUsingAdjList graph = new GraphUsingAdjList(V+1);
        for (int i = 1; i<dest; i++){
            for (int dice = 1; dice <= 6; dice++ ){
                int j = i + dice;

                if (j<dest){
                    j = j + board[j];
                    if (j<=dest){
                        graph.addEdge(i, j, false);
                    }
                }
            }
        }

    }
}
