public class floodFill {

    static void floodFillDFS(int img[][], int x, int y, int currColor, int newColor){
        int N = img.length;
        int M = img[0].length;
        if (x<0 || x>=N || y<0 || y>=M){
            return;
        }
        if (img[x][y] != currColor){
            return;
        }
        if (img[x][y] == currColor){
            return;
        }
        img[x][y] = newColor;
        floodFillDFS(img, x+1, y, currColor, newColor);
        floodFillDFS(img, x, y+1, currColor, newColor);
        floodFillDFS(img, x-1, y, currColor, newColor);
        floodFillDFS(img, x, y-1, currColor, newColor);
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
        int x = 1, y = 2, newCol = 5;
        int currentCol = image[x][y];
        floodFillDFS(image, x, y, currentCol, newCol);

        for (int i =0; i < image.length; i++){
            for (int j =0; j<image[0].length; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

}
