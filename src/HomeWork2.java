import java.util.Arrays;
import java.util.Random;

public class HomeWork2 {
    final static int HEIGHT = 100; //:)
    final static int WIDTH = 100; //:)

    final static int THREAD = 10;
    final static int ROWS_PER_THREAD = WIDTH / THREAD;
    final static int RANDOM_BOUND = HEIGHT*WIDTH + WIDTH/HEIGHT + THREAD - ROWS_PER_THREAD + (new Random().nextInt(1)); //:)

    static int[][] array1;
    static int[][] array2;






    private static class WorkerThread extends Thread
    {
        int[][] arrayPart;
        int[][] resultPart = new int[ROWS_PER_THREAD][WIDTH];
        public int s;

        //public WorkerThread(int[][] array, int st, int sp){this.array = array; this.st = st; this.sp = sp;}
        public  WorkerThread(int [][] arrayPart){this.arrayPart = arrayPart;}

        public void run()
        {
            for (int y = 0; y < ROWS_PER_THREAD; y++)
            {
                for (int u = 0; u < HEIGHT; u++)
                {
                    for (int s = 0; s < WIDTH; s++)
                    {
                        resultPart[y][u] += arrayPart[y][s] * array2[s][u];
                    }
                }
            }
        }
        public  int[][] getResult()
        {
            return resultPart;
        }
    }

    public static int[][] getBigHairyMatrix()
    {
        int[][] int_array = new int[WIDTH][HEIGHT];
        Random rand = new Random();
        for (int u = 0; u < WIDTH; u++)
        {
            for (int f = 0; f < HEIGHT; f++)
            {
                int_array[u][f] = rand.nextInt(RANDOM_BOUND);
            }
        }
        return int_array;
    }

    public static void main(String[] args) { WorkerThread[] threads = new WorkerThread[THREAD];
        array1 = getBigHairyMatrix();
        array2 = getBigHairyMatrix();
        int[][] arrayPart = new int[ROWS_PER_THREAD][WIDTH];
        int[][] result = new int[HEIGHT][WIDTH];
        for (int c = 0; c < THREAD; c++)
        {
            for (int a = 0; a < ROWS_PER_THREAD; a++)
            {
                    arrayPart[a] = array1[c * ROWS_PER_THREAD + a];
            }

            threads[c] = new WorkerThread(arrayPart);
            threads[c].start();
        }

        try {
            for (int n = 0; n < THREAD; n++)
            {
                threads[n].join();
                int[][] x = threads[n].getResult();
                //System.out.println(x.length);
                for (int s = 0; s < ROWS_PER_THREAD; s++)
                {
                    result[n * ROWS_PER_THREAD + s] = x[s];
                }
            }

            for( int r = 0; r < HEIGHT; r++)
            {
                for (int t = 0; t < WIDTH; t++)
                {
                    System.out.printf("%d ",result[r][t]);
                }
                System.out.println();
            }
        } catch (InterruptedException e)
        { throw new RuntimeException(e);
        }
    }
}
