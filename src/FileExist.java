import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileExist {
    public static void main(String[] args)
    {
        String filePath = "/home/yusufcan/IdeaProjects/System_programming/src/FieIn.txt";
        File rdfl = new File(filePath);
        if(rdfl.exists())
        {
            FileReader readfile = null;

            try {
                readfile = new FileReader(rdfl);
                int data;
                while ((data = readfile.read()) != -1)
                    System.out.println((char)data);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    readfile.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else {
            System.out.println("STFU");
        }
    }
}
