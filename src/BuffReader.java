import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BuffReader {


    public static void main(String[] args) throws IOException {
        FileReader readfile = null;
        BufferedReader readstream = null;

        try {
            readfile = new FileReader("/home/yusufcan/IdeaProjects/System_programming/src/test.txt");
            readstream = new BufferedReader(readfile);

            String line;

            while ((line = readstream.readLine()) != null)
            {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            readstream.close();
            readfile.close();
        }
    }
}
