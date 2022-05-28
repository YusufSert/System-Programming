import java.io.FileReader;
import java.io.IOException;

public class CountSpace {
    public static void main(String[] args) throws IOException
    {
        FileReader in;
        in = new FileReader("/home/yusufcan/IdeaProjects/System_programming/src/FileIn.txt");
        int ch, total, space;

        space = 0;

        for(total = 0; (ch = in.read()) != -1; total++)
        {
            if(Character.isWhitespace((char)ch))
                space++;
        }
        System.out.println(total + " chars " + space + "space" );
        in.close();
    }
}
