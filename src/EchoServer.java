import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.InflaterOutputStream;

public class EchoServer {
    public static void main(String[] args)
    {
        try {
            ServerSocket s = new ServerSocket(8008);
            while (true)
            {
                Socket incoming = s.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(incoming.getOutputStream()));

                //out.println("Hello");
                //out.println("Enter BYE to exit");
                //out.flush();

                while (true)
                {
                    String str = in.readLine();
                    if(str == null)
                        break;

                    System.out.println(incoming.getInetAddress() + "says-> " + str);

                    out.print("Echo: " + str + "\n\r");
                    out.flush();

                    if(str.trim().equals("BYE"))
                        break;
                }
                in.close();
                out.close();
                incoming.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
