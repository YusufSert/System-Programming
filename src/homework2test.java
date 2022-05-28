import java.util.Arrays;

public class homework2test {
    public static void main(String[] args) {
        int m1[][] = {{1, 2, 3}, {4, 5, 6}, {1, 2, 3}, {4, 5, 6}};

        int[][] int_array = new int[10][10];
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                int_array[i][j] = j;
            }


        System.out.println(int_array[9].length);


    }


}
