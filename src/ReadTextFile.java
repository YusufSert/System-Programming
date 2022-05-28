import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        in = new BufferedReader(new FileReader("/home/yusufcan/IdeaProjects/System_programming/src/Command.txt"));

        String line;
        while ((line = in.readLine()) != null)
            System.out.println(line);
        in.close();
    }
}
