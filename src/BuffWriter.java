import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BuffWriter {
    public static void main(String[] args)
    {
        File file2 = new File("/home/yusufcan/IdeaProjects/System_programming/src/BufferedWrite.txt");

        FileWriter fr2 = null;
        BufferedWriter bw = null;
        String data2 = "123456\n";

        int noOfLines = 10;
        try {
            fr2 = new FileWriter(file2);
            bw = new BufferedWriter(fr2);

            for (int i = noOfLines; i > 0; i--)
            {
                bw.write(data2);
                //fr2.write("ff");
            }
            System.out.println(bw.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bw.close();
                fr2.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
