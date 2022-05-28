import java.io.*;

public class FileExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File students = new File("/home/yusufcan/Desktop/t.txt");
        RandomAccessFile std_file = null;

        try {
            std_file = new RandomAccessFile(students, "rw");
            boolean found = false;

            byte[] id = new byte[4];
            byte[] rec= new byte[55];
            String idno = null;
            String std_rec = null;

            while (std_file.getFilePointer() <= std_file.length()-2)
            {
                std_file.read(id, 0, 4); // read to array
                idno = new String(id); // convert array to String

                if(idno.equals("6235"))
                {
                    std_file.seek(std_file.getFilePointer()-4);
                    std_file.read(rec, 0, 53);
                    std_rec = new String(rec);
                    found = true;
                }
                if(found)
                    break;

                // Jump to next record (We already read 4 bytes so + 51 for the nex record)
                std_file.seek(std_file.getFilePointer() + 51);
            }
            System.out.println(std_rec);
        }catch (EOFException e) {
            e.printStackTrace();
        }
        finally {
            std_file.close();
        }


    }
}
