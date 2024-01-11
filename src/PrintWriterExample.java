import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {
    public static void main(String[] args)
    {
        File file = new File("/home/yusufcan/IdeaProjects/System_programming/src/PrintWriter.txt");
        FileWriter fw = null;
        PrintWriter pw = null;
        int data1 = 123;
        double data2 = 15.4;
        String data3 = "Hello";

        try {
            fw  = new FileWriter(file);
            pw = new PrintWriter(fw);

            pw.println(data1);
            pw.print(data2);
            pw.print(data3);
            pw.println();
            pw.printf("%d\t%f\t%s", data1, data2, data3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            pw.close();
        }

    }
}
