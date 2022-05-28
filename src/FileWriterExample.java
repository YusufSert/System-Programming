import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {



    public static void main(String[] args)
    {
        File file = new File("/home/yusufcan/IdeaProjects/System_programming/src/");
        FileWriter fr = null;

        try {
            fr = new FileWriter(file);
            fr.write('A');
            fr.write(67);
            fr.write("456");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
