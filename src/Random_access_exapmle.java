import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Random_access_exapmle {

    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File newfile = new File("/home/yusufcan/Desktop/test.txt");
        RandomAccessFile myfile = new RandomAccessFile(newfile, "rw");

        myfile.writeInt(120);
        myfile.writeDouble(375.50);
        myfile.writeInt('A' + 1);
        myfile.writeBoolean(true);
        myfile.writeChar('X');



        myfile.seek(0); // Long 8 bytes
        System.out.println(myfile.readInt());
        System.out.println(myfile.readDouble());

        // Set pointer to the 4th item

        myfile.seek(16);
        System.out.println(myfile.readBoolean());

        myfile.seek(17); // No need for seek bc already read and move 1 byte WTF hoca
        char c = myfile.readChar();
        myfile.seek(17);
        myfile.writeDouble(3.14);
        myfile.writeChar(c);


        // Go to the end and "append" an integer 2020

        myfile.seek(myfile.length());
        myfile.writeInt(2020);

        myfile.seek(17);
        System.out.println(myfile.readDouble());
        System.out.println(myfile.readChar());
        System.out.println(myfile.readInt());
        System.out.println("File length " + myfile.length());
        System.out.println(c);
        myfile.close();
    }



}
