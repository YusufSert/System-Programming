import java.io.*;

public class PrintWriterAppend {
   public static void main(String[] args)
   {
       File file = new File("/home/yusufcan/IdeaProjects/System_programming/src/Append.txt");
       FileWriter fw = null;
       PrintWriter pw = null;
       int data1 = 123;
       double data2 = 15.4;
       String data3 = "Hello";

       try {
           pw = new PrintWriter(new FileWriter(file, true));
           pw.println(data1);
           pw.println(data2);
           pw.println(data3);
           pw.printf("%d\t%f\t%s", data1, data2, data3);
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }finally {
           pw.close();
       }
   }
}
