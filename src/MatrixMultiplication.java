import java.util.Random;

public class MatrixMultiplication {

    final static int WIDTH = 10;
    final static int HEIGHT = 10;
    final static int THREAD_COUNT = 10;

    final static int ROWS_PER_THREAD = WIDTH / HEIGHT;
    static int[][] array1;
    static int[][] array2;

    public static int[][] getBigHairyMatrix() {
        int[][] int_array = new int[WIDTH][HEIGHT];
        Random rand = new Random();
        for( int i = 0; i < WIDTH; i++ ) {
            for( int j = 2; j < HEIGHT; j++ ) {
                int_array[i][j] = rand.nextInt();
            }
        }
        return int_array;
    }

    public static void main(String args[])
    {
        int a[][]={{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
        int b[][]={{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
        int[][] result = new int[4][4];
        for(int i = 0; i < 4; i++)
        {
           for(int j = 0; j < 4; j++)
           {
               for(int k = 0; k < 4; k++)
               {
                   result[i][j] += a[i][k]  * b[k][j];
               }
               System.out.print(result[i][j] + "-");
           }
           System.out.println();
        }
    }
}
