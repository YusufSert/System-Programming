import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CountBytes {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        FileInputStream in;
        in = new FileInputStream("/home/yusufcan/IdeaProjects/System_programming/src/InFile.txt");

        int  total = 0;
        int c;
        while((c=in.read()) != -1)
        {
            System.out.println(total + "bytes");
            System.out.println(c);
            total++;
        }
        in.close();

    }
}
