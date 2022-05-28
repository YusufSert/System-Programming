import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CountByesNew {
    public static void main(String[] args)
    {
        FileInputStream in;
        try
        {
            in = new FileInputStream("FileIn.txt");
            int total = 0;
            while (in.read() != -1)
                total++;
            System.out.println("Total = " + total);
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

