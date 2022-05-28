import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Student
{
    String FilePath;

    Student(String path)
    {
        FilePath = path;
    }

    void modify(String id, String field, String new_value) throws IOException {

        String std_rec = null;
        String[] fields;
        boolean MolehiyaFound = false;
        RandomAccessFile std_file = new RandomAccessFile(new File(FilePath), "rw");

        while (std_file.getFilePointer() <= std_file.length()-2)
        {
            std_rec = std_file.readLine();
            fields = std_rec.split(",");

            if(fields[0].equals(id))
            {
                switch (field) {
                    case "id" -> fields[0] = new_value;
                    case "name" -> fields[1] = new_value;
                    case "cgpa" -> fields[2] = new_value;
                    case "date" -> fields[3] = new_value;
                    case "gndr" -> fields[4] = new_value;
                    default -> System.out.println("Choose Field ");
                }
                std_rec = String.join(",", fields);
                std_file.seek(std_file.getFilePointer()-54);
                std_file.write(std_rec.getBytes(StandardCharsets.UTF_8));
                MolehiyaFound = true;
            }
            if(MolehiyaFound)
                break;
        }
        std_file.close();
    }



    void insert(String stdid, String name, String cgpa, String date, String gender) throws IOException {

        RandomAccessFile std_file = new RandomAccessFile(new File(FilePath), "rw");
        String std_rec;
        String space = " ".repeat(30-name.length());
        std_rec = String.format("%s,%s%s,%s,%s,%s",stdid,name,space,cgpa,date,gender);
        std_file.seek(std_file.length());
        std_file.write(std_rec.getBytes(StandardCharsets.UTF_8));
        std_file.close();
    }

    void delete(String stdid) throws IOException {
        String std_rec = "";
        String new_rec = "";
        String[] fields = null;
        File file = new File(FilePath);
        RandomAccessFile std_file = new RandomAccessFile(file, "rw");

        while (std_file.getFilePointer() <= std_file.length()-2)
        {
            std_rec = std_file.readLine();
            fields = std_rec.split(",");
            if (!(fields[0].equals(stdid))){
                new_rec += String.format("%s\n",std_rec);
            }
        }
        file.delete();
        File myObj = new File(FilePath);
        myObj.createNewFile();
        RandomAccessFile f = new RandomAccessFile(myObj, "rw");
        System.out.println(new_rec);
        std_file.write(new_rec.getBytes(StandardCharsets.UTF_8));
    }

    void display() throws IOException {
        RandomAccessFile std_file = new RandomAccessFile(new File(FilePath), "rw");
        String std_rec = "";
        while (std_file.getFilePointer() <= std_file.length()-2)
        {
            std_rec = std_file.readLine();
            System.out.print(String.format("%s(tab separated)", std_rec));
        }
    }


    void stats() throws IOException {
        RandomAccessFile std_file = new RandomAccessFile(new File(FilePath), "rw");
        RandomAccessFile stats_file = new RandomAccessFile(new File(new File(FilePath).getParent() + "/stats.txt"), "rw"); // Ortalık biraz bu line da garişdı hocam sorru
        String std_rec;
        String[] fields = null;
        Float sum = 0f;
        int count = 0, F = 0, M = 0;
        while (std_file.getFilePointer() <= std_file.length()-2)
        {
            fields = std_file.readLine().split(",");
            if(fields[4].equals("F"))
            {
                F++;
            }else {M++;}

            sum += Float.parseFloat(fields[2]);
            System.out.println(fields[2]);
            count++;
        }
        sum = sum/count;
        stats_file.write(String.format("Number of male is: %s\n", M).getBytes(StandardCharsets.UTF_8));
        stats_file.write(String.format("Number of female is: %s\n", F).getBytes(StandardCharsets.UTF_8));
        stats_file.write(String.format("Number of students: %s\n", count).getBytes(StandardCharsets.UTF_8));
        stats_file.write(String.format("Avarege cgpa is: %s\n", sum).getBytes(StandardCharsets.UTF_8));
    }







    public static void main(String[] args) throws IOException {
        //Student s = new Student("/home/yusufcan/Desktop/student.txt");
        //s.modify("6235","id", "6666");
        //s.insert("1222","Yusuf Can Sert","2.54","25-03-1990","M");
        //s.delete("6221");
        //s.display();
        //s.stats();
    }
}
