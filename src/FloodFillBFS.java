import java.util.LinkedList;

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}


public class FloodFillBFS {
    
    static void floodFillBFS(int img[][], int x, int y, int currCol, int newCol){
        int N = img.length;
        int M = img[0].length;
        boolean[][] visited = new boolean[N][M];
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(x,y));
        visited[x][y] = true;

        int[] deltaX = {1, 0, -1, 0}; int[] deltaY = {0, 1, 0, -1};

        while (!queue.isEmpty()){
            Pair p = queue.removeFirst();
            int currentX = p.first;
            int currentY = p.second;
            img[currentX][currentY] = newCol;
            System.out.println("removing... " + currentX + " " + currentY);
            for (int i =0; i<4; i++){
                int neigborX = currentX + deltaX[i]; int neigborY = currentY + deltaY[i];

                if (neigborX>=0 && neigborX<N && neigborY>=0 && neigborY<M &&
                        !visited[neigborX][neigborY] && img[neigborX][neigborY] == currCol ){
                    queue.addLast(new Pair(neigborX, neigborY));
                    visited[neigborX][neigborY] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int image [][] = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 4, y = 4, newCol = 5;
        int currentCol = image[x][y];
        floodFillBFS(image, x, y, currentCol, newCol);

        for (int i =0; i < image.length; i++){
            for (int j =0; j<image[0].length; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
