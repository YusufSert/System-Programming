import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBytes {
    public static void main (String[] args)
    {
        byte cities[] = {'M', 'e', 'r','y','e','m', '\n'};

        FileOutputStream outFile;
        try {
            outFile = new FileOutputStream("City.txt");
            outFile.write(cities);
            outFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
